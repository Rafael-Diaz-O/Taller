
package Prims;

import java.util.*;

//Prim algoritmo que esta siendo impementado
//MST Arbol recubridor minimo
public class PrimMST {
    
    public static ArrayList<String> calcularCostoMST(int vertice, int arista, int AristaGrafo [] []){
        ArrayList<ArrayList<VerticePeso>> adyacencia = new ArrayList<>(); // la lista de adyacencia
        
        //Lista Principal	Contiene todos los vértices del grafo por índice.	ArrayList
        //Lista Interna	Contiene los vecinos y el costo para llegar a ellos.	ArrayList<VerticePeso>
        //
        
        for(int i = 0; i< vertice; i++){
            adyacencia.add(new ArrayList<VerticePeso>()); //creo primero los vertices vacios antes de llenarlos o enlazarlos
        }
        for(int i =0; i<AristaGrafo.length; i++){
            
            int origen = AristaGrafo[i][0];// el primer vertice de una arista 
            int siguiente = AristaGrafo[i][1];// el segundo vertice de la arista 
            int peso = AristaGrafo[i][2];// el peso de la arista 
            adyacencia.get(origen).add(new VerticePeso(siguiente,peso) ); // coneta a u -> v y calcula el peso 
            adyacencia.get(siguiente).add(new VerticePeso(origen,peso));// coneta a v -> u y calcula el peso
            
        }
        
        PriorityQueue<VerticePeso> conexionesPosibles = new PriorityQueue<VerticePeso>(); //Guarda todas las aristas candidatas que conectan un vértice ya en el MST con un vértice que aún no está en él.
        //ordena los elementos de la pila por la prioridad que este tnega en este caso por la arista mas pequeña 
        conexionesPosibles.add(new VerticePeso(0,0)); //Inserta el vértice de inicio (asumido como el vértice 0) con un peso de 0. Esto arranca el proceso de construcción del MST.
        int[] vis = new int[vertice];
        
        
        // Añadir arreglo para rastrear el padre (de dónde vino la arista)
        int[] parent = new int[vertice]; // alamacena las coneciones del MST 
        for(int i = 0; i < vertice; i++) parent[i] = -1; // Inicializar en -1
        
        // Lista para guardar las aristas del MST (el resultado)
        ArrayList<String> mstAristas = new ArrayList<>();

  
        while(!conexionesPosibles.isEmpty()){
            VerticePeso nodo = conexionesPosibles.poll();
            int Vertice = nodo.vertice;//El vértice de destino del VerctorPeso extraído.
            int peso = nodo.peso; //El peso de la arista extraída.
            
            if(vis[Vertice] == 1){ //Evita ciclos: Si el vértice Vertice ya es parte del MST, la arista es obsoleta o forma un ciclo, por lo que se salta la iteración (continue).
                continue;
                
            }
            
            //  Registrar la arista seleccionada al entrar al MST (si no es el nodo inicial -1)
            if (parent[Vertice] != -1) {
                //se añade la arista, una vez que se confirma que es la de meno peso 
                 mstAristas.add("(" + parent[Vertice] + " -- " + Vertice + ") con peso " + peso);
            }
            
            vis[Vertice] = 1;
             
            
            
            for(VerticePeso it: adyacencia.get(Vertice)){ //Recorre todos los vecinos (it) conectados directamente al vértice v (usando la Lista de Adyacencia
                int vecino = it.vertice;
                int pesoArista = it.peso;
                
                if(vis[vecino]==0){ 
                    //  Registrar el padre antes de añadir a la cola
                    parent[vecino] = Vertice; 
                    conexionesPosibles.add(new VerticePeso(vecino, pesoArista));
                }
            }
                   
                   
        }
        
       // Devolver la lista de aristas del MST
        return mstAristas;
        
    }
    // muestra las conceciones que forman el arbol
    public static void mostrarMST(ArrayList<String> mstAristas) {
    if (mstAristas.isEmpty()) {
        System.out.println("El grafo no está conectado o es trivial.");
        return;
    }

    System.out.println("\n --- ARISTAS DEL ARBOL DE EXPANSION MINIMA (MST) --- ");
    
    int costoTotal = 0;
    
    for (String Arista : mstAristas) {
        System.out.println(Arista);
        
        // Extraer el peso para calcular el costo total (opcional, basado en el formato del string)
        try {
             // Busca el número de peso al final del string (Ej: ...peso 5)
             int inicioPeso = Arista.lastIndexOf(' ');
             String strPeso = Arista.substring(inicioPeso + 1);
             costoTotal += Integer.parseInt(strPeso);
        } catch (Exception e) {
            // Manejo de error si el formato no es el esperado
        }
    }
    
    System.out.println("-------------------------------------------------------");
    System.out.println("Costo Total del MST: " + costoTotal);
}
    
     
    
    
    
    
}
