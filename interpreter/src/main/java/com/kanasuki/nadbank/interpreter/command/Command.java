package com.kanasuki.nadbank.interpreter.command;

public interface Command {

    void execute();

    Command getNextCommand();

    void setNextCommand(Command nextCommand);
}
