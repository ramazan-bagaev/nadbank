package com.kanasuki.nadbank.interpreter.processor.code.consumer;

import com.kanasuki.nadbank.interpreter.processor.tree.Node;

public class ProgramConsumer implements ConstructionConsumer {

    private final Node currentNode;

    public ProgramConsumer(Node currentNode) {
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
