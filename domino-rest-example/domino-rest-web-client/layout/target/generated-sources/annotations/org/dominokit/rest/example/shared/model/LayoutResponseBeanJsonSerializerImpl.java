package org.dominokit.rest.example.shared.model;

import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import org.dominokit.jacksonapt.JsonSerializationContext;
import org.dominokit.jacksonapt.JsonSerializer;
import org.dominokit.jacksonapt.ser.StringJsonSerializer;
import org.dominokit.jacksonapt.ser.bean.AbstractBeanJsonSerializer;
import org.dominokit.jacksonapt.ser.bean.BeanPropertySerializer;

public final class LayoutResponseBeanJsonSerializerImpl extends AbstractBeanJsonSerializer<LayoutResponse> {
  public LayoutResponseBeanJsonSerializerImpl() {
  }

  @Override
  public Class getSerializedType() {
    return LayoutResponse.class;
  }

  @Override
  protected BeanPropertySerializer[] initSerializers() {
    BeanPropertySerializer[] result = new BeanPropertySerializer[1];
    result[0] = new BeanPropertySerializer<LayoutResponse, String>("serverMessage") {
      @Override
      protected JsonSerializer<?> newSerializer() {
        return StringJsonSerializer.getInstance();
      }

      @Override
      public String getValue(LayoutResponse bean, JsonSerializationContext ctx) {
        return bean.getServerMessage();
      }
    };
    return result;
  }
}
