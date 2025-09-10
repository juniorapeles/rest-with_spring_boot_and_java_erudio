package br.com.junior.rest_with_spring_boot_and_java_erudio.services;

import br.com.junior.rest_with_spring_boot_and_java_erudio.data.dto.v1.PersonDTOV1;
import br.com.junior.rest_with_spring_boot_and_java_erudio.exception.ResourceNotFoundException;
import br.com.junior.rest_with_spring_boot_and_java_erudio.mapper.custom.PersonMapper;
import br.com.junior.rest_with_spring_boot_and_java_erudio.model.Person;
import br.com.junior.rest_with_spring_boot_and_java_erudio.repositories.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static br.com.junior.rest_with_spring_boot_and_java_erudio.mapper.ObjectMapper.parseListObjects;
import static br.com.junior.rest_with_spring_boot_and_java_erudio.mapper.ObjectMapper.parseObject;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = LoggerFactory.getLogger(PersonServices.class);

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonMapper converter;

    public PersonDTOV1 findById(Long id) {
        logger.info("Finding one Person!");

        Person person = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        return parseObject(person, PersonDTOV1.class);
    }

    public List<PersonDTOV1> findAll() {
        logger.info("Finding all People!");
        return parseListObjects(personRepository.findAll(), PersonDTOV1.class);
    }

    public PersonDTOV1 create(PersonDTOV1 dto) {
        logger.info("Create one Person!");
        var entity = parseObject(dto, Person.class);
        return parseObject(personRepository.save(entity), PersonDTOV1.class);
    }


    public PersonDTOV1 updatePerson(PersonDTOV1 dto) {
        logger.info("Updating one Person!");

        Person entity = personRepository.findById(dto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setAddress(dto.getAddress());
        entity.setGender(dto.getGender());

        return parseObject(personRepository.save(entity), PersonDTOV1.class);
    }

    public void delete(Long id) {
        logger.info("Deleting one Person!");
        personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        personRepository.deleteById(id);
    }
}
