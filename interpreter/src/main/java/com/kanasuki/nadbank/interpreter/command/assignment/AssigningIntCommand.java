package com.kanasuki.nadbank.interpreter.command.assignment;

import com.kanasuki.nadbank.interpreter.command.AbstractCommand;
import com.kanasuki.nadbank.interpreter.scope.Scope;
import com.kanasuki.nadbank.interpreter.variable.IntVariable;

public class AssigningIntCommand extends AbstractCommand {

    private String oldVariableName;
    private String newVariableName;

    public AssigningIntCommand(Scope scope, String oldVariableName, String newVariableName) {
        super(scope);
        this.oldVariableName = oldVariableName;
        this.newVariableName = newVariableName;
    }

    @Override
    public void execute() {
        Scope scope = getScope();
        IntVariable intVariable = getScope().getInt(newVariableName);
        scope.putInt(oldVariableName, intVariable);
    }
}
