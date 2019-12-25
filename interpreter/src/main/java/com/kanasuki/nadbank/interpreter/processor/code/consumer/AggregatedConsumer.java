package com.kanasuki.nadbank.interpreter.processor.code.consumer;

import com.kanasuki.nadbank.interpreter.processor.tree.Node;

import java.util.Collection;
import java.util.HashSet;

public class AggregatedConsumer implements ConstructionConsumer {

    private final Collection<ConstructionConsumer> consumers;

    private ConstructionConsumer chosenConsumer;

    public AggregatedConsumer() {
        this.consumers = new HashSet<>();
    }

    @Override
    public boolean verifyNode(Node node) {
        for (ConstructionConsumer consumer : consumers) {
            boolean success = consumer.verifyNode(node);

            if (success) {
                this.chosenConsumer = consumer;
                return true;
            }
        }

        return false;
    }

    @Override
    public void prepareNode(Node node) {
        chosenConsumer.prepareNode(node);
    }

    public void addConsumer(ConstructionConsumer consumer) {
        consumers.add(consumer);
    }
}
