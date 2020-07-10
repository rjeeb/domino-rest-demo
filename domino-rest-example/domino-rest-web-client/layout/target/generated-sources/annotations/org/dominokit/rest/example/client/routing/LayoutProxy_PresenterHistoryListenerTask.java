package org.dominokit.rest.example.client.routing;

import java.lang.Override;
import java.util.Arrays;
import javax.annotation.Generated;
import org.dominokit.domino.api.client.annotations.StartupTask;
import org.dominokit.domino.api.client.events.DefaultEventAggregator;
import org.dominokit.domino.api.client.startup.BaseRoutingStartupTask;
import org.dominokit.domino.history.DominoHistory;
import org.dominokit.domino.history.TokenFilter;
import org.dominokit.rest.example.client.presenters.LayoutProxy_PresenterCommand;

/**
 * This is generated class, please don't modify
 */
@Generated("org.dominokit.domino.apt.client.processors.module.client.presenters.PresenterProcessor")
@StartupTask
public class LayoutProxy_PresenterHistoryListenerTask extends BaseRoutingStartupTask {
  public LayoutProxy_PresenterHistoryListenerTask() {
    super(Arrays.asList(new DefaultEventAggregator()));
  }

  @Override
  protected TokenFilter getTokenFilter() {
    return TokenFilter.endsWithPathFilter("home");
  }

  @Override
  protected TokenFilter getStartupTokenFilter() {
    return TokenFilter.startsWithPathFilter("home");
  }

  @Override
  protected void onStateReady(DominoHistory.State state) {
     new LayoutProxy_PresenterCommand().onPresenterReady(presenter -> {
      bindPresenter(presenter);
      if(!presenter.isActivated()) {
        presenter.reveal();
      }
    } ).send();
  }
}
