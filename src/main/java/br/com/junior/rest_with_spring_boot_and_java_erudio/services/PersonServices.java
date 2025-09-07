package br.com.junior.rest_with_spring_boot_and_java_erudio.services;

import br.com.junior.rest_with_spring_boot_and_java_erudio.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = LoggerFactory.getLogger(PersonServices.class);

    public Person findById(String id) {
        logger.info("Finding one Person!");

        //Mock - TODO: remover mock e adicionar repositório com acesso a base de dados !
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Eli");
        person.setLastName("Francisco");
        person.setAddress("Barueri - São Paulo - Brasil");
        person.setGender("Male");

        return person;
    }
}
