package com.kanasuki.nadbank.interpreter.processor.code;

import com.kanasuki.nadbank.interpreter.processor.code.consumer.ProgramBlockConsumer;
import com.kanasuki.nadbank.interpreter.processor.tree.Node;
import com.kanasuki.nadbank.interpreter.processor.tree.NodeType;
import com.kanasuki.nadbank.interpreter.processor.tree.Tree;

public class CodeProcessorImpl implements CodeProcessor {

    @Override
    public Tree processCode(String program) {
        Node currentNode = new Node(null, NodeType.CODE, program, new ProgramBlockConsumer());

        while (currentNode != null) {
            currentNode.expand();

            Node leftNode = currentNode.getLeft();

            if (leftNode != null) {
                currentNode = leftNode;
            } else {
                currentNode = currentNode.getRight();
            }
        }

        return null;
    }
}
