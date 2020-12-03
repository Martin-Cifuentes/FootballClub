package model;
public class MainCoach extends Coach{
	public int teamsNum;
	public int wonChampions;
	/** 
     * this constructor calls the super method Coach to create a main coach
     * <b>pre:</b> it needs the normal Coach data and some extra main coach data
     * <b>post:</b> the objet main Coach is crated
     * @param name String, name of the main Coach
     * @param id int, id number of the main Coach
     * @param salary String, salary of the main Coach
     * @param experienceYears int, amount of coach's years of experience
     * @param teamsNum int, the amount of teams that the coach has been in charge on his career
     * @param wonChampions int, the championships won by the head coach's team
     */
	public MainCoach(String name, int id, double salary, int experienceYears, int teamsNum, int wonChampions){
		super(name,id,salary,experienceYears);
		this.teamsNum = teamsNum;
		this.wonChampions = wonChampions;
	}
	/** 
     * this method calculates the price of the main Coach 
     * <b>pre:</b> the main Coach must have a position
     * <b>post:</b> returns the main Coach's price
     * @return the main Coach's price
     */
	public double calculatePrice(){
		double price = 0;
		price = (salary * 10) + (experienceYears * 100) + (wonChampions * 50);
		return price;
	}
	/** 
     * this method calculates the level of the main Coach 
     * <b>pre:</b> the main Coach must have a position
     * <b>post:</b> returns the main Coach's level
     * @return the main Coach's level
     */
	public double calculateLevel(){
		double level = 0;
		level = 5 + (wonChampions / 10);
		return level;
	}

	//toString
	public String toString(){
		String x = "__________Entrenador Principal__________\n" + super.toString() + 
					 "__Campeonatos Ganados: " + wonChampions + "\n" + "__Equipos de experiencia: " + teamsNum + "\n";
		return x;
	}
	//Gets
	public int getTeamsNum(){
		return this.teamsNum;
	}
	public int getWonChampions(){
		return this.wonChampions;
	}
	//Sets
	public void setProPlayer(int teamsNum){
		this.teamsNum = teamsNum;
	}
	public void setWonChampions(int wonChampions){
		this.wonChampions = wonChampions;
	}
}
