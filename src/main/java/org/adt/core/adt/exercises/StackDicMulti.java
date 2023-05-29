package org.adt.core.adt.exercises;

import org.adt.core.adt.definition.ISet;
import org.adt.core.adt.definition.IStack;
import org.adt.core.adt.implementation.dynamic.Stack;
import org.adt.core.adt.implementation.dynamic.node.MultipleDictionaryNode;
import org.adt.core.adt.implementation.dynamic.node.StackMultiDicNode;
import org.adt.core.adt.implementation.dynamic.Set;

public class StackDicMulti {
    private StackMultiDicNode first;


    public void add(int key, int value) {
        Stack stack = new Stack();
        stack.add(value);
        if (this.first == null) {
            this.first = new StackMultiDicNode(key, stack, null);
            return;
        }
        StackMultiDicNode candidate = this.first;
        while (candidate.getNext() != null) {
            if (candidate.getKey() == key) {
                if (existeElemento(value, candidate.getValue())){
                    candidate.getValue().add(value);
                }
                return;
            }
            candidate = candidate.getNext();
        }
        if (candidate.getKey() == key) {
            candidate.getValue().add(value);
            return;
        }
        candidate.setNext(new StackMultiDicNode(key, stack, null));
    }


    public void remove(int key, int value) {
        StackMultiDicNode backup = null;
        StackMultiDicNode candidate = this.first;
        while (candidate != null) {
            if (candidate.getKey() == key) {
                remover(candidate.getValue(),value);
                if (candidate.getValue().isEmpty()) {
                    if (backup == null) {
                        if (candidate.getNext() == null) {
                            this.first = null;
                            return;
                        }
                        this.first = this.first.getNext();
                        return;
                    }
                    if (candidate.getNext() == null) {
                        backup.setNext(null);
                        return;
                    }
                    candidate.setNext(candidate.getNext().getNext());
                }
                return;
            }
            backup = candidate;
            candidate = candidate.getNext();
        }
    }
    public void remover(Stack stack, int value){
        Stack aux = new Stack();

        while (!stack.isEmpty()){
            if(stack.getTop()!=value){
                aux.add(stack.getTop());
            }
            stack.remove();
            while(!aux.isEmpty())
                stack.add(aux.getTop());
                aux.remove();
        }
    }
    public boolean existeElemento(int key, Stack value){
        Stack aux = new Stack();
        boolean existe = false;
        while(!value.isEmpty())
            if(key!=value.getTop()){
                aux.add(value.getTop());
                value.remove();
            }else{
                existe = true;
                value.remove();
            }
        while(!aux.isEmpty()){
            value.add(aux.getTop());
            aux.remove();
        }return existe;
    }

    public ISet getKeys() { // N^2
        ISet keySet = new Set(); // C
        StackMultiDicNode candidate = this.first; // C
        while (candidate != null) { // N * (N * C) = N^2 C = N^2
            keySet.add(candidate.getKey()); // N*C
            candidate = candidate.getNext();
        }
        return keySet; // C
    }


    public IStack getValues(int key) {
        StackMultiDicNode candidate = this.first;
        while (candidate != null) {
            if (candidate.getKey() == key) {
                return candidate.getValue();
            }
            candidate = candidate.getNext();
        }
        return null; // Error
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }
}
