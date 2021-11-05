package exe3;

import java.io.Serializable;




public class Operateur implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -6525418004953729717L;
	Double x ;
    Double y ;
     String op;
    
    public Operateur(Double x,Double y,String op){
        this.x = x ;
        this.y = y ;
        this.op = op ;
        
        
    }
    
    public Double getx(){
        return x ;
    }
    public Double gety(){
        return y ;
    }
    public String getop(){
        return op ;
    }
    
}