package org.dominokit.rest.example.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.code.Code;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;

public class CodeBlock extends BaseDominoElement<HTMLDivElement, CodeBlock> {

    private final Code.Block block;
    private DominoElement<HTMLDivElement> root = DominoElement.div();

    public CodeBlock() {
        block = Code.block();
        Style.of(block).add("pretty-code");
        root
                .appendChild(Row.create()
                        .styler(style -> style.setPadding("0"))
                        .appendChild(Column.span12()
                                .appendChild(block)
                        )
                );

        init(this);
    }

    public void setCode(String code) {
        block.setCode(code);
    }

    @Override
    public HTMLDivElement element() {
        return root.element();
    }
}
