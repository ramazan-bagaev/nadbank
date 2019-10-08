package com.kanasuki.nadbank.interpreter.command.initializing;

import com.kanasuki.nadbank.interpreter.command.AbstractCommand;
import com.kanasuki.nadbank.interpreter.scope.Scope;
import com.kanasuki.nadbank.interpreter.variable.IntVariable;

public class InitializingIntCommand extends AbstractCommand {

    private String name;
    private int value;

    public InitializingIntCommand(Scope scope, String name, int value) {
        super(scope);
        this.name = name;
        this.value = value;
    }

    @Override
    public void execute() {
        Scope scope = getScope();
        IntVariable intVariable = new IntVariable(value);
        scope.putInt(name, intVariable);
    }
}
