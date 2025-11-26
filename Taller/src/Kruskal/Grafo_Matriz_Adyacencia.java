
package Kruskal;

import java.util.Queue;
import java.util.LinkedList;
import java.util.*;


public class Grafo_Matriz_Adyacencia {
    
    private int V ; // numero de vertices
    private int A; // numero de aristas 
    private int[][] matrizAdyacencia;
    PesoAristas[] pesoAristas; // matriz que almacena las aristas 
    
    
    public Grafo_Matriz_Adyacencia(int nodos){
        this.V = nodos;
        this.A = 0;
        this.matrizAdyacencia = new int[nodos][nodos];
        pesoAristas  = new PesoAristas[A];
    }
    
    
    public void agregarArista(int u,int v,int peso){ // como tiene peso es u grafo ponderado las aristas tiene un sierto peso
        matrizAdyacencia[u][v] = peso;
        matrizAdyacencia[v][u] = peso;// no dirigido 
        A++;
    }
    
    
    public void imprimirGrafo(){
        for(int v = 0; v<V; v++){
            System.out.println("Fila" + v + ": ");
            for(int w = 0; w<V; w++){
                System.out.println(matrizAdyacencia[v][w]+ "");
            }
            System.out.println("");
        }
    }
    
    
    public void bfs(int s) {
    // 1. Array para rastrear nodos visitados
    boolean[] visited = new boolean[V]; 

    // 2. Cola (Queue) para gestionar los nodos a explorar (FIFO)
    Queue<Integer> q = new LinkedList<>(); 

    // 3. Inicializar
    visited[s] = true;
    q.offer(s); // Agregar el nodo de inicio a la cola

    while (!q.isEmpty()) {
        
        // Sacar el nodo actual de la cola
        int u = q.poll(); 
        System.out.print(u + " "); // Procesar/imprimir el nodo

        // 4. Búsqueda de Vecinos en la Matriz
        // Recorrer TODAS las posibles columnas (w) en la fila 'u'
        for (int w = 0; w < V; w++) {
            
            // Comprobar si hay una arista (1) Y si el nodo no ha sido visitado
            if (matrizAdyacencia[u][w] == 1 && !visited[w]) {
                
                visited[w] = true; // Marcar como visitado
                q.offer(w);        // Agregar a la cola para explorar sus vecinos más tarde
            }
        }
    }
}
    
    // una funcion de utilidad para encontrar el subconjunto  de un elemento i 
    
     int find(int[] parent,int i){
        if(parent[i] == -1){
            return i ;
        }
        return find(parent,parent[i]);
    }
    
    // una funcion de utilidad para realizar la union de dos  subconjuntos 
    
     void union(int [] parent, int x, int y ){
        int xset = find(parent, x);
        int yset = find(parent, y);
        parent[xset] = yset;
    }
    
    // metodo para encontrar el arbol recubridor minimo 
    public void kruskalMST(){
        List<PesoAristas> ListaPesos = new ArrayList<>();
        int aristaCount = 0;
        
        for( int u = 0; u<V; u++){
            for(int v = u+1; v<V; v++){
                int peso = matrizAdyacencia[u][v];
                
                if(peso > 0){
                    ListaPesos.add(new PesoAristas(u,v,peso));
                    aristaCount++;
                }
            }
        }
        
        // Convertir la lista a un array para poder ordenar y usar el algoritmo
        PesoAristas[] peso = ListaPesos.toArray(new PesoAristas[aristaCount]);
        
        // 2. ORDENAR LAS ARISTAS
        Arrays.sort(peso);

        // 3. CONSTRUCCIÓN DEL MST (Lógica de Kruskal)
        
        PesoAristas[] result = new PesoAristas[V - 1]; // Almacena el MST
        int e = 0; // Contador de aristas añadidas al MST
        int i = 0; // Índice para recorrer las aristas ordenadas
        
        // Inicializar el sistema Union-Find (todos los nodos en su propio conjunto)
        int[] parent = new int[V];
        Arrays.fill(parent, -1);

        while (e < V - 1 && i < aristaCount) {
            
         
            PesoAristas siguiente_Arista = peso[i++]; 

            int x = find(parent, siguiente_Arista.origen);
            int y = find(parent, siguiente_Arista.destino);

            // Si no forman un ciclo, agregar al MST y unir los conjuntos
            if (x != y) {
                result[e++] = siguiente_Arista;
                union(parent, x, y);
            }
        }
        
        //  imprimir resultados
        System.out.println("\n--- Aristas del Arbol de Expansion Minima (MST) ---");
        int pesototal = 0;
        for (i = 0; i < e; ++i) {
            System.out.println(result[i].origen + " - " + result[i].destino + ": " + result[i].peso);
            pesototal += result[i].peso;
        }
        System.out.println("Peso total del MST: " + pesototal);
    }
    

    
   
    }


