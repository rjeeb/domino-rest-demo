package org.dominokit.rest.example.client.presenters;

import javax.annotation.Generated;
import org.dominokit.domino.api.client.annotations.presenter.Command;
import org.dominokit.domino.api.client.request.PresenterCommand;

/**
 * This is generated class, please don't modify
 */
@Generated("org.dominokit.domino.apt.client.processors.module.client.presenters.PresenterProcessor")
@Command
public class LayoutProxy_PresenterCommand extends PresenterCommand<LayoutProxy_Presenter> {
  public LayoutProxy_PresenterCommand() {
    configure(new LayoutProxy_Presenter_Config());
  }
}
