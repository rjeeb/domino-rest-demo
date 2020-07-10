package org.dominokit.rest.example.shared.services;

import java.lang.Override;
import java.lang.Void;
import javax.annotation.Generated;
import org.dominokit.domino.rest.shared.request.RequestMeta;
import org.dominokit.domino.rest.shared.request.ServerRequest;
import org.dominokit.domino.rest.shared.request.service.annotations.Request;
import org.dominokit.domino.rest.shared.request.service.annotations.RestService;
import org.dominokit.jacksonapt.AbstractObjectReader;
import org.dominokit.jacksonapt.JsonDeserializer;
import org.dominokit.rest.example.shared.model.LayoutRequest;
import org.dominokit.rest.example.shared.model.LayoutResponse;
import org.dominokit.rest.example.shared.model.LayoutResponseBeanJsonDeserializerImpl;

/**
 * This is generated class, please don't modify
 */
@Generated("org.dominokit.domino.rest.apt.RequestFactoryProcessor")
@RestService(LayoutService.class)
public class LayoutServiceFactory {
  public static final LayoutServiceFactory INSTANCE = new LayoutServiceFactory();

  public ServerRequest<Void, LayoutResponse> request(LayoutRequest request) {
    LayoutService_request instance = new LayoutService_request();
    return instance;
  }

  @Request
  public class LayoutService_request extends ServerRequest<Void, LayoutResponse> {
    LayoutService_request() {
      super(new RequestMeta(LayoutService.class, "request", Void.class, LayoutResponse.class), null);
      setHttpMethod("GET");
      setContentType(new String[]{"application/json"});
      setAccept(new String[]{"application/json"});
      setPath("/LayoutRequest");
      setServiceRoot("");
      setResponseReader(response -> new AbstractObjectReader<LayoutResponse>("org.dominokit.rest.example.shared.model.LayoutResponse") {
        @Override
        protected JsonDeserializer<LayoutResponse> newDeserializer() {
          return new LayoutResponseBeanJsonDeserializerImpl();}
      }.read(response.getBodyAsString()));
    }
  }
}
