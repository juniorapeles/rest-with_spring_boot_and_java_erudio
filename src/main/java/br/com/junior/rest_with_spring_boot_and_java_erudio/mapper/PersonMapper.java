package br.com.junior.rest_with_spring_boot_and_java_erudio.mapper;

import br.com.junior.rest_with_spring_boot_and_java_erudio.data.dto.v1.PersonDTO;
import br.com.junior.rest_with_spring_boot_and_java_erudio.model.Person;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonDTO parseObject(Person person);

    Person parseObject(PersonDTO dto);

    List<PersonDTO> parseListObjects(List<Person> people);

    List<Person> toEntityList(List<PersonDTO> people);
}
