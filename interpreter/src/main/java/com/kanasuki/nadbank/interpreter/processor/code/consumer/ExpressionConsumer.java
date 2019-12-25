package com.kanasuki.nadbank.interpreter.processor.code.consumer;

import com.kanasuki.nadbank.interpreter.processor.tree.Node;

public class ExpressionConsumer implements ConstructionConsumer {

    private final Node currentNode;

    public ExpressionConsumer(Node currentNode) {
        this.currentNode = currentNode;
    }

    @Override
    public boolean verifyNode(Node node) {
        return false;
    }

    @Override
    public void prepareNode(Node node) {

    }
}
