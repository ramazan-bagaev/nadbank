package com.kanasuki.nadbank.interpreter.processor;

import com.kanasuki.nadbank.interpreter.command.Command;
import com.kanasuki.nadbank.interpreter.command.assignment.AssigningStringCommand;
import com.kanasuki.nadbank.interpreter.command.initializing.InitializingStringCommand;
import com.kanasuki.nadbank.interpreter.program.Program;
import com.kanasuki.nadbank.interpreter.program.SimpleProgram;
import com.kanasuki.nadbank.interpreter.scope.Scope;

public class ProgramCodeProcessor {

    public Program processProgramCode(String programCode) {
        Scope programScope = new Scope(null);
        Command command1 = new InitializingStringCommand(programScope, "new-name", "new-value");
        Command command2 = new AssigningStringCommand(programScope, "new-name", "new-new-name");
        command1.setNextCommand(command2);

        return new SimpleProgram(command1, programScope);
    }
}
