package org.dominokit.rest.example.shared;

import java.lang.Class;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Map;
import org.dominokit.jacksonapt.JacksonContextProvider;
import org.dominokit.jacksonapt.JsonDeserializationContext;
import org.dominokit.jacksonapt.JsonDeserializer;
import org.dominokit.jacksonapt.JsonDeserializerParameters;
import org.dominokit.jacksonapt.deser.BaseNumberJsonDeserializer;
import org.dominokit.jacksonapt.deser.StringJsonDeserializer;
import org.dominokit.jacksonapt.deser.bean.AbstractBeanJsonDeserializer;
import org.dominokit.jacksonapt.deser.bean.BeanPropertyDeserializer;
import org.dominokit.jacksonapt.deser.bean.HasDeserializerAndParameters;
import org.dominokit.jacksonapt.deser.bean.Instance;
import org.dominokit.jacksonapt.deser.bean.InstanceBuilder;
import org.dominokit.jacksonapt.deser.bean.MapLike;
import org.dominokit.jacksonapt.stream.JsonReader;

public final class PersonBeanJsonDeserializerImpl extends AbstractBeanJsonDeserializer<Person> {
  public PersonBeanJsonDeserializerImpl() {
  }

  @Override
  public Class getDeserializedType() {
    return Person.class;
  }

  @Override
  protected InstanceBuilder<Person> initInstanceBuilder() {
    final MapLike<HasDeserializerAndParameters> deserializers = null;
    return new InstanceBuilder<Person>() {
      @Override
      public Instance<Person> newInstance(JsonReader reader, JsonDeserializationContext ctx,
          JsonDeserializerParameters params, Map<String, String> bufferedProperties,
          Map<String, Object> bufferedPropertiesValues) {
        return new Instance<Person>(create(), bufferedProperties);
      }

      @Override
      public MapLike<HasDeserializerAndParameters> getParametersDeserializer() {
        return deserializers;
      }

      private Person create() {
        return new Person();
      }
    };
  }

  @Override
  protected MapLike<BeanPropertyDeserializer<Person, ?>> initDeserializers() {
    MapLike<BeanPropertyDeserializer<Person, ?>> map = JacksonContextProvider.get().mapLikeFactory().make();
    map.put("id", new BeanPropertyDeserializer<Person, Long>() {
      @Override
      protected JsonDeserializer<?> newDeserializer() {
        return BaseNumberJsonDeserializer.LongJsonDeserializer.getInstance();
      }

      @Override
      public void setValue(Person bean, Long value, JsonDeserializationContext ctx) {
        bean.setId(value);
      }
    });
    map.put("firstName", new BeanPropertyDeserializer<Person, String>() {
      @Override
      protected JsonDeserializer<?> newDeserializer() {
        return StringJsonDeserializer.getInstance();
      }

      @Override
      public void setValue(Person bean, String value, JsonDeserializationContext ctx) {
        bean.setFirstName(value);
      }
    });
    map.put("lastName", new BeanPropertyDeserializer<Person, String>() {
      @Override
      protected JsonDeserializer<?> newDeserializer() {
        return StringJsonDeserializer.getInstance();
      }

      @Override
      public void setValue(Person bean, String value, JsonDeserializationContext ctx) {
        bean.setLastName(value);
      }
    });
    return map;
  }
}
