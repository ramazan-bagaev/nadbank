package com.kanasuki.nadbank.interpreter.processor.code.consumer;

import com.kanasuki.nadbank.interpreter.exception.ConsumerException;
import com.kanasuki.nadbank.interpreter.exception.UtilException;
import com.kanasuki.nadbank.interpreter.processor.tree.Node;
import com.kanasuki.nadbank.interpreter.processor.tree.NodeType;
import com.kanasuki.nadbank.interpreter.processor.util.parentheses.ParenthesesHarvester;
import com.kanasuki.nadbank.interpreter.processor.util.parentheses.ParenthesesType;

public class IfConstructionConsumer implements ConstructionConsumer {

    private static final String IF_TERMINAL = "if";

    private String foundIfTerminal;
    private String conditionBlock;
    private String bodyBlock;
    private String rest;

    @Override
    public boolean verifyNode(Node node) {
        String text = node.getText();

        String[] splits;
        try {
            splits = ParenthesesHarvester.splitParenthesesBlock(text, ParenthesesType.Round);

            if (splits.length != 3) {
                return false;
            }

            this.foundIfTerminal = splits[0];
            this.conditionBlock = splits[1];
            text = splits[2];

        } catch (UtilException e) {
            return false;
        }

        try {
            splits = ParenthesesHarvester.splitParenthesesBlock(text, ParenthesesType.Curly);

            if (splits.length != 2) {
                return false;
            }

            this.bodyBlock = splits[0];
            this.rest = splits[1];

        } catch (UtilException e) {
            return false;
        }

        return true;
    }

    @Override
    public void prepareNode(Node node) {
        Node ifNode = new Node(node, NodeType.IF, foundIfTerminal, new TerminalConsumer(IF_TERMINAL));

        Node leftNode = new Node(ifNode, NodeType.CONDITION, conditionBlock, new ProgramBlockConsumer());
        Node rightNode = new Node(ifNode, NodeType.CODE, bodyBlock, new ProgramBlockConsumer());

        Node restNode = new Node(node, NodeType.CODE, rest, new ProgramBlockConsumer());

        ifNode.setRight(rightNode);
        ifNode.setLeft(leftNode);

        node.setLeft(ifNode);
        node.setRight(restNode);
    }
}
