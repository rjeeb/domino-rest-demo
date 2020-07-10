package org.dominokit.rest.example.client.presenters;

import org.dominokit.domino.api.client.annotations.presenter.*;
import org.dominokit.domino.api.client.mvp.presenter.ViewBaseClientPresenter;
import org.dominokit.domino.api.shared.extension.PredefinedSlots;
import org.dominokit.rest.example.client.views.LayoutView;
import org.dominokit.rest.example.shared.PeopleCommands;
import org.dominokit.rest.example.shared.Person;
import org.dominokit.rest.example.shared.events.LayoutEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Collectors;

@PresenterProxy
@AutoRoute(token = "home")
@Slot(PredefinedSlots.BODY_SLOT)
@AutoReveal
@OnStateChanged(LayoutEvent.class)
public class LayoutProxy extends ViewBaseClientPresenter<LayoutView> implements LayoutView.LayoutUiHandlers {

  private static final Logger LOGGER = LoggerFactory.getLogger(LayoutProxy.class);
  private final PeopleCommands peopleCommands = new PeopleCommands();

  @OnReveal
  public void onLayoutRevealed() {
    LOGGER.info("Layout view revealed");
  }

  @Override
  public void onList() {
    peopleCommands.listPeople(people -> {
      String collect = people.stream()
        .map(Person::toString)
        .collect(Collectors.joining("\n"));
      view.setValue(collect);
    }, failedResponseBean -> {
      view.setValue(failedResponseBean.getBody());
    });
  }

  @Override
  public void onLoad(long id) {
    peopleCommands.loadPerson(id, person -> {
      view.setValue(person.toString());
    }, failedResponseBean -> {
      view.setValue(failedResponseBean.getBody());
    });
  }

  @Override
  public void onCreate(String firstName, String lastName) {
    Person person = new Person();
    person.setFirstName(firstName);
    person.setLastName(lastName);
    peopleCommands.createPerson(person, created -> {
      view.setValue(created.toString());
    }, failedResponseBean -> {
      view.setValue(failedResponseBean.getBody());
    });
  }

  @Override
  public void onUpdate(Long id, String firstName, String lastName) {
    Person person = new Person();
    person.setId(id);
    person.setFirstName(firstName);
    person.setLastName(lastName);
    peopleCommands.updatePerson(person, updated -> {
      view.setValue(updated.toString());
    }, failedResponseBean -> {
      view.setValue(failedResponseBean.getBody());
    });
  }

  @Override
  public void onDelete(Long id) {
    peopleCommands.deletePerson(id, aVoid -> {
      view.setValue("person deleted successfully");
    }, failedResponseBean -> {
      view.setValue(failedResponseBean.getBody());
    });
  }
}
