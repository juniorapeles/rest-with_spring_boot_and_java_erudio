package br.com.junior.rest_with_spring_boot_and_java_erudio.services;

import br.com.junior.rest_with_spring_boot_and_java_erudio.controller.PersonController;
import br.com.junior.rest_with_spring_boot_and_java_erudio.data.dto.v1.PersonDTO;
import br.com.junior.rest_with_spring_boot_and_java_erudio.exception.ResourceNotFoundException;
import br.com.junior.rest_with_spring_boot_and_java_erudio.model.Person;
import br.com.junior.rest_with_spring_boot_and_java_erudio.repositories.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.com.junior.rest_with_spring_boot_and_java_erudio.mapper.ObjectMapper.parseListObjects;
import static br.com.junior.rest_with_spring_boot_and_java_erudio.mapper.ObjectMapper.parseObject;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class PersonServices {

    private final Logger logger = LoggerFactory.getLogger(PersonServices.class);
    private final PersonRepository personRepository;

    public PersonServices(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public PersonDTO findById(Long id) {
        logger.info("Finding one Person!");
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        var dto = parseObject(person, PersonDTO.class);
        addHateoasLinks(dto);
        return dto;
    }

    public List<PersonDTO> findAll() {
        logger.info("Finding all People!");
        List<PersonDTO> personDTOS = parseListObjects(personRepository.findAll(), PersonDTO.class);
        personDTOS.forEach(this::addHateoasLinks);
        return personDTOS;
    }

    public PersonDTO create(PersonDTO dto) {
        logger.info("Create one Person!");
        var entity = parseObject(dto, Person.class);
        PersonDTO personDTO = parseObject(personRepository.save(entity), PersonDTO.class);
        addHateoasLinks(personDTO);
        return personDTO;
    }


    public PersonDTO updatePerson(PersonDTO dto) {
        logger.info("Updating one Person!");

        Person entity = personRepository.findById(dto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setAddress(dto.getAddress());
        entity.setGender(dto.getGender());

        PersonDTO personDTO = parseObject(personRepository.save(entity), PersonDTO.class);
        addHateoasLinks(personDTO);
        return personDTO;
    }

    public void delete(Long id) {
        logger.info("Deleting one Person!");
        personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        personRepository.deleteById(id);
    }

    private void addHateoasLinks(PersonDTO dto) {
        dto.add(linkTo(methodOn(PersonController.class).findById(dto.getId())).withSelfRel().withType("GET"));
        dto.add(linkTo(methodOn(PersonController.class).findAll()).withRel("findAll").withType("GET"));
        dto.add(linkTo(methodOn(PersonController.class).create(dto)).withRel("create").withType("POST"));
        dto.add(linkTo(methodOn(PersonController.class).update(dto)).withRel("update").withType("PUT"));
        dto.add(linkTo(methodOn(PersonController.class).delete(dto.getId())).withRel("delete").withType("DELETE"));
    }
}
