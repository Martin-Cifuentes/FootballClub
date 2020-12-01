package model;
public class Team{
	public static final int CANT_PLAYERS = 25;
	public static final int CANT_ASSISTANT_COACH = 3;
	private String name;
	private Player[] players;
	private MainCoach mCoach;
	private AssistantCoach[] aCoaches;
	/** 
     * this constructor method creates a Team objet
     * @param name String, the name of the Club
     */
	public Team(String name){
		this.name = name;
		this.players = new Player[CANT_PLAYERS];
		this.mCoach = null;
		this.aCoaches = new AssistantCoach[CANT_ASSISTANT_COACH];
	}
	public boolean fireEmployeeOnTeam(String name){
		boolean find = false;
		if(mCoach.getName().equalsIgnoreCase(name)){
			mCoach = null;
			find = true;
		}else{
			for(int i = 0; i < CANT_ASSISTANT_COACH || !find; i++){
				if(aCoaches[i].getName().equalsIgnoreCase(name)){
					aCoaches[i] = null;
					find = true;
				}
			}
			if(!find){
				for(int i = 0; i < CANT_PLAYERS || !find; i++){
					if(players[i].getName().equalsIgnoreCase(name)){
						players[i] = null;
						find = true;
					}
				}
			}
		}
		return find;
	}
	/** 
     * this method adds an Player to his array of employees
     * <b>pre:</b> the Player
     * <b>post:</b> adds the Player to the team
     * @param adding Player, the Player that'a gonna be added
     */
	public void addTeamPlayer(Player adding){
		boolean salir = false;
		if(players[CANT_PLAYERS - 1] == null){
			for(int i = 0; i < CANT_PLAYERS || !salir; i++){
				if(players[i] != null && players[i] == adding){
					System.out.println("El jugador ya estaba agregado");
					salir = true;
				}
				if(players[i] == null){
					players[i] = adding;
					salir = true;
				}
			}
		}else{
			System.out.println("El equipo esta lleno");
		}
	}
	/** 
     * this method adds an MainCoach to his array of employees
     * <b>pre:</b> the MainCoach
     * <b>post:</b> adds the MainCoach to the team
     * @param adding MainCoach, the MainCoach that'a gonna be added
     */
	public void addTeamMainCoach(MainCoach adding){
		boolean salir = false;
		if(mCoach == null){
			mCoach = adding;
		}else{
			System.out.println("El equipo ya tiene un entrenador principal");
		}
	}
	/** 
     * this method adds an AssistantCoach to his array of employees
     * <b>pre:</b> the AssistantCoach
     * <b>post:</b> adds the AssistantCoach to the team
     * @param adding AssistantCoach, the AssistantCoach that'a gonna be added
     */
	public void addTeamAssistantCoach(AssistantCoach adding){
		boolean salir = false;
		if(aCoaches[CANT_ASSISTANT_COACH - 1] == null){
			for(int i = 0; i < CANT_ASSISTANT_COACH || !salir; i++){
				if(aCoaches[i] != null && aCoaches[i] == adding){
					System.out.println("El entrenador asistente ya estaba agregado");
					salir = true;
				}
				if(aCoaches[i] == null){
					aCoaches[i] = adding;
					salir = true;
				}
			}
		}else{
			System.out.println("El equipo esta lleno");
		}
	}
	//toString
	public String toString(){
		String x = "__________Equipo__________\n" + "__Nombre: " + getName() + "\n";
		return x;
	}
	//Get
	public String getName(){
		return this.name;
	}
	//Set
	public void setName(String name){
		this.name = name;
	}
}