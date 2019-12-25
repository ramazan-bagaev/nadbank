package com.kanasuki.nadbank.interpreter.processor.code.consumer;

import com.kanasuki.nadbank.interpreter.processor.tree.Node;
import com.kanasuki.nadbank.interpreter.processor.util.SymbolFinder;

public class StatementConsumer implements ConstructionConsumer {

    @Override
    public boolean verifyNode(Node node) {
        String text = node.getText();

        int equalSignIndex = SymbolFinder.nextSpecifiedSymbol(text, '=');

        String variable = text.substring(0, equalSignIndex - 1);
        text = text.substring(equalSignIndex);



        return false;
    }

    @Override
    public void prepareNode(Node node) {

    }
}
