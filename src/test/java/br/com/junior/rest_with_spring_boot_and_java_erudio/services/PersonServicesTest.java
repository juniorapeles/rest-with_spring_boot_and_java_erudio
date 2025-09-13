package br.com.junior.rest_with_spring_boot_and_java_erudio.services;

import br.com.junior.rest_with_spring_boot_and_java_erudio.data.dto.v1.PersonDTO;
import br.com.junior.rest_with_spring_boot_and_java_erudio.exception.RequiredObjectIsNullException;
import br.com.junior.rest_with_spring_boot_and_java_erudio.mapper.PersonMapper;
import br.com.junior.rest_with_spring_boot_and_java_erudio.mapper.PersonMapperImpl;
import br.com.junior.rest_with_spring_boot_and_java_erudio.mapper.mocks.MockPerson;
import br.com.junior.rest_with_spring_boot_and_java_erudio.model.Person;
import br.com.junior.rest_with_spring_boot_and_java_erudio.repositories.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class PersonServicesTest {

    private MockPerson input;

    @InjectMocks
    private PersonServices personServices;

    @Mock
    private PersonMapper mapper;

    @Mock
    private PersonRepository repository;

    @BeforeEach
    void setUp() {
        input = new MockPerson();
        MockitoAnnotations.openMocks(this);
        mapper = new PersonMapperImpl();
    }

    @Test
    void findById() {
        Person person = input.mockEntity(1);
        person.setId(1L);
        when(repository.findById(1L)).thenReturn(Optional.of(person));

        var result = personServices.findById(1L);

        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getLinks());
        assertEquals("Address Test1", result.getAddress());
        assertEquals("Female", result.getGender());
        assertEquals("First Name Test1", result.getFirstName());
        assertEquals("Last Name Test1", result.getLastName());
    }

    @Test
    void create() {
        Person person = input.mockEntity(1);
        Person persisted = person;
        persisted.setId(1L);

        PersonDTO dto = input.mockDTO(1);

        when(repository.save(any(Person.class))).thenReturn(persisted);

        var result = personServices.create(dto);

        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getLinks());
        assertEquals("Address Test1", result.getAddress());
        assertEquals("Female", result.getGender());
        assertEquals("First Name Test1", result.getFirstName());
        assertEquals("Last Name Test1", result.getLastName());
    }

    @Test
    void testCreateWithNullPerson() {
        Exception exception = assertThrows(RequiredObjectIsNullException.class,
                () -> personServices.create(null));
        String expectedMessage = "It is not allowed to persist a null object!";
        assertTrue(exception.getMessage().contains(expectedMessage));
    }

    @Test
    void updatePerson() {
        Person person = input.mockEntity(1);
        Person persisted = person;
        persisted.setId(1L);

        PersonDTO dto = input.mockDTO(1);

        when(repository.save(any(Person.class))).thenReturn(persisted);

        var result = personServices.updatePerson(dto);

        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getLinks());
        assertEquals("Address Test1", result.getAddress());
        assertEquals("Female", result.getGender());
        assertEquals("First Name Test1", result.getFirstName());
        assertEquals("Last Name Test1", result.getLastName());
    }

    @Test
    void testUpdateWithNullPerson() {
        Exception exception = assertThrows(RequiredObjectIsNullException.class,
                () -> personServices.updatePerson(null));
        String expectedMessage = "It is not allowed to persist a null object!";
        assertTrue(exception.getMessage().contains(expectedMessage));
    }

    @Test
    void delete() {
        Person person = input.mockEntity(1);
        person.setId(1L);
        when(repository.findById(1L)).thenReturn(Optional.of(person));
        personServices.delete(1L);
        verify(repository, times(1)).delete(any(Person.class));
    }

    @Test
    void findAll() {
        List<Person> list = input.mockEntityList();
        when(repository.findAll()).thenReturn(list);
        List<PersonDTO> people = personServices.findAll();

        assertNotNull(people);
        assertEquals(14, people.size());
    }
}
