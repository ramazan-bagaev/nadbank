package com.kanasuki.nadbank.interpreter.processor.code.consumer;

import com.kanasuki.nadbank.interpreter.processor.tree.Node;

public class TerminalConsumer implements ConstructionConsumer {

    private final String terminal;

    TerminalConsumer(String terminal) {
        this.terminal = terminal;
    }

    @Override
    public boolean verifyNode(Node node) {
        return node.getText().equals(terminal);
    }

    @Override
    public void prepareNode(Node node) {
    }
}
