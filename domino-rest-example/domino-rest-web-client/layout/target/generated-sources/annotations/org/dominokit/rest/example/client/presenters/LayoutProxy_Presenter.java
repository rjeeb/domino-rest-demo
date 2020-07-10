package org.dominokit.rest.example.client.presenters;

import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import org.dominokit.domino.api.client.annotations.presenter.AutoReveal;
import org.dominokit.domino.api.client.annotations.presenter.AutoRoute;
import org.dominokit.domino.api.client.annotations.presenter.Presenter;
import org.dominokit.domino.api.client.annotations.presenter.RoutingTask;
import org.dominokit.domino.api.client.annotations.presenter.Slot;
import org.dominokit.domino.api.client.mvp.presenter.ViewBaseClientPresenter;
import org.dominokit.domino.api.shared.extension.DominoEvent;
import org.dominokit.domino.api.shared.extension.DominoEventListener;
import org.dominokit.domino.api.shared.extension.GlobalDominoEventListener;
import org.dominokit.rest.example.client.routing.LayoutProxy_PresenterHistoryListenerTask;
import org.dominokit.rest.example.shared.events.LayoutEvent;

/**
 * This is generated class, please don't modify
 */
@Generated("org.dominokit.domino.apt.client.processors.module.client.presenters.PresenterProcessor")
@Presenter
@AutoRoute(
    token = "home",
    routeOnce = false,
    reRouteActivated = false
)
@RoutingTask(LayoutProxy_PresenterHistoryListenerTask.class)
@AutoReveal
@Slot("body-slot")
public class LayoutProxy_Presenter extends LayoutProxy {
  @Override
  public String revealSlot() {
    return "body-slot";
  }

  @Override
  public ViewBaseClientPresenter.RevealedHandler getRevealHandler() {
    return ()-> {
      onLayoutRevealed();
    } ;
  }

  @Override
  @SuppressWarnings("all")
  protected Map<Class<? extends DominoEvent>, DominoEventListener> getListeners() {
    Map<Class<? extends DominoEvent>, DominoEventListener> listenersMap = new HashMap<>();
    return listenersMap;
  }

  @Override
  @SuppressWarnings("all")
  protected Map<Class<? extends DominoEvent>, GlobalDominoEventListener> getGlobalListeners() {
    Map<Class<? extends DominoEvent>, GlobalDominoEventListener> listenersMap = new HashMap<>();
    return listenersMap;
  }

  @Override
  protected void fireActivationEvent(boolean state) {
    fireEvent(LayoutEvent.class, new LayoutEvent(state));
  }
}
