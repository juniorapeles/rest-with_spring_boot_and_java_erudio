package br.com.junior.rest_with_spring_boot_and_java_erudio.controller;

import br.com.junior.rest_with_spring_boot_and_java_erudio.data.dto.v1.BookDTO;
import br.com.junior.rest_with_spring_boot_and_java_erudio.services.BookService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @CrossOrigin(origins = "http://localhost:8080") // a nivel de controller somente para aquele endereço
@RestController
@RequestMapping(BookController.PATH_URL)
@Tag(name = "Books", description = "Endpoints for Managing Books")
public class BookController implements BookControllerDocs {

    public static final String PATH_URL = "api/book/v1";
    public static final String PATH_ID = "/{id}";

    @Autowired
    private BookService service;

    @GetMapping(value = PATH_ID,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_YAML_VALUE})
    @Override
    public BookDTO findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_YAML_VALUE})
    @Override
    public List<BookDTO> findAll() {
        return service.findAll();
    }

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE})
    @Override
    public BookDTO create(@RequestBody BookDTO book) {
        return service.create(book);
    }

    @PutMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE})
    @Override
    public BookDTO update(@RequestBody BookDTO book) {
        return service.updateBook(book);
    }

    @DeleteMapping(value = PATH_ID)
    @Override
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
