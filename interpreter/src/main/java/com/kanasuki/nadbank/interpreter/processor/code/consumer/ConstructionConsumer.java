package com.kanasuki.nadbank.interpreter.processor.code.consumer;

import com.kanasuki.nadbank.interpreter.processor.tree.Node;

public interface ConstructionConsumer {

    boolean verifyNode(Node node);

    void prepareNode(Node node);
}
