package br.com.junior.rest_with_spring_boot_and_java_erudio.services;

import br.com.junior.rest_with_spring_boot_and_java_erudio.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = LoggerFactory.getLogger(PersonServices.class);

    public Person findById(String id) {
        logger.info("Finding one Person!");
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Eli");
        person.setLastName("Francisco");
        person.setAddress("Barueri - São Paulo - Brasil");
        person.setGender("Male");

        return person;
    }

    public List<Person> findAll() {
        logger.info("Finding all People!");

        //Mock - TODO: remover mock e adicionar repositório com acesso a base de dados !
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Person person = new Person();
            persons.add(mockPerson(i));
        }

        return persons;
    }

    public Person create(Person person) {
        logger.info("Create one Person!");
        return person;
    }

    public Person updatePerson(Person person) {

        logger.info("Updating one Person!");

        return person;
    }

    public void delete(String id) {
        logger.info("Deleting one Person!");
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Firstname " + i);
        person.setLastName("Lastname " + i);
        person.setAddress("Some Address in Brazil");
        person.setGender("Male");
        return person;
    }
}
