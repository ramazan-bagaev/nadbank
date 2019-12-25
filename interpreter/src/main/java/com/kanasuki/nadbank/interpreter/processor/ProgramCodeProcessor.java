package com.kanasuki.nadbank.interpreter.processor;

import com.kanasuki.nadbank.interpreter.processor.code.CodeProcessor;
import com.kanasuki.nadbank.interpreter.processor.tree.Tree;
import com.kanasuki.nadbank.interpreter.processor.tree.TreeProcessor;
import com.kanasuki.nadbank.interpreter.program.Program;

public class ProgramCodeProcessor {

    private TreeProcessor treeProcessor;
    private CodeProcessor codeProcessor;


    public ProgramCodeProcessor() {
    }

    public Program processProgramCode(String programCode) {
        Tree tree = codeProcessor.processCode(programCode);

        return treeProcessor.processTree(tree);
    }

    public void process(String programCode) {
        String current = "";
        for (char c: programCode.toCharArray()) {
            current += c;
        }
    }
}
