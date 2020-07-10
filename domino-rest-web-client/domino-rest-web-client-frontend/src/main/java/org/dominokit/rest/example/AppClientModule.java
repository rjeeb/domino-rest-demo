package org.dominokit.rest.example;

import com.google.gwt.core.client.EntryPoint;
import org.dominokit.domino.api.client.ClientApp;
import org.dominokit.domino.gwt.client.app.DominoGWT;
import org.dominokit.domino.rest.DominoRestConfig;
import org.dominokit.domino.view.GwtView;

import java.util.logging.Logger;

public class AppClientModule implements EntryPoint {

    private static final Logger LOGGER = Logger.getLogger(AppClientModule.class.getName());

    public void onModuleLoad() {
        DominoRestConfig.initDefaults()
                .setDefaultServiceRoot("http://localhost:8080");
        DominoGWT.init();
        GwtView.init();
        ClientApp.make().run();
        LOGGER.info("domino-rest-web-client Application frontend have been initialized.");
    }
}
