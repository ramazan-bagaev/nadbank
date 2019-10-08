package com.kanasuki.nadbank.interpreter.command;

import com.kanasuki.nadbank.interpreter.scope.Scope;

public abstract class AbstractCommand implements Command {

    private Scope scope;

    private Command nextCommand;

    public AbstractCommand(Scope scope) {
        this.scope = scope;
    }

    public Scope getScope() {
        return scope;
    }

    @Override
    public Command getNextCommand() {
        return nextCommand;
    }

    @Override
    public void setNextCommand(Command nextCommand) {
        this.nextCommand = nextCommand;
    }
}
