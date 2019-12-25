package com.kanasuki.nadbank.interpreter.processor.util;

public class SymbolFinder {

    public static final int OUT_OF_BOUNDARY = -1;

    public static int nextNonSpaceSymbol(String text) {
        char[] charArray = text.toCharArray();
        for (int i = 0, charArrayLength = charArray.length; i < charArrayLength; i++) {
            char c = charArray[i];
            if (c == ' ' || c == '\n') {
                continue;
            }

            return i;
        }

        return OUT_OF_BOUNDARY;
    }

    public static int nextSpecifiedSymbol(String text, char symbol) {
        char[] charArray = text.toCharArray();
        for (int i = 0, charArrayLength = charArray.length; i < charArrayLength; i++) {
            char c = charArray[i];

            if (c == symbol) {
                return i;
            }
        }

        return OUT_OF_BOUNDARY;
    }
}
