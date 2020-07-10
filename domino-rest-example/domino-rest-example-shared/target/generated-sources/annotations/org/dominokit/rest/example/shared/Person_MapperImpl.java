package org.dominokit.rest.example.shared;

import java.lang.Override;
import org.dominokit.jacksonapt.AbstractObjectMapper;
import org.dominokit.jacksonapt.JsonDeserializer;
import org.dominokit.jacksonapt.JsonSerializer;

public final class Person_MapperImpl extends AbstractObjectMapper<Person> {
  public static final Person_MapperImpl INSTANCE = new Person_MapperImpl();

  public Person_MapperImpl() {
    super("Person");
  }

  @Override
  protected JsonDeserializer<Person> newDeserializer() {
    return new PersonBeanJsonDeserializerImpl();
  }

  @Override
  protected JsonSerializer<?> newSerializer() {
    return new PersonBeanJsonSerializerImpl();
  }
}
