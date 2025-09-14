package br.com.junior.rest_with_spring_boot_and_java_erudio.services;

import br.com.junior.rest_with_spring_boot_and_java_erudio.controller.BookController;
import br.com.junior.rest_with_spring_boot_and_java_erudio.data.dto.v1.BookDTO;
import br.com.junior.rest_with_spring_boot_and_java_erudio.mapper.BookMapper;
import br.com.junior.rest_with_spring_boot_and_java_erudio.model.Book;
import br.com.junior.rest_with_spring_boot_and_java_erudio.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    @Autowired
    private BookMapper mapper;

    public BookDTO findById(Long id) {
        Book book = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id " + id));


        BookDTO bookDTO = mapper.parseObject(book);
        addHateoasLinks(bookDTO);

        return bookDTO;
    }

    public List<BookDTO> findAll() {
        List<BookDTO> collect = repository.findAll()
                .stream()
                .map(mapper::parseObject)
                .collect(Collectors.toList());
        collect.forEach(this::addHateoasLinks);
        return collect;
    }

    public BookDTO create(BookDTO dto) {
        Book book = mapper.parseObject(dto);
        Book saved = repository.save(book);
        BookDTO bookDTO = mapper.parseObject(saved);
        addHateoasLinks(bookDTO);
        return bookDTO;
    }

    public BookDTO updateBook(BookDTO dto) {
        Book book = repository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Book not found with id " + dto.getId()));
        Book updatedBook = mapper.parseObject(dto);
        updatedBook.setId(book.getId());
        Book saved = repository.save(updatedBook);
        BookDTO bookDTO = mapper.parseObject(saved);
        addHateoasLinks(bookDTO);
        return bookDTO;
    }

    public void delete(Long id) {
        Book book = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id " + id));
        repository.delete(book);
    }

    private void addHateoasLinks(BookDTO dto) {
        dto.add(linkTo(methodOn(BookController.class).findById(dto.getId())).withSelfRel().withType("GET"));
        dto.add(linkTo(methodOn(BookController.class).findAll()).withRel("findAll").withType("GET"));
        dto.add(linkTo(methodOn(BookController.class).create(dto)).withRel("create").withType("POST"));
        dto.add(linkTo(methodOn(BookController.class).update(dto)).withRel("update").withType("PUT"));
        dto.add(linkTo(methodOn(BookController.class).delete(dto.getId())).withRel("delete").withType("DELETE"));
    }
}
