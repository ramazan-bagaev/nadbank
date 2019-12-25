package com.kanasuki.nadbank.interpreter.processor.util.parentheses;

import com.kanasuki.nadbank.interpreter.exception.UtilException;
import com.kanasuki.nadbank.interpreter.processor.util.SymbolFinder;

public class ParenthesesHarvester {

    public static String[] splitParenthesesBlock(String text, ParenthesesType type) throws UtilException {
        int parenthesisIndex = text.indexOf(type.opener());

        if (parenthesisIndex == SymbolFinder.OUT_OF_BOUNDARY) {
            throw new UtilException("parentheses block doesn't contain " + type.opener());
        }

        if (parenthesisIndex == 0) {
            throw new UtilException("parentheses block don't have anything before");
        }

        String preBlock = text.substring(0, parenthesisIndex);

        String rest = text.substring(parenthesisIndex);

        int closingParenthesesIndex = ParenthesesFinder.nextParenthesesPosition(rest, type);

        String parenthesesBlock = rest.substring(1, closingParenthesesIndex);

        rest = rest.substring(closingParenthesesIndex + 1);

        return new String[] {preBlock, parenthesesBlock, rest};
    }
}
