package metier;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Compte implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double solde ;
	private int code ;
	private String date_creation ;


	
	public Compte(int code ,double solde) {
		this.code = code ;
		this.solde =solde ;
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		date_creation =  format.format(calendar.getTime()) ;
	}
	
	public int getCode() {
		return code ;
	}
	
	public String getDate() {
		return date_creation;
	}
	public double getSolde() {
		return solde ;
	}
	
	public void setCode(int code) {
		this.code = code ;
	}
	public void setSolde(double solde) { 
		this.solde = solde ;
	}
	public String toString() {
		return "code: "+getCode()+" solde: "+getSolde()+" date de creation: "+getDate();
	}

}
