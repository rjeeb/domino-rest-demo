package org.dominokit.rest.example.shared;

import java.lang.Long;
import java.lang.Override;
import java.lang.Void;
import java.util.List;
import javax.annotation.Generated;
import org.dominokit.domino.rest.shared.request.RequestMeta;
import org.dominokit.domino.rest.shared.request.ServerRequest;
import org.dominokit.domino.rest.shared.request.service.annotations.Request;
import org.dominokit.domino.rest.shared.request.service.annotations.RestService;
import org.dominokit.jacksonapt.AbstractObjectReader;
import org.dominokit.jacksonapt.AbstractObjectWriter;
import org.dominokit.jacksonapt.JsonDeserializer;
import org.dominokit.jacksonapt.JsonSerializer;
import org.dominokit.jacksonapt.deser.collection.ListJsonDeserializer;

/**
 * This is generated class, please don't modify
 */
@Generated("org.dominokit.domino.rest.apt.RequestFactoryProcessor")
@RestService(PersonService.class)
public class PersonServiceFactory {
  public static final PersonServiceFactory INSTANCE = new PersonServiceFactory();

  public ServerRequest<Person, Person> create(Person person) {
    PersonService_create instance = new PersonService_create(person);
    return instance;
  }

  public ServerRequest<Void, Void> delete(Long id) {
    PersonService_delete instance = new PersonService_delete();
    instance.setPathParameter("id", instance.emptyOrStringValue(() -> id));
    return instance;
  }

  public ServerRequest<Person, Person> update(Long id, Person person) {
    PersonService_update instance = new PersonService_update(person);
    instance.setPathParameter("id", instance.emptyOrStringValue(() -> id));
    return instance;
  }

  public ServerRequest<Void, List<Person>> list() {
    PersonService_list instance = new PersonService_list();
    return instance;
  }

  public ServerRequest<Void, Person> load(Long id) {
    PersonService_load instance = new PersonService_load();
    instance.setPathParameter("id", instance.emptyOrStringValue(() -> id));
    return instance;
  }

  @Request
  public class PersonService_create extends ServerRequest<Person, Person> {
    PersonService_create(Person request) {
      super(new RequestMeta(PersonService.class, "create", Person.class, Person.class), request);
      setHttpMethod("POST");
      setContentType(new String[]{"application/json"});
      setAccept(new String[]{"application/json"});
      setPath("/service/api/persons/");
      setServiceRoot("");
      setRequestWriter(bean -> new AbstractObjectWriter<Person>("org.dominokit.rest.example.shared.Person") {
        @Override
        protected JsonSerializer<?> newSerializer() {
          return new PersonBeanJsonSerializerImpl();}
      }.write(bean));
      setResponseReader(response -> new AbstractObjectReader<Person>("org.dominokit.rest.example.shared.Person") {
        @Override
        protected JsonDeserializer<Person> newDeserializer() {
          return new PersonBeanJsonDeserializerImpl();}
      }.read(response.getBodyAsString()));
    }
  }

  @Request
  public class PersonService_delete extends ServerRequest<Void, Void> {
    PersonService_delete() {
      super(new RequestMeta(PersonService.class, "delete", Void.class, void.class), null);
      setHttpMethod("DELETE");
      setContentType(new String[]{"application/json"});
      setAccept(new String[]{"application/json"});
      setPath("/service/api/persons/{id}");
      setServiceRoot("");
    }
  }

  @Request
  public class PersonService_update extends ServerRequest<Person, Person> {
    PersonService_update(Person request) {
      super(new RequestMeta(PersonService.class, "update", Person.class, Person.class), request);
      setHttpMethod("PUT");
      setContentType(new String[]{"application/json"});
      setAccept(new String[]{"application/json"});
      setPath("/service/api/persons/{id}");
      setServiceRoot("");
      setRequestWriter(bean -> new AbstractObjectWriter<Person>("org.dominokit.rest.example.shared.Person") {
        @Override
        protected JsonSerializer<?> newSerializer() {
          return new PersonBeanJsonSerializerImpl();}
      }.write(bean));
      setResponseReader(response -> new AbstractObjectReader<Person>("org.dominokit.rest.example.shared.Person") {
        @Override
        protected JsonDeserializer<Person> newDeserializer() {
          return new PersonBeanJsonDeserializerImpl();}
      }.read(response.getBodyAsString()));
    }
  }

  @Request
  public class PersonService_list extends ServerRequest<Void, List<Person>> {
    PersonService_list() {
      super(new RequestMeta(PersonService.class, "list", Void.class, List.class), null);
      setHttpMethod("GET");
      setContentType(new String[]{"application/json"});
      setAccept(new String[]{"application/json"});
      setPath("/service/api/persons/");
      setServiceRoot("");
      setResponseReader(response -> new AbstractObjectReader<List<Person>>("java.util.List<org.dominokit.rest.example.shared.Person>") {
        @Override
        protected JsonDeserializer<List<Person>> newDeserializer() {
          return ListJsonDeserializer.newInstance(new PersonBeanJsonDeserializerImpl());}
      }.read(response.getBodyAsString()));
    }
  }

  @Request
  public class PersonService_load extends ServerRequest<Void, Person> {
    PersonService_load() {
      super(new RequestMeta(PersonService.class, "load", Void.class, Person.class), null);
      setHttpMethod("GET");
      setContentType(new String[]{"application/json"});
      setAccept(new String[]{"application/json"});
      setPath("/service/api/persons/{id}");
      setServiceRoot("");
      setResponseReader(response -> new AbstractObjectReader<Person>("org.dominokit.rest.example.shared.Person") {
        @Override
        protected JsonDeserializer<Person> newDeserializer() {
          return new PersonBeanJsonDeserializerImpl();}
      }.read(response.getBodyAsString()));
    }
  }
}
