/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lista;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Code Slayer, lil' Temo, D-Bugger 
 */
public class Lista {
    private int[] num;
    private final Graphics g;
    private final Canvas c;
    private final int sep = 20;
    
    public Lista(Canvas c){
        this.c = c;
        g = c.getGraphics();
    }
    
    public void generar(){
        int size = c.getWidth()/sep;
        int altura = c.getHeight();
        
        num = new int[size];
        for (int i = 0; i < num.length; i++) {
            num[i] = (int)(Math.random()*(altura-20)+10);
        }
        this.dibujar();
    }
    
    private void dibujar(){
        g.clearRect(0, 0, c.getWidth(), c.getHeight());
        int x = 20,y;
        int altura = c.getHeight();
        int d = 10;
        
        for (int i = 0; i < num.length; i++) {
            y = num[i];
            g.setColor(Color.red);
            g.fillOval(x, altura-y, d, d);
            x+=sep;
        }
    }
    
    private void esperar(){
        this.dibujar();
        try {
            Thread.sleep(300); //detiene el programa medio segundo, cantidad a su criterio.
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    
    public void bubble_sort(){
        int temp;
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num.length-i-1; j++) {
                if(num[j]>num[j+1]){
                    temp = num[j];
                    num[j] = num[j+1];
                    num[j+1] = temp;
                    this.esperar();
                }
                
            }
        }
    }
     
    public void ins_sort(){
        int insP,temp;
        for (int i = 1; i < num.length; i++) {
            temp = num[i];
            insP = i;
            for (int j = i-1; j >= 0; j--) {
                if(num[j]>temp){
                    num[j+1]=num[j];
                    insP = j;
                    this.esperar();
                } else{
                    break;
                }
            }
            num[insP]=temp;
            this.esperar();
        }
    }
    
    public  void quick_sort(){
        quick_sort(num, 0, num.length);
        this.esperar();
    }
    
    private  void quick_sort(int[] a,int inicio,int fin){
        //Si la seccion es de tamaño 1, se termina la recursion
        if(inicio == fin) return;
        int iLeft=inicio,iRight=fin-1;
        //Seleccionamos un pivote al azar entre el inicio y el fin
        int pivote = (int)(Math.random()*(fin-inicio))+inicio;
        //int pivote = inicio;
        int temp;
        
        //Movemos el pivote al final de la seccion
        temp = a[pivote];
        a[pivote] = a[fin-1];
        a[fin-1] = temp;
        
        while(iRight > iLeft){
            //Busca valres mayores al pivote, moviendose de izq a derecha
            for (iLeft = iLeft; iLeft < fin-1; iLeft++) {
                if(a[iLeft]>a[fin-1]){
                    break;
                }
            }
            //Busca valores menores, moviendose de derecha a izq
            for (iRight = iRight; iRight >= inicio; iRight--) {
                if(a[iRight]<a[fin-1]){
                    break;
                }
            }
            
            //Si el valor de la izq sigue siendo menor, hace el cambio
            if(iLeft < iRight){
                temp = a[iLeft];
                a[iLeft] = a[iRight];
                a[iRight] = temp;
                this.esperar();
            }
        }
        
        //Almacenamos el pivote
        temp = a[fin-1];
        //Insertamos el pivote solo si es antes de la posicion donde el pivote
        //se encuentra actualmente
        if(iLeft < fin-1){
            a[fin-1] = a[iLeft];
            a[iLeft] = temp;
        }
         
        //Aplicamos quick sort al lado izquierdo
        if(inicio < iLeft){
            quick_sort(a, inicio, iLeft);
        }
        
        //Aplicamos quick sort al lado derecho
        if(iLeft < fin){
            //System.out.println("Derecha: fin="+fin);
            quick_sort(a, iLeft+1, fin);
        }
        
    }
      
}
