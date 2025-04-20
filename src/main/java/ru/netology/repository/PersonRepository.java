package ru.netology.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.AllArgsConstructor;
import ru.netology.person.Person;

import java.util.List;

@AllArgsConstructor
@org.springframework.stereotype.Repository
public class PersonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> getPersonsByCity(String city) {
        var resultCity = entityManager.createQuery(
                        "SELECT p FROM Person p WHERE p.city = :city")
                .setParameter("city", city);
        return resultCity.getResultList();
    }
}
