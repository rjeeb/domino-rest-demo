package org.dominokit.rest.example.vertx;

import io.vertx.core.Vertx;
import org.dominokit.domino.rest.DominoRestConfig;

public class Main {

  public static void main(String[] args) {
    DominoRestConfig.initDefaults()
      .setDefaultServiceRoot("http://localhost:8080");

    Vertx vertx = Vertx.vertx();
    vertx.deployVerticle(new MainVerticle());
  }
}
