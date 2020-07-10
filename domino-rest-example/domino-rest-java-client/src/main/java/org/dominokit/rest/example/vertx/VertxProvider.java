package org.dominokit.rest.example.vertx;

import com.google.auto.service.AutoService;
import io.vertx.core.Vertx;
import org.dominokit.domino.rest.VertxInstanceProvider;

@AutoService(VertxInstanceProvider.class)
public class VertxProvider implements VertxInstanceProvider {
  @Override
  public Vertx getInstance() {
    return VertxContext.vertx;
  }

  @Override
  public String getHost() {
    return "localhost";
  }

  @Override
  public int getPort() {
    return 8080;
  }

  @Override
  public String getProtocol() {
    return "http";
  }
}
