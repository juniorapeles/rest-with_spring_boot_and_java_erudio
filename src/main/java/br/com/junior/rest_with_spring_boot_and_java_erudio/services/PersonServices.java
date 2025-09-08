package br.com.junior.rest_with_spring_boot_and_java_erudio.services;

import br.com.junior.rest_with_spring_boot_and_java_erudio.data.dto.PersonDTO;
import br.com.junior.rest_with_spring_boot_and_java_erudio.exception.ResourceNotFoundException;
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

    public PersonDTO findById(Long id) {
        logger.info("Finding one Person!");

        Person person = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        return parseObject(person, PersonDTO.class);
    }

    public List<PersonDTO> findAll() {
        logger.info("Finding all People!");
        return parseListObjects(personRepository.findAll(), PersonDTO.class);
    }

    public PersonDTO create(PersonDTO dto) {
        logger.info("Create one Person!");
        var entity = parseObject(dto, Person.class);
        return parseObject(personRepository.save(entity), PersonDTO.class);
    }

    public PersonDTO updatePerson(PersonDTO dto) {
        logger.info("Updating one Person!");

        Person entity = personRepository.findById(dto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setAddress(dto.getAddress());
        entity.setGender(dto.getGender());

        return parseObject(personRepository.save(entity), PersonDTO.class);
    }

    public void delete(Long id) {
        logger.info("Deleting one Person!");
        personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        personRepository.deleteById(id);
    }
}
