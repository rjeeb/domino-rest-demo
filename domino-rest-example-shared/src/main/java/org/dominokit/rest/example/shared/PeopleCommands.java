package org.dominokit.rest.example.shared;

import org.dominokit.domino.rest.shared.request.FailedResponseBean;

import java.util.List;
import java.util.function.Consumer;

public class PeopleCommands {

    public void listPeople(Consumer<List<Person>> peopleConsumer, Consumer<FailedResponseBean> failedConsumer) {
        PersonServiceFactory.INSTANCE
                .list()
                .onSuccess(peopleConsumer::accept)
                .onFailed(failedConsumer::accept)
                .send();
    }

    public void loadPerson(Long id, Consumer<Person> personConsumer, Consumer<FailedResponseBean> failedConsumer) {
        PersonServiceFactory.INSTANCE
                .load(id)
                .onSuccess(personConsumer::accept)
                .onFailed(failedConsumer::accept)
                .send();
    }

    public void createPerson(Person person, Consumer<Person> personConsumer, Consumer<FailedResponseBean> failedConsumer) {
        PersonServiceFactory.INSTANCE
                .create(person)
                .onSuccess(personConsumer::accept)
                .onFailed(failedConsumer::accept)
                .send();
    }

    public void updatePerson(Person person, Consumer<Person> personConsumer, Consumer<FailedResponseBean> failedConsumer) {
        PersonServiceFactory.INSTANCE
                .update(person.getId(), person)
                .onSuccess(personConsumer::accept)
                .onFailed(failedConsumer::accept)
                .send();
    }

    public void deletePerson(Long id, Consumer<Void> deleteConsumer, Consumer<FailedResponseBean> failedConsumer) {
        PersonServiceFactory.INSTANCE
                .delete(id)
                .onSuccess(deleteConsumer::accept)
                .onFailed(failedConsumer::accept)
                .send();
    }
}
