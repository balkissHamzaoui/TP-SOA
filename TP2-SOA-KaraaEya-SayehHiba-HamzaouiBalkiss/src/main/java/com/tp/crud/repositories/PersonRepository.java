package com.tp.crud.repositories;

import com.tp.crud.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {
    Optional<Person> findPersonByEmail(String email);
}