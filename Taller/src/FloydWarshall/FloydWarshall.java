package FloydWarshall;


public class FloydWarshall {
    
    //resuelve el problema de la ruta mas corta entre todos los pare de nodos 
    
    public static void floydWarshall(int[][] matrizDistancia){
        //V = numero de vertices (Nodos)
        int numVertices = matrizDistancia.length;
        
        //Añade todos los vertices un por uno al 
        // conjunto de vértices intermedios (k)
        //K es el nodo intermedio 
        
        for(int k = 0; k < numVertices; k++){
            
            //Toma todos los vertices como origen uno por uno 
            //i es el nodo de origen
            for(int i =0; i < numVertices;i++){
                //Toma todos los vertices como destino
                //para el origen(i) previamente seleccionado 
                //j es el nodo de destino
                for(int j =0; j < numVertices; j++){
                    //Si hay camino de i a k y de k a j 
                    // Usamos 1e8 para representar el valor de infinito
                    if(matrizDistancia [i][k] != 1e8 && matrizDistancia [k][j] != 1e8){
                        //Actualiza la distancia mas corta de i a j 
                        matrizDistancia[i][j] = Math.min(matrizDistancia [i] [j], matrizDistancia [i][k] +matrizDistancia[k][j]);
                    }
                }
            }
        }


    }
    
    
    
    
}
