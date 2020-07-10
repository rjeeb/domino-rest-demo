package org.dominokit.rest.example.shared;

import java.lang.Class;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import org.dominokit.jacksonapt.JsonSerializationContext;
import org.dominokit.jacksonapt.JsonSerializer;
import org.dominokit.jacksonapt.ser.BaseNumberJsonSerializer;
import org.dominokit.jacksonapt.ser.StringJsonSerializer;
import org.dominokit.jacksonapt.ser.bean.AbstractBeanJsonSerializer;
import org.dominokit.jacksonapt.ser.bean.BeanPropertySerializer;

public final class PersonBeanJsonSerializerImpl extends AbstractBeanJsonSerializer<Person> {
  public PersonBeanJsonSerializerImpl() {
  }

  @Override
  public Class getSerializedType() {
    return Person.class;
  }

  @Override
  protected BeanPropertySerializer[] initSerializers() {
    BeanPropertySerializer[] result = new BeanPropertySerializer[3];
    result[0] = new BeanPropertySerializer<Person, Long>("id") {
      @Override
      protected JsonSerializer<?> newSerializer() {
        return BaseNumberJsonSerializer.LongJsonSerializer.getInstance();
      }

      @Override
      public Long getValue(Person bean, JsonSerializationContext ctx) {
        return bean.getId();
      }
    };
    result[1] = new BeanPropertySerializer<Person, String>("firstName") {
      @Override
      protected JsonSerializer<?> newSerializer() {
        return StringJsonSerializer.getInstance();
      }

      @Override
      public String getValue(Person bean, JsonSerializationContext ctx) {
        return bean.getFirstName();
      }
    };
    result[2] = new BeanPropertySerializer<Person, String>("lastName") {
      @Override
      protected JsonSerializer<?> newSerializer() {
        return StringJsonSerializer.getInstance();
      }

      @Override
      public String getValue(Person bean, JsonSerializationContext ctx) {
        return bean.getLastName();
      }
    };
    return result;
  }
}
