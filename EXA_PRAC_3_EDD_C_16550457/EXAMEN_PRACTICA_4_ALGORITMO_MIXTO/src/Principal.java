
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Code Slayer, lil' Temo, D-Bugger 
 */
public class Principal {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        long timeIni,timeFin;
        int size = 10;
        boolean bRes = true;
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*(int)(size*1.5)+1);
        }
        while(!comparar(arr,size)){
            size++;
        }
        System.out.println(size);
        while(bRes){
        System.out.println("cual sera el tamaño del arreglo?");
        int tamanioUsuario = sc.nextInt();
        int[] usuario = new int[tamanioUsuario];
        for (int i = 0; i < usuario.length; i++) {
            System.out.println("valor en la posición "+i+":");
            usuario[i] = sc.nextInt();
        }
        if(tamanioUsuario > size){     
            System.out.println("Quick Sort");
            imprimir(usuario);
            timeIni = (int)(System.nanoTime());
            quickSort(usuario);
            timeFin = (int)(System.nanoTime());
            System.out.println("");
            imprimir(usuario);
            System.out.println("");
            double elapsedTime =  timeFin- timeIni;
            System.out.print("tomó : "+(elapsedTime)+" Nanosegundos");
            System.out.println(": "+(double)(elapsedTime)/1000000000+" Segundos");

        }else{
            System.out.println("Insertion sort");
            imprimir(usuario);
            timeIni = (int)(System.nanoTime());
            insertionSort(usuario);
            timeFin = (int)(System.nanoTime());
            System.out.println("");
            imprimir(usuario);
            System.out.println("");         
            double elapsedTime =  timeFin- timeIni;
            System.out.print("tomó : "+(elapsedTime)+" Nanosegundos");
            System.out.println(": "+(double)(elapsedTime)/1000000000+" Segundos");
        }
        System.out.println("si no desea continuar escriba 0");
        int iRes = sc.nextInt();
        if(iRes == 0){
            bRes= false;
        }
        }
    }
    
    public static boolean comparar(int[] arr,int size){
        boolean skra = false;
        arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int)(Math.random()*(int)(size*1.5)+1);
        }
        int[] copia = new int[arr.length];
        for (int i = 0; i < size; i++) {
            copia[i] = arr[i];
        }
        int quickTimeIni = (int)(System.nanoTime());
        quickSort(arr);
        int quickTimeFin = (int)(System.nanoTime());
        int quickMaths = quickTimeFin - quickTimeIni;
        
        int insertTimeIni = (int)(System.nanoTime());
        insertionSort(copia);
        int insertTimeFin = (int)(System.nanoTime());
        int insertMaths = insertTimeFin - insertTimeIni;
        
        if(insertMaths > quickMaths*2){
            skra = true;
            //System.out.println("the things goes skra");
            //System.out.println("quick maths "+quickMaths*2);
            //System.out.println("insert maths "+insertMaths);
        }
        return skra;
    }
    
    
    public static void insertSort(int[] array, int n) {
        for (int i = 1; i < n; i++) {
            int tmp = array[i];
            int j = i; 
            while ((j > 0) && (tmp < array[j - 1])) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = tmp;
        }
    }
    

    public static void insertionSort(int[] arr) {
        insertSort(arr, arr.length);
    }
    public static void quickSort(int[] arr, int min, int max) {
        int izquierda = min;
        int pivote = arr[min];
        int derecha = max;
        while (izquierda < derecha) {
            while (arr[izquierda] <= pivote && izquierda < derecha) {
                izquierda++;
            }
            while (arr[derecha] > pivote) {
                derecha--;
            }
            if (izquierda < derecha) {
                int temp = arr[izquierda];
                arr[izquierda] = arr[derecha];
                arr[derecha] = temp;
            }
        }
        arr[min] = arr[derecha];
        arr[derecha] = pivote;
        if (min < derecha - 1) {
            quickSort(arr, min, derecha - 1);
        }
        if (derecha + 1 < max) {
            quickSort(arr, derecha + 1, max);
        }
    }
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }
    public static int[] array(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * (int)(size*1.5) + 1);
        }
        return array;
    }

    public static void imprimir(int[] arr) {
        for (int x : arr) {
            System.out.print(x + "-");
        }
    }
    
}
