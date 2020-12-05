package model;
public class Team{
	public static final int CANT_PLAYERS = 25;
	public static final int CANT_ASSISTANT_COACH = 3;
	private String name;
	private Player[] players;
	private MainCoach mCoach;
	private AssistantCoach[] aCoaches;
	private Aligment aligment;
	/** 
     * this constructor method creates a Team objet
     * @param name String, the name of the Club
     */
	public Team(String name){
		this.name = name;
		this.players = new Player[CANT_PLAYERS];
		this.mCoach = null;
		this.aCoaches = new AssistantCoach[CANT_ASSISTANT_COACH];
		this.aligment = null;
	}
	public void makeAligment(String date, Tactic tactic){
		this.aligment = new Aligment(date,tactic);
	}
	public void showForm(){
		if(aligment != null){
			aligment.getFormation();	
		}else{
			System.out.println("No se ha creado una alineacion aun asi que no se puede mostrar una formacion aun");
		}
	}
	public void editFormation(int back, int middle, int front){
		aligment.setFormationTo(back,middle,front);
	}
	/** 
     * this method puts in null the employee that is been eliminated, only if this is on the team
     * <b>pre:</b> name of the employee that is been eliminated
     * <b>post:</b> puts in null the employee
     * @param name name of the employee that is been eliminated
     * @return boolean, confirms if the employee was on a team
     */
	public boolean fireEmployeeOnTeam(String name){
		boolean find = false;
		if(mCoach != null && mCoach.getName().equalsIgnoreCase(name)){
			mCoach = null;
			find = true;
		}else{
			for(int i = 0; i < CANT_ASSISTANT_COACH && !find; i++){
				if(aCoaches[i] != null && aCoaches[i].getName().equalsIgnoreCase(name)){
					aCoaches[i] = null;
					find = true;
				}
			}
			if(!find){
				for(int i = 0; i < CANT_PLAYERS && !find; i++){
					if(players[i] != null && players[i].getName().equalsIgnoreCase(name)){
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
	public boolean addTeamPlayer(Player adding){
		boolean salir = false;
		boolean entro = false;
		if(players[CANT_PLAYERS - 1] == null){
			for(int i = 0; i < CANT_PLAYERS && !salir; i++){
				if(players[i] != null && players[i] == adding){
					System.out.println("El jugador ya estaba agregado");
					salir = true;
				}
				if(players[i] == null){
					players[i] = adding;
					entro = true;
					salir = true;
				}
			}
		}else{
			System.out.println("El equipo esta lleno");
		}
		return entro;
	}
	/** 
     * this method adds an MainCoach to his array of employees
     * <b>pre:</b> the MainCoach
     * <b>post:</b> adds the MainCoach to the team
     * @param adding MainCoach, the MainCoach that'a gonna be added
     */
	public boolean addTeamMainCoach(MainCoach adding){
		boolean entro = false;
		if(mCoach == null){
			mCoach = adding;
			entro = true;
		}else{
			System.out.println("El equipo ya tiene un entrenador principal");
		}
		return entro;
	}
	/** 
     * this method adds an AssistantCoach to his array of employees
     * <b>pre:</b> the AssistantCoach
     * <b>post:</b> adds the AssistantCoach to the team
     * @param adding AssistantCoach, the AssistantCoach that'a gonna be added
     */
	public boolean addTeamAssistantCoach(AssistantCoach adding){
		boolean salir = false;
		boolean entro = false;
		if(aCoaches[CANT_ASSISTANT_COACH - 1] == null){
			for(int i = 0; i < CANT_ASSISTANT_COACH && !salir; i++){
				if(aCoaches[i] != null && aCoaches[i] == adding){
					System.out.println("El entrenador asistente ya estaba agregado");
					salir = true;
				}
				if(aCoaches[i] == null){
					aCoaches[i] = adding;
					salir = true;
					entro = true;
				}
			}
		}else{
			System.out.println("El equipo esta lleno");
		}
		return entro;
	}
	//toString
	public String toString(){
		String x = "___________________Equipo__________________\n" + "__Nombre: " + getName() + "\n"
				 + "________________Integrantes________________\n"
				 + "____________Entrenador Principal___________\n";

		if(mCoach != null){
			x += mCoach.toString() + "\n";
		}
		x += "__________Entrenadores Asistentes__________\n";
		for(int i = 0; i < 3; i++){
			if(aCoaches[i] != null){
				x += aCoaches[i].toString() + "\n";
			}
		}
		x += "_________________Jugadores_________________\n";
		for(int i = 0; i < 25; i++){
			if(players[i] != null){
				x += players[i].toString() + "\n";
			}
		}
		return x;
	}
	//Gets
	public String getName(){
		return this.name;
	}
	//Set
	public void setName(String name){
		this.name = name;
	}
}