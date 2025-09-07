package br.com.junior.rest_with_spring_boot_and_java_erudio.controller;

import br.com.junior.rest_with_spring_boot_and_java_erudio.model.Person;
import br.com.junior.rest_with_spring_boot_and_java_erudio.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(PersonController.PATH_URL)
public class PersonController {

    public static final String PATH_URL = "/person";

    @Autowired
    private PersonServices service;

    @RequestMapping(value="/{id}",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    //Path variable é referente a variavel pós a barra
    public Person findById(@PathVariable("id") String id) {
        return service.findById(id);
    }

}
