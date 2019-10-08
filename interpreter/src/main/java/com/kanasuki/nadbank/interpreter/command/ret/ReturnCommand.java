package com.kanasuki.nadbank.interpreter.command.ret;

import com.kanasuki.nadbank.interpreter.command.AbstractCommand;
import com.kanasuki.nadbank.interpreter.scope.Scope;
import com.kanasuki.nadbank.interpreter.variable.Variable;

public class ReturnCommand extends AbstractCommand {

    private String name;

    public ReturnCommand(Scope scope, String name) {
        super(scope);
        this.name = name;
    }

    @Override
    public void execute() {
        Scope scope = getScope();
        Variable variable = scope.getVariable(name);
        scope.setReturnVariable(variable);
    }
}
