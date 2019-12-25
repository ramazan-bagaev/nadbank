package com.kanasuki.nadbank.interpreter.processor.code;

import com.kanasuki.nadbank.interpreter.processor.tree.Tree;

public interface CodeProcessor {

    Tree processCode(String program);
}
