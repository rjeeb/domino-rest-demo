package org.dominokit.rest.example.client.views.ui;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLHeadingElement;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.forms.LongBox;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.grid.flex.FlexDirection;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.grid.flex.FlexLayout;
import org.dominokit.domino.ui.modals.ModalDialog;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.view.BaseElementView;
import org.dominokit.rest.example.client.presenters.LayoutProxy;
import org.dominokit.rest.example.client.views.LayoutView;
import org.jboss.elemento.HtmlContentBuilder;

import static org.jboss.elemento.Elements.h;

@UiView(presentable = LayoutProxy.class)
public class LayoutViewImpl extends BaseElementView<HTMLDivElement> implements LayoutView {

  private final DominoElement<HTMLDivElement> root = DominoElement.div();
  private final HtmlContentBuilder<HTMLHeadingElement> valueContainer = h(5);
  private LayoutUiHandlers uiHandlers;

  @Override
  public HTMLDivElement init() {
    DominoElement.of(valueContainer)
      .style()
      .setProperty("white-space", "break-spaces");
    root
      .styler(style -> style.setMarginTop("20px"))
      .appendChild(Row.create()
        .appendChild(Column.span2()
          .offset(2)
          .appendChild(Card.create()
            .appendChild(FlexLayout.create()
              .addCss("test-layout")
              .setWidth("100%")
              .setDirection(FlexDirection.TOP_TO_BOTTOM)
              .appendChild(FlexItem.create()
                .appendChild(Button.createPrimary("List people")
                  .addClickListener(evt -> uiHandlers.onList())
                  .setWidth("100%")
                )
              )
              .appendChild(FlexItem.create()
                .appendChild(Button.createPrimary("Load person")
                  .addClickListener(evt -> {
                    ModalDialog modal = ModalDialog.create("Person information");
                    LongBox idBox = LongBox.create("Person id");
                    modal
                      .appendChild(idBox)
                      .appendFooterChild(Button.createPrimary("Load")
                        .addClickListener(evt1 -> {
                          modal.close();
                          uiHandlers.onLoad(idBox.getValue());
                        })
                      )
                      .open();
                  })
                  .setWidth("100%")
                )
              )
              .appendChild(FlexItem.create()
                .appendChild(Button.createPrimary("Create person")
                  .addClickListener(evt -> {
                    ModalDialog modal = ModalDialog.create("Person information");
                    TextBox firstName = TextBox.create("First name");
                    TextBox lastName = TextBox.create("Last name");
                    modal
                      .appendChild(firstName)
                      .appendChild(lastName)
                      .appendFooterChild(Button.createPrimary("Create")
                        .addClickListener(evt1 -> {
                          modal.close();
                          uiHandlers.onCreate(firstName.getValue(), lastName.getValue());
                        })
                      )
                      .open();
                  })
                  .setWidth("100%")
                )
              )
              .appendChild(FlexItem.create()
                .appendChild(Button.createPrimary("Update person")
                  .addClickListener(evt -> {
                    ModalDialog modal = ModalDialog.create("Person information");
                    LongBox id = LongBox.create("ID");
                    TextBox firstName = TextBox.create("First name");
                    TextBox lastName = TextBox.create("Last name");
                    modal
                      .appendChild(id)
                      .appendChild(firstName)
                      .appendChild(lastName)
                      .appendFooterChild(Button.createPrimary("Update")
                        .addClickListener(evt1 -> {
                          modal.close();
                          uiHandlers.onUpdate(id.getValue(), firstName.getValue(), lastName.getValue());
                        })
                      )
                      .open();
                  })
                  .setWidth("100%")
                )
              )
              .appendChild(FlexItem.create()
                .appendChild(Button.createPrimary("Delete person")
                  .addClickListener(evt -> {
                    ModalDialog modal = ModalDialog.create("Person information");
                    LongBox id = LongBox.create("ID");
                    modal
                      .appendChild(id)
                      .appendFooterChild(Button.createPrimary("Delete")
                        .addClickListener(evt1 -> {
                          modal.close();
                          uiHandlers.onDelete(id.getValue());
                        })
                      )
                      .open();
                  })
                  .setWidth("100%")
                )
              )
            )
          )
        )
        .appendChild(Column.span6()
          .offset(4)
          .appendChild(Card.create()
            .setHeight("calc(100vh - 50px)")
            .apply(card -> {
              card.bodyStyle().setHeight("100%");
            })
            .appendChild(valueContainer)
          )
        )
      );

    return root.element();
  }

  @Override
  public void setUiHandlers(LayoutUiHandlers uiHandlers) {
    this.uiHandlers = uiHandlers;
  }

  @Override
  public void setValue(String value) {
    valueContainer.textContent(value);
  }
}
