package com.tp.crud.services;

import com.tp.crud.models.Person;
import com.tp.crud.repositories.PersonRepository;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service(value="personservice")
public class PersonService {

    //Attributes
    private final PersonRepository personRepository;

    //Constructor
    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    //GET ALL PEOPLE
    public List<Person> getAllPeople(){
        return personRepository.findAll();
    }

    //GET PERSON BY ID
    public Person getPersonById(Long id){
        return personRepository.findById(id)
                .orElseThrow(()-> new IllegalStateException("PERSON WITH ID "+id+" DOES NOT EXIST"));
    }

    //ADD NEW PERSON
    public void addPerson(Person person){
        Optional<Person> personOptional=personRepository.findPersonByEmail(person.getEmail());
        if(personOptional.isPresent()){
            throw new IllegalStateException("EMAIL ALREADY IN USE");
        }
        personRepository.save(person);
    }

    //DELETE PERSON
    public void deletePerson(Long id){
        Optional<Person> personOptional=personRepository.findById(id);
        if(!personOptional.isPresent()){
            throw new IllegalStateException("PERSON DOES NOT EXIST");
        }
        personRepository.deleteById(id);
    }

    //UPDATE A PERSON
    public void updatePerson(Long id,Person person){
        Person personToUpdate=personRepository.findById(id).orElseThrow(()->new IllegalStateException(
                " PERSON WITH ID"+ id +" DOES NOT EXIST"
        ));

        if(person.getName()!=null && personToUpdate.getName().length()>0 &&
                !Objects.equals(person.getName(),personToUpdate.getName())){
            personToUpdate.setName(person.getName());
        }

        if(person.getFamName()!=null && personToUpdate.getFamName().length()>0 &&
                !Objects.equals(person.getFamName(),personToUpdate.getFamName())){
            personToUpdate.setFamName(person.getFamName());
        }

        if(person.getEmail()!=null && personToUpdate.getEmail().length()>0 &&
                !Objects.equals(person.getEmail(),personToUpdate.getEmail())){
            personToUpdate.setEmail(person.getEmail());
        }

        personRepository.save(personToUpdate);
    }

}
