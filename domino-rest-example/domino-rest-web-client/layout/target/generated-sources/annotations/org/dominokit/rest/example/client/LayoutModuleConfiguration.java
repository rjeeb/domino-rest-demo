package org.dominokit.rest.example.client;

import java.lang.Override;
import javax.annotation.Generated;
import org.dominokit.domino.api.client.InitialTaskRegistry;
import org.dominokit.domino.api.client.ModuleConfiguration;
import org.dominokit.domino.api.client.mvp.presenter.ViewablePresenterSupplier;
import org.dominokit.rest.example.client.presenters.LayoutProxy_Presenter;
import org.dominokit.rest.example.client.presenters.LayoutProxy_Presenter_Config;
import org.dominokit.rest.example.client.routing.LayoutProxy_PresenterHistoryListenerTask;
import org.dominokit.rest.example.client.views.LayoutView;
import org.dominokit.rest.example.client.views.ui.LayoutViewImpl;

/**
 * This is generated class, please don't modify
 */
@Generated("org.dominokit.domino.apt.client.processors.module.client.ClientModuleAnnotationProcessor")
public class LayoutModuleConfiguration implements ModuleConfiguration {
  @Override
  public void registerPresenters() {
    LayoutProxy_Presenter_Config layoutProxy_Presenter_Config = new LayoutProxy_Presenter_Config();
    layoutProxy_Presenter_Config.setPresenterSupplier(new ViewablePresenterSupplier<LayoutProxy_Presenter, LayoutView>(false, ()-> new LayoutProxy_Presenter()));

  }

  @Override
  public void registerViews() {
    LayoutProxy_Presenter_Config layoutProxy_Presenter_Config = new LayoutProxy_Presenter_Config();
    layoutProxy_Presenter_Config.setViewSupplier(()-> new LayoutViewImpl());
  }

  @Override
  public void registerInitialTasks(InitialTaskRegistry registry) {
    registry.registerInitialTask(new LayoutProxy_PresenterHistoryListenerTask());
  }
}
