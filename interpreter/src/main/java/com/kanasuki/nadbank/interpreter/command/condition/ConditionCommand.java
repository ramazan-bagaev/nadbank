package com.kanasuki.nadbank.interpreter.command.condition;

import com.kanasuki.nadbank.interpreter.command.AbstractCommand;
import com.kanasuki.nadbank.interpreter.command.Command;
import com.kanasuki.nadbank.interpreter.scope.Scope;
import com.kanasuki.nadbank.interpreter.variable.BooleanVariable;

public class ConditionCommand extends AbstractCommand {

    private final Command trueCommand;
    private final Command falseCommand;
    private final BooleanVariable condition;

    public ConditionCommand(Scope scope, Command trueCommand, Command falseCommand, BooleanVariable condition) {
        super(scope);
        this.trueCommand = trueCommand;
        this.falseCommand = falseCommand;
        this.condition = condition;
    }

    @Override
    public void execute() {
        if (condition.getValue()) {
            setNextCommand(trueCommand);
        } else {
            setNextCommand(falseCommand);
        }
    }
}
