package com.kanasuki.nadbank.interpreter.scope;

import com.kanasuki.nadbank.interpreter.variable.Variable;

import java.util.HashMap;
import java.util.Map;

class VariableTable<T extends Variable> {

    private Map<String, T> variableTable;

    VariableTable() {
        this.variableTable = new HashMap<>();
    }

    T getVariable(String name) {
        return variableTable.get(name);
    }

    void putVariable(String name, T variable) {
        variableTable.put(name, variable);
    }

    boolean contains(String name) {
        return variableTable.containsKey(name);
    }
}
