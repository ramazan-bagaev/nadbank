package com.kanasuki.nadbank.interpreter.processor.util.parentheses;

public class ParenthesesFinder {

    public static final int OUT_OF_BOUNDARY = -1;

    public static int nextParenthesesPosition(String text, ParenthesesType type) {
        if (text.length() == 0) {
            return OUT_OF_BOUNDARY;
        }

        if (text.charAt(0) != type.opener()) {
            return OUT_OF_BOUNDARY;
        }

        boolean shouldSkip = false;
        int balance = 0;
        char[] charArray = text.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];

            if (shouldSkip) {
                if (c == '\"') {
                    shouldSkip = false;
                }

                continue;
            }

            if (c == type.opener()) {
                balance++;
            } else if (c == type.closer()) {
                balance--;
            } else if (c == '\"') {
                shouldSkip = true;
            }

            if (balance == 0) {
                return i;
            }
        }

        return OUT_OF_BOUNDARY;
    }
}
