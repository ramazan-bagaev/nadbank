package com.kanasuki.nadbank.interpreter.program;

import com.kanasuki.nadbank.interpreter.command.Command;
import com.kanasuki.nadbank.interpreter.scope.Scope;
import com.kanasuki.nadbank.interpreter.variable.Variable;

public class SimpleProgram implements Program {

    private Command startCommand;
    private Scope programScope;

    public SimpleProgram(Command startCommand, Scope programScope) {
        this.startCommand = startCommand;
        this.programScope = programScope;
    }

    @Override
    public String execute(String args) {
        Command current = startCommand;
        while(current != null) {
            current.execute();
            if (programScope.isReturned()) {
                return getResult();
            }
            current = current.getNextCommand();
        }

        return getResult();
    }

    private String getResult() {
        Variable returnVariable = programScope.getReturnVariable();
        return returnVariable != null ? returnVariable.convertToString() : "";
    }
}
