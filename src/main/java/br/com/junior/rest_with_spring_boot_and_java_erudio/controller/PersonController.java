package br.com.junior.rest_with_spring_boot_and_java_erudio.controller;


import br.com.junior.rest_with_spring_boot_and_java_erudio.data.dto.v1.PersonDTOV1;
import br.com.junior.rest_with_spring_boot_and_java_erudio.data.dto.v2.PersonDTOV2;
import br.com.junior.rest_with_spring_boot_and_java_erudio.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(PersonController.PATH_URL)
public class PersonController {

    public static final String PATH_URL = "/person/v1";
    public static final String PATH_ID = "/{id}";

    @Autowired
    private PersonServices service;

    @GetMapping(value = PATH_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTOV1 findById(@PathVariable("id") Long id) {

        PersonDTOV1 person = service.findById(id);
        person.setBirthDay(new Date());
        person.setPhoneNumber("");
        person.setLastName(null);
        person.setSensitiveData("Foo Bar");
//        person.setPhoneNumber("+55 (11) 953072425");
        return person;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonDTOV1> findAll() {
        return service.findAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTOV1 create(@RequestBody PersonDTOV1 person) {
        return service.create(person);
    }

    @PostMapping(value = "/v2",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTOV2 create(@RequestBody PersonDTOV2 person) {
        return service.createV2(person);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTOV1 update(@RequestBody PersonDTOV1 person) {
        return service.updatePerson(person);
    }

    @DeleteMapping(value = PATH_ID)
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
