package org.adt.core.adt.exercises;

import org.adt.core.adt.implementation.normal.Set;

import java.util.Arrays;
import java.util.Random;

/**
 * Ejercicio: Modificar el TDA conjunto para que en lugar de un array de enteros utilice un array
 * de booleanos. El conjunto solo debe permitir numeros entre 100 y 160
 * **/
public class ejercicios17may {
    public class BooleanSet{

        private boolean[] arreglo;
        int min = 100;
        int max = 160;
        private int count;

        public void Set() {
            this.arreglo = new boolean[10000];
            this.count = 0;
            Arrays.fill(arreglo,false);
        }


        public void add(int a) {
            if(min<=a && max>=a){
            if (!this.arreglo[a]) {
                this.arreglo[a] = true;
            }
        }}


        public void remove(int a) {
            if (this.arreglo[a]){
                this.arreglo[a] = false;
            }
        }


        public boolean isEmpty() {
            return this.count == 0;
        }


        public int choose() {
            if (this.count == 0) {
                System.out.println("No se puede elegir un elemento del conjunto vacio");
                return -1;
            }
            int randomIndex = (new Random()).nextInt((max-min+1)+min);
            if(this.count == randomIndex && this.arreglo[randomIndex]){
                return this.count;
            }
            return randomIndex;
        }


        //public boolean equals(BooleanSet a, BooleanSet b){
            //BooleanSet c = new BooleanSet();
            //while(!b.isEmpty()){
                //int element = b.choose();

            }
        }



