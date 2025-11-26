package Dijskstra;

import java.util.Scanner;


public class Dijsktra {
    
    private static final int INFINITO = Integer.MAX_VALUE;
    
    public static void  dijkstra(int [][] grafo,int nodoInicial){ // Recibe la matriz de adyacencia del grafo (grafo) y el nodo de partida (nodoInicial).
        // Obtengo el número total de nodos a partir de la longitud de la matriz del grafo.
        int numNodos = grafo.length;
        // Creo un array para almacenar las distancias más cortas desde el nodo inicial a todos los demás
        int[] distancias = new int[numNodos];
        // Creo un array booleano para rastrear qué nodos ya han sido incluidos en el camino más corto.
        boolean[] visitado = new boolean[numNodos];
        
        //Inicializacion: Todas  las distancias son infinitas y los nodos son no visitados
        for(int i =0; i< numNodos; i++){
            // Establece la distancia inicial a todos los nodos como 'infinito'.
            distancias[i] = INFINITO;
            // Marco todos los nodos como 'no visitados' inicialmente.
            visitado[i] = false;
        }
        
        //La distanica al nodo de inicio es 0
        distancias[nodoInicial] = 0;
        
        //Itera para encontrar las distancias mas cortas 
        for(int i =0; i< numNodos -1;i++){
            //Encuentra el nodo no visitado con la distancia minima
            int nodoDistanciaMinima = encontrarNodoDistanciaMinima(distancias,visitado);
            visitado[nodoDistanciaMinima]= true;
            
            //Actualiza las distancias de los nodos Vecinos 
            for(int j = 0; j < numNodos; j++){
                // Compruebo las 4 condiciones para la 'relajación' (actualización de distancias):
                // Condición 1: El nodo 'j' todavía no ha sido visitado.
                if(!visitado[j]
                        // Condición 2: Existe una arista directa entre 'nodoDistanciaMinima' y 'j' (peso > 0).
                        && grafo[nodoDistanciaMinima][j] !=0 
                        // Condición 3: El nodo actual ('nodoDistanciaMinima') es accesible (su distancia no es INFINITO).
                        && distancias[nodoDistanciaMinima] != INFINITO 
                        // Condición 4: El camino a través del nodo actual es más corto que la distancia registrada anteriormente a 'j'.
                        && distancias[nodoDistanciaMinima] + grafo[nodoDistanciaMinima][j]<distancias[j]){
                           
                    // Si se cumplen las condiciones, actualiza la distancia del nodo 'j'.
                    // Nueva distancia = Distancia al nodo intermedio + Peso de la arista.
                    distancias[j] = distancias [nodoDistanciaMinima] + grafo [nodoDistanciaMinima][j];
                }
            }
        }
        
        
        //imprimir las distancias mas cortas
        System.out.println("Distancias mas cortas desde el nodo"+ nodoInicial + ":");
        
    
        for(int i=0; i<numNodos;i++){
            System.out.println("Hasta el nodo" + i + ":" + distancias[i]);
        }
    
        
    }
    
    
    
    //Metodo auxiliar para encontrar el nodo no visitado con la distancia minima
    private static int encontrarNodoDistanciaMinima(int[] distancias , boolean[] visitado){
        int distanciaMinima=INFINITO;
        int nodoDistanciaMinima= -1;
        
       for(int i = 0; i <distancias.length;i++){
           if(!visitado[i] &&distancias[i] <= distanciaMinima){
               distanciaMinima = distancias[i];
               nodoDistanciaMinima = i; 
           }
       }
       return nodoDistanciaMinima;
    }
    
    
    
    
}
