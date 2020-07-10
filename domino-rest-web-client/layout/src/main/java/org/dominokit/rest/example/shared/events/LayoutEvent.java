package org.dominokit.rest.example.shared.events;

import org.dominokit.domino.api.shared.extension.ActivationEvent;

public class LayoutEvent extends ActivationEvent {
    public LayoutEvent(boolean status) {
        super(status);
    }

    public LayoutEvent(String serializedEvent) {
        super(serializedEvent);
    }
}
