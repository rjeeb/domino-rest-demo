package org.dominokit.rest.example.shared.model;

import java.lang.Class;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Map;
import org.dominokit.jacksonapt.JacksonContextProvider;
import org.dominokit.jacksonapt.JsonDeserializationContext;
import org.dominokit.jacksonapt.JsonDeserializer;
import org.dominokit.jacksonapt.JsonDeserializerParameters;
import org.dominokit.jacksonapt.deser.StringJsonDeserializer;
import org.dominokit.jacksonapt.deser.bean.AbstractBeanJsonDeserializer;
import org.dominokit.jacksonapt.deser.bean.BeanPropertyDeserializer;
import org.dominokit.jacksonapt.deser.bean.HasDeserializerAndParameters;
import org.dominokit.jacksonapt.deser.bean.Instance;
import org.dominokit.jacksonapt.deser.bean.InstanceBuilder;
import org.dominokit.jacksonapt.deser.bean.MapLike;
import org.dominokit.jacksonapt.stream.JsonReader;

public final class LayoutResponseBeanJsonDeserializerImpl extends AbstractBeanJsonDeserializer<LayoutResponse> {
  public LayoutResponseBeanJsonDeserializerImpl() {
  }

  @Override
  public Class getDeserializedType() {
    return LayoutResponse.class;
  }

  @Override
  protected InstanceBuilder<LayoutResponse> initInstanceBuilder() {
    final MapLike<HasDeserializerAndParameters> deserializers = null;
    return new InstanceBuilder<LayoutResponse>() {
      @Override
      public Instance<LayoutResponse> newInstance(JsonReader reader, JsonDeserializationContext ctx,
          JsonDeserializerParameters params, Map<String, String> bufferedProperties,
          Map<String, Object> bufferedPropertiesValues) {
        return new Instance<LayoutResponse>(create(), bufferedProperties);
      }

      @Override
      public MapLike<HasDeserializerAndParameters> getParametersDeserializer() {
        return deserializers;
      }

      private LayoutResponse create() {
        return new LayoutResponse();
      }
    };
  }

  @Override
  protected MapLike<BeanPropertyDeserializer<LayoutResponse, ?>> initDeserializers() {
    MapLike<BeanPropertyDeserializer<LayoutResponse, ?>> map = JacksonContextProvider.get().mapLikeFactory().make();
    map.put("serverMessage", new BeanPropertyDeserializer<LayoutResponse, String>() {
      @Override
      protected JsonDeserializer<?> newDeserializer() {
        return StringJsonDeserializer.getInstance();
      }

      @Override
      public void setValue(LayoutResponse bean, String value, JsonDeserializationContext ctx) {
        bean.setServerMessage(value);
      }
    });
    return map;
  }
}
