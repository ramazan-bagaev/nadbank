package com.kanasuki.nadbank.interpreter.integration.test;

import com.kanasuki.nadbank.interpreter.command.Command;
import com.kanasuki.nadbank.interpreter.command.assignment.AssigningStringCommand;
import com.kanasuki.nadbank.interpreter.command.initializing.InitializingStringCommand;
import com.kanasuki.nadbank.interpreter.command.ret.ReturnCommand;
import com.kanasuki.nadbank.interpreter.program.Program;
import com.kanasuki.nadbank.interpreter.program.SimpleProgram;
import com.kanasuki.nadbank.interpreter.scope.Scope;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SimpleCommandTest {

    @Test
    public void executeSimpleProgram() {
        Scope programScope = new Scope(null);
        Command command1 = new InitializingStringCommand(programScope, "new-name", "new-value");
        Command command2 = new AssigningStringCommand(programScope, "new-new-name", "new-name");
        Command command3 = new ReturnCommand(programScope, "new-new-name");
        command1.setNextCommand(command2);
        command2.setNextCommand(command3);
        Program simpleProgram = new SimpleProgram(command1, programScope);

        String res = simpleProgram.execute("");

        assertEquals("new-value", res);
    }
}
