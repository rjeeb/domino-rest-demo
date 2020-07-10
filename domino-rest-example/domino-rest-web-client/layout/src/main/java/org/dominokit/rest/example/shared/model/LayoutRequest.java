package org.dominokit.rest.example.shared.model;

import org.dominokit.jacksonapt.annotation.JSONMapper;

@JSONMapper
public class LayoutRequest {

    private String message;

    public LayoutRequest() {
    }

    public LayoutRequest(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
