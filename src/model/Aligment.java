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
			for(int j = 0; j < 7; j++){
				formation[i][j] = 0;
			}
		}
	}
	public void cleanFormation(){
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 7; j++){
				formation[i][j] = 0;
			}
		}
	}
	public void setFormationTo(int back,int middle,int front){
		cleanFormation();
		//back
		for(int i = 0; i < back; i++){
			formation[8][i] = 1;
		}
		//middle
		for(int i = 0; i < middle; i++){
			formation[5][i] = 1;
		}
		//front
		for(int i = 0; i < front; i++){
			formation[2][i] = 1;
		}
	}
	public void getFormation(){
		System.out.println("_________________Alineacion________________\n" + "__Fecha: " + date + "\n__Tactica: " + tactic + "\n__Formacion:\n") ;
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 7; j++){
				System.out.print(" (" + formation[i][j] + ")");
			}
			System.out.print("\n");
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