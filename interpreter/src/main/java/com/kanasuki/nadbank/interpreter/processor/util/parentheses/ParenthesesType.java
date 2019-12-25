package com.kanasuki.nadbank.interpreter.processor.util.parentheses;

public enum ParenthesesType {
    Round('(', ')'), Curly('{', '}');

    private char opener;
    private char closer;

    ParenthesesType(char opener, char closer) {
        this.opener = opener;
        this.closer = closer;
    }

    public char opener() {
        return opener;
    }

    public char closer() {
        return closer;
    }
}
