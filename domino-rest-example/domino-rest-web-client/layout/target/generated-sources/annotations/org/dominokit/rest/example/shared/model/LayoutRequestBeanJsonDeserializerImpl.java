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

public final class LayoutRequestBeanJsonDeserializerImpl extends AbstractBeanJsonDeserializer<LayoutRequest> {
  public LayoutRequestBeanJsonDeserializerImpl() {
  }

  @Override
  public Class getDeserializedType() {
    return LayoutRequest.class;
  }

  @Override
  protected InstanceBuilder<LayoutRequest> initInstanceBuilder() {
    final MapLike<HasDeserializerAndParameters> deserializers = null;
    return new InstanceBuilder<LayoutRequest>() {
      @Override
      public Instance<LayoutRequest> newInstance(JsonReader reader, JsonDeserializationContext ctx,
          JsonDeserializerParameters params, Map<String, String> bufferedProperties,
          Map<String, Object> bufferedPropertiesValues) {
        return new Instance<LayoutRequest>(create(), bufferedProperties);
      }

      @Override
      public MapLike<HasDeserializerAndParameters> getParametersDeserializer() {
        return deserializers;
      }

      private LayoutRequest create() {
        return new LayoutRequest();
      }
    };
  }

  @Override
  protected MapLike<BeanPropertyDeserializer<LayoutRequest, ?>> initDeserializers() {
    MapLike<BeanPropertyDeserializer<LayoutRequest, ?>> map = JacksonContextProvider.get().mapLikeFactory().make();
    map.put("message", new BeanPropertyDeserializer<LayoutRequest, String>() {
      @Override
      protected JsonDeserializer<?> newDeserializer() {
        return StringJsonDeserializer.getInstance();
      }

      @Override
      public void setValue(LayoutRequest bean, String value, JsonDeserializationContext ctx) {
        bean.setMessage(value);
      }
    });
    return map;
  }
}
