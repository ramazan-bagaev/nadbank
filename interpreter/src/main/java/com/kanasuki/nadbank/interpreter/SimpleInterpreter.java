package com.kanasuki.nadbank.interpreter;

import com.kanasuki.nadbank.interpreter.processor.ProgramCodeProcessor;
import com.kanasuki.nadbank.interpreter.program.Program;

public class SimpleInterpreter implements Interpreter {

    private ProgramCodeProcessor processor;

    public SimpleInterpreter() {
        this.processor = new ProgramCodeProcessor();
    }

    @Override
    public Program interpret(String programCode) {
        return processor.processProgramCode(programCode);
    }
}
