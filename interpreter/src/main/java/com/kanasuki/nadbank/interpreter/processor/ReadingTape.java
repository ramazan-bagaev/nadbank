package com.kanasuki.nadbank.interpreter.processor;

import java.util.LinkedList;
import java.util.stream.Collectors;

public class ReadingTape {

    private LinkedList<Character> symbolArray;

    public ReadingTape(String code) {
        this.symbolArray = code.chars().mapToObj(e->(char)e).collect(Collectors.toCollection(LinkedList::new));
    }

    public char next() {
        return symbolArray.pop();
    }

    public boolean read(String text) {
        for (char c: text.toCharArray()) {
            if (!read(c)) {
                return false;
            }
        }

        return true;
    }

    public boolean read(char c) {
        return symbolArray.getFirst() == c;
    }

    public boolean hasNext() {
        return !symbolArray.isEmpty();
    }

    public String getRemain() {
        StringBuilder stringBuilder = new StringBuilder();
        for(Character c: symbolArray) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}
