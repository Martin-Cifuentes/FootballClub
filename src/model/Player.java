package model;
public class Player  extends Employee{
	public int tShirt;
	public int goals;
	public double averageScore;
	public Position pos;
	/** 
     * this constructor calls the super method Employee to create a Player
     * <b>pre:</b> it needs the normal Employee data and some extra Player data
     * <b>post:</b> the objet Player is crated
     * @param name String, name of the Employee
     * @param id int, id number of the Employee
     * @param salary String, salary of the Employee
     * @param tShirt int, number of the player's t-shirt
     * @param goals int, amount of goals thet the Player has scored
     * @param averageScore double, the player's score
     */
	public Player(String name, int id, double salary, int tShirt, int goals, double averageScore, Position pos){
		super(name,id,salary);
		this.tShirt = tShirt;
		this.goals = goals;
		this.averageScore = averageScore;
		this.pos = pos;
	}
	/** 
     * this method calculates the price of the Player 
     * <b>pre:</b> the Player must have a position
     * <b>post:</b> returns the Player's price
     * @return the Player's price
     */
	public double calculatePrice(){
		double price = 0;
		switch(pos){
			case PORTERO:
				price = (salary * 12) + (averageScore * 150);
			break;
			case DEFENSOR:
				price = (salary * 13) + (averageScore * 125) + (goals * 100);
			break;
			case VOLANTE:
				price = (salary * 14) + (averageScore * 135) + (goals * 125);
			break;
			case DELANTERO:
				price = (salary * 15) + (averageScore * 145) + (goals * 150);
			break;
		}
		return price;
	}
	/** 
     * this method calculates the level of the Player 
     * <b>pre:</b> the Player must have a position
     * <b>post:</b> returns the Player's level
     * @return the Player's level
     */
	public double calculateLevel(){
		double level = 0;
		switch(pos){
			case PORTERO:
				level = averageScore * 0.9;
			break;
			case DEFENSOR:
				level = (averageScore * 0.9) + (goals / 100);
			break;
			case VOLANTE:
				level = (averageScore * 0.9) + (goals / 90);
			break;
			case DELANTERO:
				level = (averageScore * 0.9) + (goals / 80);
			break;
		}
		return level;
	}

	public String toString(){
		String x = "_________________Jugador________________\n" + super.toString() + "\n" +
					 "__Numero de la Camiseta: " + tShirt + "\n" + "__Goles: " + goals + "\n"
					 + "__Puntaje promedio: " + averageScore + "\n" + "__Posicion: " + pos + "\n";
		return x;
	}
	//Gets
	public int getTShirt(){
		return this.tShirt;
	}
	public int getGoals(){
		return this.goals;
	}
	public double getAverageScore(){
		return this.averageScore;
	}
	//Sets
	public void setTShirt(int ts){
		this.tShirt = ts;
	}
	public void setGoals(int goals){
		this.goals = goals;
	}
	public void setAverageScore(double averageScore){
		this.averageScore = averageScore;
	}
	
}