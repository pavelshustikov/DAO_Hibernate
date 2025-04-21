package ru.netology.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.person.Person;
import ru.netology.repository.Repository;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {
    private final Repository personRepository;

    public Controller(Repository personRepository) {
        this.personRepository = personRepository;
    }

    // Получение людей по городу
    @GetMapping("/persons/by-city")
    public List<Person> getPersonsByCity(@RequestParam String city) {
        return personRepository.findByCity(city);
    }

    // Получение людей младше определенного возраста
    @GetMapping("/persons/by-age")
    public List<Person> getPersonsByAgeLessThan(@RequestParam int age) {
        return personRepository.findByAgeLessThanOrderByAgeAsc(age);
    }

    // Получение человека по имени и фамилии
    @GetMapping("/persons/by-name-and-surname")
    public Optional<Person> getPersonByNameAndSurname(@RequestParam String name, @RequestParam String surname) {
        return personRepository.findByNameAndSurname(name, surname);
    }
}