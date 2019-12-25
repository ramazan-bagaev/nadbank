package com.kanasuki.nadbank.interpreter.scope;

import com.kanasuki.nadbank.interpreter.variable.BooleanVariable;
import com.kanasuki.nadbank.interpreter.variable.IntVariable;
import com.kanasuki.nadbank.interpreter.variable.StringVariable;
import com.kanasuki.nadbank.interpreter.variable.Variable;
public class Scope {

    private Scope parent;
    private VariableTable<StringVariable> stringTable;
    private VariableTable<IntVariable> intTable;
    private VariableTable<BooleanVariable> booleanTable;

    private Variable returnVariable;

    public Scope(Scope parent) {
        this.parent = parent;
        this.stringTable = new VariableTable<>();
        this.intTable = new VariableTable<>();
        this.booleanTable = new VariableTable<>();
    }

    public StringVariable getString(String name) {
        if (stringTable.contains(name)) {
            return stringTable.getVariable(name);
        }

        if (parent == null) {
            throw new IllegalArgumentException("no such name in scope variable tables: " + name);
        }

        return parent.getString(name);
    }

    public void putString(String name, StringVariable variable) {
        stringTable.putVariable(name, variable);
    }

    public IntVariable getInt(String name) {
        if (intTable.contains(name)) {
            return intTable.getVariable(name);
        }

        if (parent == null) {
            throw new IllegalArgumentException("no such name in scope variable tables: " + name);
        }

        return parent.getInt(name);
    }

    public void putInt(String name, IntVariable variable) {
        intTable.putVariable(name, variable);
    }

    public BooleanVariable getBoolean(String name) {
        if (booleanTable.contains(name)) {
            return booleanTable.getVariable(name);
        }

        if (parent == null) {
            throw new IllegalArgumentException("no such name in scope variable tables: " + name);
        }

        return parent.getBoolean(name);
    }

    public void putBoolean(String name, BooleanVariable variable) {
        booleanTable.putVariable(name, variable);
    }

    public Variable getVariable(String name) {
        if (stringTable.contains(name)) {
            return stringTable.getVariable(name);
        }

        if (intTable.contains(name)) {
            return intTable.getVariable(name);
        }

        if (booleanTable.contains(name)) {
            return booleanTable.getVariable(name);
        }

        if (parent == null) {
            throw new IllegalArgumentException("no such name in scope variable tables: " + name);
        }

        return parent.getVariable(name);
    }

    public Scope getParent() {
        return parent;
    }

    public boolean isReturned() {
        return (returnVariable != null);
    }

    public Variable getReturnVariable() {
        return returnVariable;
    }

    public void setReturnVariable(Variable returnVariable) {
        this.returnVariable = returnVariable;
    }
}
