package br.com.junior.rest_with_spring_boot_and_java_erudio.controller;


import br.com.junior.rest_with_spring_boot_and_java_erudio.data.dto.v1.PersonDTO;
import br.com.junior.rest_with_spring_boot_and_java_erudio.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(PersonController.PATH_URL)
public class PersonController {

    public static final String PATH_URL = "api/person/v1";
    public static final String PATH_ID = "/{id}";

    @Autowired
    private PersonServices service;

    @GetMapping(value = PATH_ID, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE})
    public PersonDTO findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE})
    public List<PersonDTO> findAll() {
        return service.findAll();
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE})
    public PersonDTO create(@RequestBody PersonDTO person) {
        return service.create(person);
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE})
    public PersonDTO update(@RequestBody PersonDTO person) {
        return service.updatePerson(person);
    }

    @DeleteMapping(value = PATH_ID)
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
