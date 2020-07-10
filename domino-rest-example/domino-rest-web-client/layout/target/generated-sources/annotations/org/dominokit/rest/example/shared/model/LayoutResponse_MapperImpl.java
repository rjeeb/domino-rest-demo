package org.dominokit.rest.example.shared.model;

import java.lang.Override;
import org.dominokit.jacksonapt.AbstractObjectMapper;
import org.dominokit.jacksonapt.JsonDeserializer;
import org.dominokit.jacksonapt.JsonSerializer;

public final class LayoutResponse_MapperImpl extends AbstractObjectMapper<LayoutResponse> {
  public static final LayoutResponse_MapperImpl INSTANCE = new LayoutResponse_MapperImpl();

  public LayoutResponse_MapperImpl() {
    super("LayoutResponse");
  }

  @Override
  protected JsonDeserializer<LayoutResponse> newDeserializer() {
    return new LayoutResponseBeanJsonDeserializerImpl();
  }

  @Override
  protected JsonSerializer<?> newSerializer() {
    return new LayoutResponseBeanJsonSerializerImpl();
  }
}
