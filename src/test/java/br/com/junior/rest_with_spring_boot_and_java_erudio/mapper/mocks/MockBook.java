package br.com.junior.rest_with_spring_boot_and_java_erudio.mapper.mocks;

import br.com.junior.rest_with_spring_boot_and_java_erudio.data.dto.v1.BookDTO;
import br.com.junior.rest_with_spring_boot_and_java_erudio.model.Book;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MockBook {
    public Book mockEntity() {
        return mockEntity(0);
    }

    public BookDTO mockDTO() {
        return mockDTO(0);
    }

    public List<Book> mockEntityList() {
        List<Book> Books = new ArrayList<Book>();
        for (int i = 0; i < 14; i++) {
            Books.add(mockEntity(i));
        }
        return Books;
    }

    public List<BookDTO> mockDTOList() {
        List<BookDTO> Books = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            Books.add(mockDTO(i));
        }
        return Books;
    }

    public Book mockEntity(Integer number) {
        Book book = new Book();
        book.setId(number.longValue());
        book.setAuthor("Author Test " + number);
        book.setTitle("Title Test " + number);
        book.setLaunchDate(LocalDateTime.of(2020, 1, 1, 0, 0).plusDays(number));
        book.setPrice(BigDecimal.valueOf(20 + number));
        return book;
    }


    public BookDTO mockDTO(Integer number) {
        BookDTO book = new BookDTO();
        book.setId(number.longValue());
        book.setAuthor("Author Test " + number);
        book.setTitle("Title Test " + number);
        book.setLaunchDate(LocalDateTime.of(2020, 1, 1, 0, 0).plusDays(number));
        book.setPrice(BigDecimal.valueOf(20 + number));
        return book;
    }
}
