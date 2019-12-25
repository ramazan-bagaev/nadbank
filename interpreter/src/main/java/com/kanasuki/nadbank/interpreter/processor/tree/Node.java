package com.kanasuki.nadbank.interpreter.processor.tree;

import com.kanasuki.nadbank.interpreter.exception.ConsumerException;
import com.kanasuki.nadbank.interpreter.processor.code.Expandable;
import com.kanasuki.nadbank.interpreter.processor.code.consumer.ConstructionConsumer;
import com.kanasuki.nadbank.interpreter.processor.code.consumer.ConsumptionResult;

public class Node implements Expandable {

    private Node parent;

    private Node left;
    private Node right;

    private NodeType type;

    private String text;

    private ConstructionConsumer constructionConsumer;

    public Node(Node parent, NodeType type, String text, ConstructionConsumer constructionConsumer) {
        this.parent = parent;
        this.type = type;
        this.text = text;
        this.constructionConsumer = constructionConsumer;
    }

    public Node getParent() {
        return parent;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public String getText() {
        return text;
    }

    @Override
    public void expand() {
        boolean success = constructionConsumer.verifyNode(this);

        if (success) {
            constructionConsumer.prepareNode(this);
        }
    }
}
