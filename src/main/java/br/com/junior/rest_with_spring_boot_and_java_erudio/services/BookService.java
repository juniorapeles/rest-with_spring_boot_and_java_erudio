package br.com.junior.rest_with_spring_boot_and_java_erudio.services;

import br.com.junior.rest_with_spring_boot_and_java_erudio.data.dto.v1.BookDTO;
import br.com.junior.rest_with_spring_boot_and_java_erudio.mapper.BookMapper;
import br.com.junior.rest_with_spring_boot_and_java_erudio.model.Book;
import br.com.junior.rest_with_spring_boot_and_java_erudio.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    @Autowired
    private BookMapper mapper;

    public BookDTO findById(Long id) {
        Book book = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id " + id));
        return mapper.parseObject(book);
    }

    public List<BookDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::parseObject)
                .collect(Collectors.toList());
    }

    public BookDTO create(BookDTO dto) {
        Book book = mapper.parseObject(dto);
        Book saved = repository.save(book);
        return mapper.parseObject(saved);
    }

    public BookDTO updateBook(BookDTO dto) {
        Book book = repository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Book not found with id " + dto.getId()));
        Book updatedBook = mapper.parseObject(dto);
        updatedBook.setId(book.getId()); // garante que o ID não será alterado
        Book saved = repository.save(updatedBook);
        return mapper.parseObject(saved);
    }

    public void delete(Long id) {
        Book book = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id " + id));
        repository.delete(book);
    }
}
