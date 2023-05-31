package org.adt.core.adt.implementation.dynamic.node;



import org.adt.core.adt.definition.ISet;
import org.adt.core.adt.definition.IStack;
import org.adt.core.adt.implementation.dynamic.Stack;

public class StackMultiDicNode {

    private int key;
    private Stack value;
    private StackMultiDicNode next;

    public StackMultiDicNode(int key, Stack value, StackMultiDicNode next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Stack getValue() {
        return value;
    }

    public void setValue(Stack value) {
        this.value = value;
    }

    public StackMultiDicNode getNext() {
        return next;
    }

    public void setNext(StackMultiDicNode next) {
        this.next = next;
    }
}