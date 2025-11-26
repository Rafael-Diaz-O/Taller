package Kruskal;


public class main {
    
   
    public static void main(String[] args) {
      
        Grafo_Matriz_Adyacencia g = new Grafo_Matriz_Adyacencia(4); // creaqmos los 4 noos {0,1,2,3} los indices
        
     g.agregarArista(0, 1, 10);
    g.agregarArista(0, 2, 6);
    g.agregarArista(0, 3, 5);
    g.agregarArista(1, 3, 15);
    g.agregarArista(2, 3, 4);
     
        g.imprimirGrafo();// muestra las coneciones que tiene ese grafo 
        g.bfs(0);
        
            g.kruskalMST();
        
    
        }
}