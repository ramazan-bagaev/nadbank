package com.kanasuki.nadbank.interpreter.command.initializing;

import com.kanasuki.nadbank.interpreter.command.AbstractCommand;
import com.kanasuki.nadbank.interpreter.scope.Scope;
import com.kanasuki.nadbank.interpreter.variable.StringVariable;

public class InitializingStringCommand extends AbstractCommand {

    private String name;
    private String value;

    public InitializingStringCommand(Scope scope, String name, String value) {
        super(scope);
        this.name = name;
        this.value = value;
    }

    @Override
    public void execute() {
        Scope scope = getScope();
        StringVariable stringVariable = new StringVariable(value);
        scope.putString(name, stringVariable);
    }
}
