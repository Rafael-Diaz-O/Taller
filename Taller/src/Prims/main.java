package Prims;

import java.util.*;

public class main {
    
      public static void main (String[] args) {
        System.out.println("--- Iniciando el Algoritmo de Prim ---");
        
        int V = 3; // vertice 
        int A = 3; //aristas
        
        //0 = origen 1= destino 5 peso
        
        int graph[][] = new int[][] {{0,1,5}, 
                                     {1,2,3}, 
                                     {0,2,1}};
        
        // 1. Llamar al método de cálculo
        ArrayList<String> mst = PrimMST.calcularCostoMST(V, A, graph); 
        
        // 2. Llamar al método de presentación 
        PrimMST.mostrarMST(mst); 
    }
      
      
      
}
