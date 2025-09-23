package br.com.junior.rest_with_spring_boot_and_java_erudio.services;

import br.com.junior.rest_with_spring_boot_and_java_erudio.data.dto.v1.BookDTO;
import br.com.junior.rest_with_spring_boot_and_java_erudio.mapper.BookMapper;
import br.com.junior.rest_with_spring_boot_and_java_erudio.mapper.mocks.MockBook;
import br.com.junior.rest_with_spring_boot_and_java_erudio.model.Book;
import br.com.junior.rest_with_spring_boot_and_java_erudio.repositories.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    private MockBook input;

    @InjectMocks
    private BookService bookService;

    @Mock
    BookRepository repository;

    @BeforeEach
    void setUp() {
        input = new MockBook();

        MockitoAnnotations.initMocks(this);
        BookMapper mapper = Mappers.getMapper(BookMapper.class);

        bookService = new BookService(repository, mapper);
    }


    @Test
    void findById() {
        Book book = input.mockEntity(1);
        book.setId(1L);
        when(repository.findById(1L)).thenReturn(Optional.of(book));

        var result = bookService.findById(1L);

        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getLinks());
        assertEquals("Author Test 1", result.getAuthor());
        assertEquals("Title Test 1", result.getTitle());
        assertEquals(LocalDateTime.of(2020, 1, 2, 0, 0), result.getLaunchDate());
        assertEquals(BigDecimal.valueOf(21), result.getPrice());
    }

    @Test
    void findAll() {
        List<Book> list = input.mockEntityList();
        when(repository.findAll()).thenReturn(list);
        List<BookDTO> books = bookService.findAll();

        assertNotNull(books);
        assertEquals(14, books.size());

        var bookOne = books.get(1);

        assertNotNull(bookOne);
        assertNotNull(bookOne.getId());
        assertNotNull(bookOne.getLinks());
        String path1 = "api/books/v1/1";
        bookOne.getLinks().stream()
                .anyMatch(link -> link.getRel().value().equals("self")
                        && link.getHref().endsWith(path1)
                        && link.getType().equals("GET")
                );


        String path = "/api/person/v1";

        assertNotNull(bookOne.getLinks().stream()
                .anyMatch(link -> link.getRel().value().equals("findAll")
                        && link.getHref().endsWith(path)
                        && link.getType().equals("GET")
                )
        );

        assertNotNull(bookOne.getLinks().stream()
                .anyMatch(link -> link.getRel().value().equals("create")
                        && link.getHref().endsWith(path)
                        && link.getType().equals("POST")
                )
        );

        assertNotNull(bookOne.getLinks().stream()
                .anyMatch(link -> link.getRel().value().equals("update")
                        && link.getHref().endsWith(path)
                        && link.getType().equals("PUT")
                )
        );

        assertNotNull(bookOne.getLinks().stream()
                .anyMatch(link -> link.getRel().value().equals("delete")
                        && link.getHref().endsWith(path1)
                        && link.getType().equals("DELETE")
                )
        );

        assertEquals("Author Test 1", bookOne.getAuthor());
        assertEquals("Title Test 1", bookOne.getTitle());
        assertEquals(LocalDateTime.of(2020, 1, 2, 0, 0), bookOne.getLaunchDate());
        assertEquals(BigDecimal.valueOf(21), bookOne.getPrice());

        var bookFour = books.get(4);

        assertNotNull(bookFour);
        assertNotNull(bookFour.getId());
        assertNotNull(bookFour.getLinks());

        assertNotNull(bookFour.getLinks().stream()
                .anyMatch(link -> link.getRel().value().equals("findAll")
                        && link.getHref().endsWith(path)
                        && link.getType().equals("GET")
                )
        );

        assertNotNull(bookFour.getLinks().stream()
                .anyMatch(link -> link.getRel().value().equals("create")
                        && link.getHref().endsWith(path)
                        && link.getType().equals("POST")
                )
        );

        assertNotNull(bookFour.getLinks().stream()
                .anyMatch(link -> link.getRel().value().equals("update")
                        && link.getHref().endsWith(path)
                        && link.getType().equals("PUT")
                )
        );

        assertNotNull(bookFour.getLinks().stream()
                .anyMatch(link -> link.getRel().value().equals("delete")
                        && link.getHref().endsWith(path1)
                        && link.getType().equals("DELETE")
                )
        );

        assertEquals("Author Test 4", bookFour.getAuthor());
        assertEquals("Title Test 4", bookFour.getTitle());
        assertEquals(LocalDateTime.of(2020, 1, 5, 0, 0), bookFour.getLaunchDate()); // 2020-01-01 + 4 dias
        assertEquals(BigDecimal.valueOf(24), bookFour.getPrice());

        var bookSeven = books.get(7);

        assertNotNull(bookSeven);
        assertNotNull(bookSeven.getId());
        assertNotNull(bookSeven.getLinks());

        assertNotNull(bookSeven.getLinks().stream()
                .anyMatch(link -> link.getRel().value().equals("findAll")
                        && link.getHref().endsWith(path)
                        && link.getType().equals("GET")
                )
        );

        assertNotNull(bookSeven.getLinks().stream()
                .anyMatch(link -> link.getRel().value().equals("create")
                        && link.getHref().endsWith(path)
                        && link.getType().equals("POST")
                )
        );

        assertNotNull(bookSeven.getLinks().stream()
                .anyMatch(link -> link.getRel().value().equals("update")
                        && link.getHref().endsWith(path)
                        && link.getType().equals("PUT")
                )
        );

        assertNotNull(bookSeven.getLinks().stream()
                .anyMatch(link -> link.getRel().value().equals("delete")
                        && link.getHref().endsWith(path1)
                        && link.getType().equals("DELETE")
                )
        );

        assertEquals("Author Test 7", bookSeven.getAuthor());
        assertEquals("Title Test 7", bookSeven.getTitle());
        assertEquals(LocalDateTime.of(2020, 1, 8, 0, 0), bookSeven.getLaunchDate()); // 2020-01-01 + 4 dias
        assertEquals(BigDecimal.valueOf(27), bookSeven.getPrice());

    }

    @Test
    void create() {
        Book book = input.mockEntity(1);
        Book persisted = book;
        persisted.setId(1L);

        BookDTO dto = input.mockDTO(1);

        when(repository.save(any(Book.class))).thenReturn(persisted);

        var result = bookService.create(dto);

        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getLinks());
        assertEquals("Author Test 1", result.getAuthor());
        assertEquals("Title Test 1", result.getTitle());
        //assertEquals("First Name Test1", result.getLaunchDate());
        //assertEquals("Last Name Test1", result.getPrice());
    }

    @Test
    void updateBook() {
        Book Book = input.mockEntity(1);
        Book persisted = Book;
        persisted.setId(1L);

        BookDTO dto = input.mockDTO(1);
        when(repository.findById(1L)).thenReturn(Optional.of(Book));
        when(repository.save(any(Book.class))).thenReturn(persisted);

        var result = bookService.updateBook(dto);

        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getLinks());
        assertEquals("Author Test 1", result.getAuthor());
        assertEquals("Title Test 1", result.getTitle());
        //assertEquals("First Name Test1", result.getLaunchDate());
        //assertEquals("Last Name Test1", result.getPrice());
    }

    @Test
    void delete() {
        Book book = input.mockEntity(1);
        book.setId(1L);
        when(repository.findById(1L)).thenReturn(Optional.of(book));

        bookService.delete(1L);
        verify(repository, times(1)).findById(1L);
        verify(repository, times(1)).delete(book);
        verifyNoMoreInteractions(repository);
    }
}