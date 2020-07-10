package org.dominokit.rest.example.shared.model;

import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import org.dominokit.jacksonapt.JsonSerializationContext;
import org.dominokit.jacksonapt.JsonSerializer;
import org.dominokit.jacksonapt.ser.StringJsonSerializer;
import org.dominokit.jacksonapt.ser.bean.AbstractBeanJsonSerializer;
import org.dominokit.jacksonapt.ser.bean.BeanPropertySerializer;

public final class LayoutRequestBeanJsonSerializerImpl extends AbstractBeanJsonSerializer<LayoutRequest> {
  public LayoutRequestBeanJsonSerializerImpl() {
  }

  @Override
  public Class getSerializedType() {
    return LayoutRequest.class;
  }

  @Override
  protected BeanPropertySerializer[] initSerializers() {
    BeanPropertySerializer[] result = new BeanPropertySerializer[1];
    result[0] = new BeanPropertySerializer<LayoutRequest, String>("message") {
      @Override
      protected JsonSerializer<?> newSerializer() {
        return StringJsonSerializer.getInstance();
      }

      @Override
      public String getValue(LayoutRequest bean, JsonSerializationContext ctx) {
        return bean.getMessage();
      }
    };
    return result;
  }
}
