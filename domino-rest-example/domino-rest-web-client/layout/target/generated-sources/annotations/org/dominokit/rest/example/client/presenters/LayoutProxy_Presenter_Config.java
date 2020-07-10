package org.dominokit.rest.example.client.presenters;

import java.lang.Override;
import java.util.function.Supplier;
import javax.annotation.Generated;
import org.dominokit.domino.api.client.mvp.ViewablePresenterConfig;
import org.dominokit.domino.api.client.mvp.presenter.ViewablePresenterSupplier;
import org.dominokit.rest.example.client.views.LayoutView;

/**
 * This is generated class, please don't modify
 */
@Generated("org.dominokit.domino.apt.client.processors.module.client.presenters.PresenterProcessor")
public class LayoutProxy_Presenter_Config implements ViewablePresenterConfig<LayoutProxy_Presenter, LayoutView> {
  private static ViewablePresenterSupplier<LayoutProxy_Presenter, LayoutView> presenterSupplier;

  private static Supplier<LayoutView> viewSupplier;

  public void setPresenterSupplier(ViewablePresenterSupplier<LayoutProxy_Presenter, LayoutView> presenterSupplier) {
    LayoutProxy_Presenter_Config.presenterSupplier = presenterSupplier;
  }

  @Override
  public ViewablePresenterSupplier<LayoutProxy_Presenter, LayoutView> getPresenterSupplier() {
    return LayoutProxy_Presenter_Config.presenterSupplier;
  }

  public void setViewSupplier(Supplier<LayoutView> viewSupplier) {
    LayoutProxy_Presenter_Config.viewSupplier = viewSupplier;
  }

  @Override
  public Supplier<LayoutView> getViewSupplier() {
    return LayoutProxy_Presenter_Config.viewSupplier;
  }
}
