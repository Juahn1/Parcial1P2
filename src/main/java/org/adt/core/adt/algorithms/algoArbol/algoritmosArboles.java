package org.adt.core.adt.algorithms.algoArbol;

import org.adt.core.adt.definition.IBinaryTree;
import org.adt.core.adt.definition.IQueue;
import org.adt.core.adt.implementation.normal.BinaryTree;
import org.adt.core.adt.implementation.normal.Queue;
import org.adt.core.adt.algorithms.*;
import java.lang.Math;

public class algoritmosArboles {

    /*1 Buscar si un nodo existe en el arbol (recibis un int y devolves true si esta presente)
     *2 Imprimis en pantalla todas las hojas
     *3 Imprimis en pantalla todos sus nodos internos (la raíz puede o no ser considerado nodo interno). Estos son los nodos que no son hojas
     *4 Calcular la altura de un arbol
     *5 Encontrar el minimo o el maximo de un arbol
     *6 Decidir si un arbol es completo o no
     *7 Decidir si un arbol es perfecto o no
     *8 Decidir si un arbol es sesgado
     *9 Decidir si un arbol es degenerado
     * */


    public static boolean completo(IBinaryTree arbol){
        if(arbol == null || arbol.isEmpty()){
            return true;
        }

        return arbol.getLeft() != null &&
                arbol.getRight() !=null &&
                completo(arbol.getLeft())&&
                completo(arbol.getRight())||
                arbol.getLeft() == null && arbol.getRight() == null;
    }
    public static int totalNodos(IBinaryTree arbol){
        if(arbol == null || arbol.isEmpty()){
            return 0;
        }
        else{
            return 1+totalNodos(arbol.getLeft())+totalNodos(arbol.getRight());
        }
    }

    public static boolean perfecto(IBinaryTree arbol){
//        if((Math.pow(2/*base*/,altura(arbol)/*exp*/)-1 == totalNodos(arbol))){
//            return true;
//        }else{
//            return false;
        return (Math.pow(2,altura(arbol))-1) == totalNodos(arbol);
    }
    public static void inOrder(IBinaryTree binaryTree) {
        if (binaryTree == null || binaryTree.isEmpty()) {
            return;
        }
        inOrder(binaryTree.getLeft());
        System.out.println(binaryTree.getValue());
        inOrder(binaryTree.getRight());
    }

    public static void preOrder(IBinaryTree binaryTree) {
        if (binaryTree == null || binaryTree.isEmpty()) {
            return;
        }

        System.out.println(binaryTree.getValue());
        preOrder(binaryTree.getLeft());
        preOrder(binaryTree.getRight());
    }

    public static void imprimirHojas(IBinaryTree arbol) {
        if (arbol == null || arbol.isEmpty()) {
            return;
        }
        if (arbol.getLeft() == null && arbol.getRight() == null) {
            System.out.println(arbol.getValue());
        }
        imprimirHojas(arbol.getLeft());
        imprimirHojas(arbol.getRight());
    }

    public static int altura(IBinaryTree arbol) {
        if (arbol != null) {
            return 1 + Math.max(altura(arbol.getLeft()), altura(arbol.getRight())); //el 1 es la raiz y se sumanm las alturas de los nodos hijos
        }
        return 0;
    }

    public static void imprimirNodosInternos(IBinaryTree arbol) {
        if (arbol == null || arbol.isEmpty()) {
            return;
        }
        if (arbol.getLeft() != null && arbol.getRight() != null) {
            System.out.println(arbol.getValue());
        }
        if (arbol.getLeft() == null && arbol.getRight() != null) {
            System.out.println(arbol.getValue());
        }
        if (arbol.getLeft() != null && arbol.getRight() == null) {
            System.out.println(arbol.getValue());
        }
        imprimirNodosInternos(arbol.getLeft());
        imprimirNodosInternos(arbol.getRight());
    }

    public static int nodoMin(IBinaryTree arbol) {
        if (arbol == null || arbol.isEmpty()) {
            return 0;
        }
        int actual = arbol.getValue();
        int izq = 1 + nodoMin(arbol.getLeft()); // se llama de forma recursiva
        int der = 1 + nodoMin(arbol.getRight());

        return Math.min(actual, Math.min(izq, der)); // se evalua primero el minimo entre el izquierdo y el derecho y luego el minimo entre el actual y esos dos

    }



    public static int nodoMax(IBinaryTree arbol) {
        if (arbol == null || arbol.isEmpty()) {
            return 0;
        }
        int actual = arbol.getValue();
        int izq = nodoMax(arbol.getLeft()); // se llama de forma recursiva
        int der = nodoMax(arbol.getRight());

        return Math.max(actual, Math.max(izq, der));
    }

    public static boolean existe(IBinaryTree arbol, int value) {

        if (arbol == null) {
            return false;
        }
        if (arbol.getValue() == value) {
            return true;
        }

        return existe(arbol.getLeft(), value) || existe(arbol.getRight(), value);
    }

    public static void main(String[] args) {
        IBinaryTree arbol = new BinaryTree();
        arbol.create(1);
        arbol.addRight(3);
        arbol.addLeft(2);
        arbol.getRight().addLeft(7);
        arbol.getRight().addRight(9);
        arbol.getLeft().addLeft(4);
        arbol.getLeft().addRight(5);


        System.out.println(perfecto(arbol));
        //inOrder(arbol);

    }
}
