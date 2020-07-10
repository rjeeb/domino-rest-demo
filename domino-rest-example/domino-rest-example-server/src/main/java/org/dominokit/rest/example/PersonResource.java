package org.dominokit.rest.example;

import org.dominokit.rest.example.shared.Person;
import org.dominokit.rest.example.shared.PersonService;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.Path;
import java.util.List;
import java.util.stream.Collectors;

@Path("/service/api/persons")
public class PersonResource implements PersonService {

    @Inject
    EntityManager entityManager;

    @Override
    @Transactional
    public Person create(Person person) {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setFirstName(person.getFirstName());
        personEntity.setLastName(person.getLastName());
        entityManager.persist(personEntity);
        return toPerson(personEntity);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        PersonEntity personEntity = entityManager.find(PersonEntity.class, id);
        entityManager.remove(personEntity);
    }

    @Override
    @Transactional
    public Person update(Long id, Person person) {
        PersonEntity personEntity = entityManager.find(PersonEntity.class, id);
        personEntity.setFirstName(person.getFirstName());
        personEntity.setLastName(person.getLastName());
        personEntity = entityManager.merge(personEntity);
        return toPerson(personEntity);
    }

    @Override
    public List<Person> list() {
        List<PersonEntity> entities = entityManager.createQuery("from PersonEntity").getResultList();
        return entities.stream()
                .map(this::toPerson)
                .collect(Collectors.toList());
    }

    private Person toPerson(PersonEntity personEntity) {
        Person person = new Person();
        person.setId(personEntity.getId());
        person.setFirstName(personEntity.getFirstName());
        person.setLastName(personEntity.getLastName());
        return person;
    }

    @Override
    public Person load(Long id) {
        return toPerson(entityManager.find(PersonEntity.class, id));
    }
}