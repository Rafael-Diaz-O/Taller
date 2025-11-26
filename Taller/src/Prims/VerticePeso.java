package Prims;


public class VerticePeso implements Comparable<VerticePeso> {
    //Comparable esta interfas le indica que compare los objectos de esta clase tipo VerticePeso 
    //solo se comparan entre si con objectos tipo VerticePeso 
    
    int vertice;
    int peso; 
    
    public VerticePeso(int vertice, int peso){
        this.vertice = vertice;
        this.peso = peso;
    }
    
    
    //nos ayuda a identificar la arista con menor peso
    public int compareTo(VerticePeso otro){
        
        return this.peso-otro.peso; // compara el objecto peso con el siguiente objecto
        // se verifica cual de los dos objectos es de menor peso 
    }
    
}
