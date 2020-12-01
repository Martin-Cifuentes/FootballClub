package model;
public abstract class Aligment{
	public String date;
	public int[][] formation;
	/** 
     * this constructor method creates a Aligment objet
     * @param date String, date of the Aligment
     * @param formation int, formation of the Aligment
     */
	public Aligment(String date){
		this.date = date;
		this.formation = new int[10][7];
	}
}