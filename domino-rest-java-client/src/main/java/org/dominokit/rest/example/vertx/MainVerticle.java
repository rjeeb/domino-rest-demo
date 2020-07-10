package org.dominokit.rest.example.vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Handler;
import io.vertx.core.Promise;
import org.dominokit.rest.example.shared.PeopleCommands;
import org.dominokit.rest.example.shared.Person;

import java.util.Scanner;

public class MainVerticle extends AbstractVerticle implements Handler<Long> {

  private final Scanner scanner = new Scanner(System.in);
  private final PeopleCommands peopleCommands = new PeopleCommands();

  @Override
  public void start() {
    VertxContext.vertx = vertx;
    startTimer();
  }

  private void startTimer() {
    vertx.setTimer(1, this);
  }

  @Override
  public void handle(Long aLong) {
    vertx.executeBlocking(promise -> {
      System.out.println("1- list persons");
      System.out.println("2- load person");
      System.out.println("3- create person");
      System.out.println("4- update person");
      System.out.println("5- delete person");
      System.out.println("6- exit");
      int command = scanner.nextInt();
      switch (command) {
        case 1:
          listPersons(promise);
          break;
        case 2:
          loadPerson(promise);
          break;
        case 3:
          createPerson(promise);
          break;
        case 4:
          updatePerson(promise);
          break;
        case 5:
          deletePerson(promise);
          break;
        default:
          System.exit(0);
      }
    }, asyncResult -> startTimer());
  }

  private void deletePerson(Promise<Object> promise) {
    System.out.println("person id: ");
    long id = scanner.nextLong();
    peopleCommands.deletePerson(id, aVoid -> {
      System.out.println("person deleted");
      promise.complete();
    }, failedResponseBean -> {
      System.out.println("Error while sending request " + failedResponseBean.getBody());
      promise.complete();
    });
  }

  private void updatePerson(Promise<Object> promise) {
    System.out.println("person id: ");
    long id = scanner.nextLong();
    System.out.println("first name: ");
    String firstName = scanner.next();
    System.out.println("last name: ");
    String lastName = scanner.next();
    Person person = new Person();
    person.setId(id);
    person.setFirstName(firstName);
    person.setLastName(lastName);
    peopleCommands.updatePerson(person, updated -> {
      System.out.println(updated);
      promise.complete();
    }, failedResponseBean -> {
      System.out.println("Error while sending request " + failedResponseBean.getBody());
      promise.complete();
    });
  }

  private void createPerson(Promise<Object> promise) {
    System.out.println("first name: ");
    String firstName = scanner.next();
    System.out.println("last name: ");
    String lastName = scanner.next();
    Person person = new Person();
    person.setFirstName(firstName);
    person.setLastName(lastName);
    peopleCommands.createPerson(person, created -> {
      System.out.println(created);
      promise.complete();
    }, failedResponseBean -> {
      System.out.println("Error while sending request " + failedResponseBean.getBody());
      promise.complete();
    });
  }

  private void loadPerson(Promise<Object> promise) {
    System.out.println("Person id: ");
    long id = scanner.nextLong();
    peopleCommands.loadPerson(id, person -> {
      System.out.println(person);
      promise.complete();
    }, failedResponseBean -> {
      System.out.println("Error while sending request " + failedResponseBean.getBody());
      promise.complete();
    });
  }

  private void listPersons(Promise<Object> promise) {
    peopleCommands.listPeople(people -> {
      people.forEach(System.out::println);
      promise.complete();
    }, failedResponseBean -> {
      System.out.println("Error while sending request " + failedResponseBean.getBody());
      promise.complete();
    });
  }
}
