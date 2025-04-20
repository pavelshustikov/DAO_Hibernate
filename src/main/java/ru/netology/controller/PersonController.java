package ru.netology.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.person.Person;
import ru.netology.repository.PersonRepository;

import java.util.List;

@AllArgsConstructor
@RestController
public class PersonController {
    private final PersonRepository repository;

    @GetMapping("/persons/by-city")
    protected List<Person> getPersonsByCity(@RequestParam(value = "city", required = false) String city) {
        return repository.getPersonsByCity(city);
    }

}
