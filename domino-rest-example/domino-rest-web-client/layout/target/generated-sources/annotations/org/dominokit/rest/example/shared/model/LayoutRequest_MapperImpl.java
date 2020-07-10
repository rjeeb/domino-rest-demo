package org.dominokit.rest.example.shared.model;

import java.lang.Override;
import org.dominokit.jacksonapt.AbstractObjectMapper;
import org.dominokit.jacksonapt.JsonDeserializer;
import org.dominokit.jacksonapt.JsonSerializer;

public final class LayoutRequest_MapperImpl extends AbstractObjectMapper<LayoutRequest> {
  public static final LayoutRequest_MapperImpl INSTANCE = new LayoutRequest_MapperImpl();

  public LayoutRequest_MapperImpl() {
    super("LayoutRequest");
  }

  @Override
  protected JsonDeserializer<LayoutRequest> newDeserializer() {
    return new LayoutRequestBeanJsonDeserializerImpl();
  }

  @Override
  protected JsonSerializer<?> newSerializer() {
    return new LayoutRequestBeanJsonSerializerImpl();
  }
}
