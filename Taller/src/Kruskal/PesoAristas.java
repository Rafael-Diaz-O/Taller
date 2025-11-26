package Kruskal;

import java.util.*;

public class PesoAristas implements Comparable<PesoAristas> {
    
    int origen;
    int destino;
    int peso;
    
    public PesoAristas (int origen,int destino, int peso){
        this.destino = destino;
        this.origen = origen;
        this.peso = peso;
    }
    
    // comparar dos aristas segun su peso 
    
    @Override
    public int compareTo(PesoAristas comparePesoAristas){
        return this.peso - comparePesoAristas.peso;
        
    }
    
//    Como tal, compareTo() realiza una comparación posicional entre dos objetos de la misma clase. 
//     Devuelve un número entero que indica el resultado de esa comparación.
            
}
