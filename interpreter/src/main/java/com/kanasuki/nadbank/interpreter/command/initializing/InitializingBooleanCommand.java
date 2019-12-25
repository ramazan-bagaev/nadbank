package com.kanasuki.nadbank.interpreter.command.initializing;

import com.kanasuki.nadbank.interpreter.command.AbstractCommand;
import com.kanasuki.nadbank.interpreter.scope.Scope;
import com.kanasuki.nadbank.interpreter.variable.BooleanVariable;

public class InitializingBooleanCommand extends AbstractCommand {

    private String name;
    private boolean value;

    public InitializingBooleanCommand(Scope scope, String name, boolean value) {
        super(scope);
        this.name = name;
        this.value = value;
    }

    @Override
    public void execute() {
        Scope scope = getScope();
        BooleanVariable booleanVariable = new BooleanVariable(value);
        scope.putBoolean(name, booleanVariable);
    }
}
