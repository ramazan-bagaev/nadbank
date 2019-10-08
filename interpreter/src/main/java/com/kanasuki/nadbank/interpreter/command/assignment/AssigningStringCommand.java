package com.kanasuki.nadbank.interpreter.command.assignment;

import com.kanasuki.nadbank.interpreter.command.AbstractCommand;
import com.kanasuki.nadbank.interpreter.scope.Scope;
import com.kanasuki.nadbank.interpreter.variable.StringVariable;

public class AssigningStringCommand extends AbstractCommand {

    private String oldName;
    private String newName;

    public AssigningStringCommand(Scope scope, String oldName, String newName) {
        super(scope);
        this.oldName = oldName;
        this.newName = newName;
    }

    @Override
    public void execute() {
        Scope scope = getScope();
        StringVariable stringVariable = scope.getString(newName);
        scope.putString(oldName, stringVariable);
    }
}
