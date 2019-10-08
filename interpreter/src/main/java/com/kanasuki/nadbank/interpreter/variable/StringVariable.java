package com.kanasuki.nadbank.interpreter.variable;

public class StringVariable implements Variable {

    private String value;

    public StringVariable(String value) {
        this.value = value;
    }

    @Override
    public String convertToString() {
        return value;
    }
}
