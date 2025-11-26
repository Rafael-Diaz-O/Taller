
package Dijskstra;

import static Dijskstra.Dijsktra.dijkstra;
import java.util.Scanner;

public class main {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        //solicita al usuario ingresar el numero de nodos 
        System.out.println("Ingrese el numero de nodos: ");
        int numNodos = scanner.nextInt();
        
        //solicita al usuario ingresar la matriz de adyacencia (peso de las aristas)
        int [][] grafo = new int[numNodos][numNodos];
        System.out.println("Ingresa la matriz de adyacencia (use 0 si no hay conexion");
        for(int i = 0; i < numNodos; i++){
            for(int j=0; j<numNodos;j++){
                grafo [i][j] = scanner.nextInt();
                
            }
        }
        
        //solicita al usuario ingresar el nodo de inicio
        System.out.println("Ingrese el nodo  de inicio (entre 0 y " + (numNodos-1) + ")");
        int nodoInicial = scanner.nextInt();
        
        //Llama al algoritmo de Dijkstra
        dijkstra(grafo,nodoInicial);
        
        
        
        
    }
    
}

//matriz 

//0 4 0 3
//4 0 5 0
//0 5 0 2
//3 0 2 0 


