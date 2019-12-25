package com.kanasuki.nadbank.interpreter.variable;

public class BooleanVariable implements Variable {

    private boolean value;

    public BooleanVariable(boolean value) {
        this.value = value;
    }

    public boolean getValue() {
        return value;
    }

    @Override
    public String convertToString() {
        return String.valueOf(value);
    }
}
