package com.tp.crud.controllers;

import com.tp.crud.models.Person;
import com.tp.crud.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(path="api/v1/person")
public class PersonController {

    //Attributes
    private final PersonService personService;

    //Constructor
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    //GET ALL PEOPLE
    @GetMapping
    public List<Person> getAllPeople(){return personService.getAllPeople();}

    //GET PERSON BY ID
    @GetMapping(path="{personId}")
    Person getPersonById(@PathVariable Long personId){
        return personService.getPersonById(personId);
    }

    //ADD NEW PERSON
    @PostMapping
    public Person addPerson(@Valid @RequestBody Person person){
        personService.addPerson(person);
        return person;
    }

    //DELETE A PERSON
    @DeleteMapping(path="{personId}")
    public void deletePerson(@PathVariable Long personId){
        personService.deletePerson(personId);
    }

    //UPDATE A PERSON
    @PutMapping(path="{personId}")
    public void updatePersdon(
            @PathVariable Long personId,
            @RequestBody Person person){
        personService.updatePerson(personId,person);
    }

}
