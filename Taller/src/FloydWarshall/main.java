package FloydWarshall;

import static FloydWarshall.FloydWarshall.floydWarshall;


public class main {
    
    public static void main(String[] args) {
        
        //Definimos INF como un valor muy grande para representar el infinito (sin conexion)
        int INF = 100000000;
        
        //La matriz de adyacencia inicial del grafo 
        int[][] distancias = {{0,4,INF,5,INF},
            {INF,0,1,INF,6},
            {2,INF,0,3,INF},
            {INF,INF,1,0,2},
            {1,INF,INF,4,0}};
            
        floydWarshall(distancias);
        
        System.out.println("Matriz de Distancias Minimas: ");
        //imprimo la matriz resultante
        for(int i=0; i < distancias.length; i++){
            for(int j = 0; j <distancias.length;j++){               
                System.out.print(distancias[i][j] + " ");
            }
            System.out.println();
        }
        
    }
    
    
    
}
