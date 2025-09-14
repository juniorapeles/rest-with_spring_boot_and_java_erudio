package br.com.junior.rest_with_spring_boot_and_java_erudio.mapper;

import br.com.junior.rest_with_spring_boot_and_java_erudio.data.dto.v1.BookDTO;
import br.com.junior.rest_with_spring_boot_and_java_erudio.model.Book;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookDTO parseObject(Book book);

    Book parseObject(BookDTO dto);

    List<BookDTO> parseListObjects(List<Book> books);

    List<Book> toEntityList(List<BookDTO> books);
}
