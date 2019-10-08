package com.kanasuki.nadbank.interpreter;

import com.kanasuki.nadbank.interpreter.program.Program;

public interface Interpreter {

    Program interpret(String programCode);
}
