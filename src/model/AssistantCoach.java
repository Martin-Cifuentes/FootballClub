package model;
public class AssistantCoach extends Coach{
	public boolean proPlayer;
	public Expertice expertice;
	/** 
     * this constructor calls the super method Coach to create a assistant coach
     * <b>pre:</b> it needs the normal Coach data and some extra assistant coach data
     * <b>post:</b> the objet Player is crated
     * @param name String, name of the assistant coach
     * @param id int, id number of the assistant coach
     * @param salary String, salary of the assistant coach
     * @param experienceYears int, amount of coach's years of experience
     * @param proPlayer boolean, to confirm if the assistant coach was a pro player
     * @param expertice Expertice, the expertice of the assistant coach
     */
	public AssistantCoach(String name, int id, double salary, int experienceYears, boolean pro, Expertice expertice){
		super(name,id,salary,experienceYears);
		this.proPlayer = pro;
		this.expertice = expertice;
	}
	public double calculatePrice(){
		return 0;
	}
	public double calculateLevel(){
		return 0;
	}
	//toString
	public String toString(){
		String y = "El coach NO fue un jugador profesional";
		if(proPlayer){
			y = "El coach fue un ugador profesional";
		}
		String x = "__________Entrenador Asistente__________\n" + super.toString() + "\n" + y + "\n" + "__Experticia: " + expertice + "\n";
		return x;
	}
	//Gets
	public boolean getProPlayer(){
		return this.proPlayer;
	}
	public Expertice getExpertice(){
		return this.expertice;
	}
	//Sets
	public void setProPlayer(boolean proPlayer){
		this.proPlayer = proPlayer;
	}
	public void setExpertice(Expertice expertice){
		this.expertice = expertice;
	}

}