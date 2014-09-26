/*
 * Escribe una aplicación modular en Java que solicite por consola al usuario el número
 * de elementos que tendrá un array unidimensional de enteros. El contenido del array será
 * calculando aleatoriamente por el programa siendo posibles valores enteros de 0 a 100.
 * 
 * A continuación el programa deberá ejecutar las siguientes acciones:
 * 
 *      a) Solicitar al usuario una posición y un valor. Insertar en el vector en la posición
 *          dada el valor dado. Mostrar por consola el contenido del Array.
 * 
 *      b) Calcular y mostrar el valor más alto y el valor más bajo de Array.
 * 
 *      c) Calcular la media de todos los valores y mostrar los valores del Array que se 
 *          encuentran por encima de esta media.
 * 
 *  Antes de comenzar a programar, define el pseudocode o flowchart de la aplicación.
 * 
 *  Requisitos no funcionales de la aplicación:
 * 
 *      · El programa solo puede contener una clase
 *      · El programa debe ser modular
 *      · Cada módulo del programa debe disponer de una breve descripción funcional del mismo
 *      · El programa debe respetar The Clean Coding Practices
 */
package pkg14_15_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Gonxis
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        
        System.out.print("Introduce número de elementos de la Array Unidimensional: ");
        int dim = Integer.parseInt(stdin.readLine());
        int [] array = new int [dim];
        int pos = 0, valor = 0;
        Main.correcto(dim, pos);
        Main.apartado1(array);
        
        do{
            System.out.print("Indica posición: ");
            pos = Integer.parseInt(stdin.readLine())-1;
        } while (pos > dim || pos<=0);
        Main.correcto(dim, pos);
        System.out.print("Indica valor de la posición: ");
        valor = Integer.parseInt(stdin.readLine());
        array [pos] = valor;
        Main.apartado_a(array);
        
        Main.apartado_b_y_c(array, dim);
        System.out.println("");
        System.out.println("El valor mayor de la Array es " + mayor);
        System.out.println("El valor menor de la Array es " + menor);
        
        System.out.println("");
        System.out.println("La media es " + media);
        System.out.print("Los valores por encima de la media son: ");
        for (int i = 0; i < array.length; i++){
            if (array [i] > media){
                System.out.print(array [i] + "  ");
            }
        }
    }
    
    private static void correcto (int dim, int pos){
        if ((dim%2!=0) || (pos > dim)){
            System.out.println("Error al introducir valor.");
            Runtime.getRuntime().exit(0);
        }
    }
    
    private static void apartado1 (int [] array){
        for (int i = 0; i < array.length; i++){
            array [i] = (int) (Math.random()*101);
        }
        for (int i = 0; i < array.length; i++){
            System.out.print(array [i] + "  ");
        }
        System.out.println("");
        System.out.println("");
    }
    
    private static void apartado_a (int [] array){
        for (int i = 0; i < array.length; i++){
            System.out.print(array [i] + "  ");
        }
        System.out.println("");
    }
    
    private static void apartado_b_y_c (int [] array, int dim){
        
        int mayor = 0;
        int menor = 100;
        for (int i = 0; i < array.length; i++){
            if (array [i] > mayor){
                mayor = array [i];
            } else if (array [i] < menor){
                menor = array [i];
            }
        }
        
        int suma = 0;
        for (int i = 0; i < array.length; i++){
            suma = array [i] + suma;
        }
        int media = suma/dim;       
    }
}
