package model;
public class Aligment{
	private String date;
	private int[][] formation;
	private Tactic tactic;
	/** 
     * this constructor method creates a Aligment objet
     * @param date String, date of the Aligment
     * @param formation int, formation of the Aligment
     */
	public Aligment(String date, Tactic tactic){
		this.date = date;
		this.formation = new int[10][7];
		this.tactic = tactic;
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				formation[i][j] = 0;
			}
		}
	}
	public void setFormation(){
		for(int i = 0; i < 10; i++){
			System.out.println("a");
		}
	}
	//Gets
	public String getDate(){
		return this.date;
	}
	//Sets
	public void setDate(String date){
		this.date = date;
	}
}