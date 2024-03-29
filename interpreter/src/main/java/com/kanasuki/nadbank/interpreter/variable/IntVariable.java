package com.kanasuki.nadbank.interpreter.variable;

public class IntVariable implements Variable {

    private int value;

    public IntVariable(int value) {
        this.value = value;
    }

    @Override
    public String convertToString() {
        return String.valueOf(value);
    }
}
