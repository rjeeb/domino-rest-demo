package org.dominokit.rest.example.client.views;

import org.dominokit.domino.api.client.mvp.view.ContentView;
import org.dominokit.domino.api.client.mvp.view.HasUiHandlers;
import org.dominokit.domino.api.client.mvp.view.UiHandlers;

public interface LayoutView extends ContentView, HasUiHandlers<LayoutView.LayoutUiHandlers> {

  void setValue(String value);

  interface LayoutUiHandlers extends UiHandlers {
    void onList();

    void onLoad(long id);

    void onCreate(String firstName, String lastName);

    void onUpdate(Long id, String firstName, String lastName);

    void onDelete(Long id);
  }
}
