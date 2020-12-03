package model;
public abstract class Coach extends Employee{
	public int experienceYears;
	/** 
     * this constructor calls the super method Employee to create a Coach
     * <b>pre:</b> it needs the normal Employee data and some extra Coach data
     * <b>post:</b> the objet Player is crated
     * @param name String, name of the Employee
     * @param id int, id number of the Employee
     * @param salary String, salary of the Employee
     * @param experienceYears int, amount of coach's years of experience
     */
	public Coach(String name, int id, double salary, int experienceYears){
		super(name,id,salary);
		this.experienceYears = experienceYears;
	}
	public String toString(){
		String x = super.toString() + "\n" +"__Anos de experiencia: " + experienceYears + "\n";
		return x;
	}
	//Get
	public int getExperienceYears(){
		return this.experienceYears;
	}
	//Set
	public void setExperienceYears(int xp){
		this.experienceYears = xp;
	}
}