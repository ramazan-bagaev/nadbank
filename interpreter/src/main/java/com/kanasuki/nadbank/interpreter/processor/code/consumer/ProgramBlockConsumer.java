package com.kanasuki.nadbank.interpreter.processor.code.consumer;

public class ProgramBlockConsumer extends AggregatedConsumer {

    public ProgramBlockConsumer() {
        addConsumer(new IfConstructionConsumer());
    }
}
