package model;
import java.util.ArrayList;
import java.util.Collections;
public class Club{
	public String name;
	public int nit;
	public String foundationDate;
	public Team team1;
	public Team team2;
	public ArrayList <Employee> workers;
	Player[][] dressRoomsA = new Player[7][7];
	Player[][] dressRoomsB = new Player[7][6];
	Coach[][] officeSector = new Coach[6][6];
	/** 
     * this constructor method creates a Club objet
     * @param name String, the name of the Club
     * @param nit int, the NIT of the Club
     * @param foundationDate String, the foundation date of the Club
     */
	public Club(String name, int nit, String foundationDate){
		workers = new ArrayList <Employee>();
		this.name = name;
		this.nit = nit;
		this.foundationDate = foundationDate;
	}
	public void addAligment(String date, int tac, int team){
		Tactic tactic = null;
		switch(tac){
			case 1: tactic = Tactic.POSESION;
			break;
			case 2: tactic = Tactic.CONTRAATAQUE;
			break;
			case 3: tactic = Tactic.PRESION_ALTA;
			break;
			case 4: tactic = Tactic.POR_DEFECTO;
			break;
		}
		if(team == 1){
			team1.makeAligment(date,tactic);
		}else if(team == 2){
			team2.makeAligment(date,tactic);
		}else{
			System.out.println("El equipo no existe");
		}
	}
	public void makeFormation(String tName, int back, int center, int front){

	}
	/** 
     * this method shows the coaches in the 1st team dressroom
     * <b>pre:</b> the main must have called him
     * <b>post:</b> shows dressroomA info
     */
	public void showDressRoomsA(){
		for(int i = 0; i < 7; i++){
			for(int j = 0; j < 7; j++){
				if(dressRoomsA[i][j] != null){
					System.out.print(" (" + dressRoomsA[i][j].getName() + ")");	
				}else{
					System.out.print(" (" + "empty" + ")");
				}
			}
			System.out.print("\n");
		}
	}
	/** 
     * this method shows the coaches in the 2nd team dressroom
     * <b>pre:</b> the main must have called him
     * <b>post:</b> shows dressroomB info
     */
	public void showDressRoomsB(){
		for(int i = 0; i < 7; i++){
			for(int j = 0; j < 6; j++){
				if(dressRoomsB[i][j] != null){
					System.out.print(" (" + dressRoomsB[i][j].getName() + ")");	
				}else{
					System.out.print(" (" + "empty" + ")");
				}
			}
			System.out.print("\n");
		}
	}
	/** 
     * this method shows the coaches in the offices
     * <b>pre:</b> the main must have called him
     * <b>post:</b> shows offices info
     */
	public void showOffices(){
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 6; j++){
				if(officeSector[i][j] != null){
					System.out.print(" (" + officeSector[i][j].getName() + ")");	
				}else{
					System.out.print(" (" + "empty" + ")");
				}
			}
			System.out.print("\n");
		}
	}
	/** 
     * this method calls the toString of all the employees and prints it
     * <b>pre:</b> the main must have called him
     * <b>post:</b> shows all employee's info
     */
	public void getAllEmployees(){
		String x = "";
		for(int i = 0; i < workers.size(); i++){
			x += workers.get(i).toString();
		}
		System.out.println(x);
	}
	/** 
     * this method calls the toString of an employee and prints it
     * <b>pre:</b> the main must have called him
     * <b>post:</b> shows employee's info
     * @param pos int, Employee position
     */
	public void showEmployee(int pos){
		String x = "";
		x = workers.get(pos).toString();
		System.out.println(x);
	}
	/** 
     * this method calls the toString of a team and prints it
     * <b>pre:</b> the main must have called him
     * <b>post:</b> shows team's info
     * @param pos int, wich team is
     */
	public String showTeam(String tName){
		String x = team1.toString();
		if(team1 != null && tName.equalsIgnoreCase(team1.getName())){
			x = team1.toString();
		}else if(team2 != null && tName.equalsIgnoreCase(team2.getName())){
			x = team2.toString();
		}
		return x;
	}
	/** 
     * this method changes an employee's state from active to inactive
     * <b>pre:</b> the main must have called him
     * <b>post:</b> puts the "active" atribute in false
     * @param pos int, Employee position
     */
	public void employeeFired(int pos){
		boolean teamA = false;
		boolean teamB = false;
		workers.get(pos).setActive(false);
		teamA = team1.fireEmployeeOnTeam(workers.get(pos).getName());
		if(!teamA){
			teamB = team2.fireEmployeeOnTeam(workers.get(pos).getName());
		}
		if(!teamB && !teamA){
			System.out.println("El empleado se despidio");
		}else{
			System.out.println("El empleado se despidio y se elimino de su respectivo equipo");
		}
	}
	/** 
     * this method puts employees in teyr respective facilities
     * <b>pre:</b> the main must have called him
     * <b>post:</b> puts an employee in a matrix
     */
	public void addEmployeesToFacilities(){
		Collections.shuffle(workers);
		cleanMatrix();
		int x = 0;
		System.out.println("entro al metodo");
		for(int i = 0; i < 7 && x < workers.size(); i++){
			for(int j = i % 2; j < 7 && x < workers.size(); j += 2){
				if(dressRoomsA[i][j] == null && x < workers.size() && workers.get(x) instanceof Player){
					System.out.println(workers.get(x).getName());
					while(x < workers.size() && workers.get(x).getParticipant() != 'A'){
						x++;
					}
					if(x < workers.size()){
						dressRoomsA[i][j] = (Player)workers.get(x);
					}
				}
				x++;
			}
		}
		x = 0;
		for(int i = 0; i < 7; i++){
			for(int j = i % 2; j < 6; j += 2){
				if(dressRoomsB[i][j] == null && x < workers.size() && workers.get(x) instanceof Player){
					if(workers.get(x).getParticipant() == 'B'){
						dressRoomsB[i][j] = (Player)workers.get(x);
					}
				}
				x++;
			}
		}
		x = 0;
		for(int i = 0; i < 6; i+=2){
			for(int j = i % 2; j < 6; j += 2){
				if(officeSector[i][j] == null && x < workers.size() && workers.get(x) instanceof Coach){
					if(workers.get(x).getParticipant() == 'B' || workers.get(x).getParticipant() == 'A'){
						officeSector[i][j] = (Coach)workers.get(x);
					}
				}
				x++;
			}
		}
	}
	public void cleanMatrix(){
		for(int i = 0; i < 7; i++){
			for(int j = 0; j < 7; j++){
				dressRoomsA[i][j] = null;
			}
		}
		for(int i = 0; i < 7; i++){
			for(int j = 0; j < 6; j++){
				dressRoomsB[i][j] = null;
			}
		}
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 6; j++){
				officeSector[i][j] = null;
			}
		}
	}
	/** 
     * this method calls the interface to calculate the level and price of an employee 
     * <b>pre:</b> the Player must have a position
     * <b>post:</b> sows the Player's level and price
     * @param pos int, Employee position
     */
	public void calculate(int pos){
		double price = 0;
		double level = 0;
		price = workers.get(pos).calculatePrice();
			level = workers.get(pos).calculateLevel();
		if(price == 0.0 && level == 0.0){
			System.out.println("El empleado es un asistente, por lo tanto no puede realizarse este calculo");
		}else{
			System.out.println("__El precio del empleado es: " + price + "\n" + 
								"__El nivel del empleado es: " + level);
		}
	}
	/** 
     * this method adds an Player to a team
     * <b>pre:</b> the Player's position and the team
     * <b>post:</b> adds the employee to the team
     * @param pos int, Player position
     * @param numTeam int, indicate the team
     */
	public void addPlayerToTeam(String name, int numTeam){
		int pos = 0;
		boolean entroA = false;
		boolean entroB = false;
		pos = findEmployee(name);
		if(workers.get(pos) instanceof Player){
			if(numTeam == 1){
				entroA = team1.addTeamPlayer((Player)workers.get(pos));
			}else if(numTeam == 2){
				entroB = team2.addTeamPlayer((Player)workers.get(pos));
			}
			if(entroA){
				System.out.println("entro antes del metodo A");
				workers.get(pos).setParticipant('A');
				addEmployeesToFacilities();
			}else if(entroB){
				System.out.println("entro antes del metodo B");
				workers.get(pos).setParticipant('B');
				addEmployeesToFacilities();
			}
		}else{
			System.out.println("El empleado no es un jugador");
		}

	}
	/** 
     * this method adds an MainCoach to a team
     * <b>pre:</b> the MainCoach's position and the team
     * <b>post:</b> adds the MainCoach to the team
     * @param pos int, MainCoach position
     * @param numTeam int, indicate the team
     */
	public void addMainCoachToTeam(String name, int numTeam){
		int pos = 0;
		boolean entroA = false;
		boolean entroB = false;
		pos = findEmployee(name);
		if(workers.get(pos) instanceof MainCoach){
			if(numTeam == 1){
				entroA = team1.addTeamMainCoach((MainCoach)workers.get(pos));
				//addMainCoachToDressRoomsA(pos);
			}else if(numTeam == 2){
				entroB = team2.addTeamMainCoach((MainCoach)workers.get(pos));
				//addMainCoachToDressRoomsA(pos);
			}
			if(entroA){
				workers.get(pos).setParticipant('A');
				addEmployeesToFacilities();
			}else if(entroB){
				workers.get(pos).setParticipant('B');
				addEmployeesToFacilities();
			}
		}else{
			System.out.println("El empleado no es un entrenador principal");
		}

	}
	/** 
     * this method adds an AssistantCoach to a team
     * <b>pre:</b> the AssistantCoach's position and the team
     * <b>post:</b> adds the AssistantCoach to the team
     * @param pos int, AssistantCoach position
     * @param numTeam int, indicate the team
     */
	public void addAssistantCoachToTeam(String name, int numTeam){
		int pos = 0;
		boolean entroA = false;
		boolean entroB = false;
		pos = findEmployee(name);
		if(workers.get(pos) instanceof AssistantCoach){
			if(numTeam == 1){
				entroA = team1.addTeamAssistantCoach((AssistantCoach)workers.get(pos));
				//addAssistantCoachToDressRoomsA(pos);
			}else if(numTeam == 2){
				entroB = team2.addTeamAssistantCoach((AssistantCoach)workers.get(pos));
				//addAssistantCoachToDressRoomsA(pos);
			}
			if(entroA){
				workers.get(pos).setParticipant('A');
				addEmployeesToFacilities();
			}else if(entroB){
				workers.get(pos).setParticipant('B');
				addEmployeesToFacilities();
			}
		}else{
			System.out.println("El empleado no es un entranador asistente");
		}

	}
	/** 
     * this method search the team by usin his name
     * <b>pre:</b> the name of the team
     * <b>post:</b> an integer wich identifies the team 
     * @param tName String, team's name
     * @return an integer wich identifies the team
     */
	public int findTeam(String tName){
		int x = -1;
		System.out.println(tName + " / " + team1.getName());
		if(team1 != null && tName.equalsIgnoreCase(team1.getName())){
			x = 1;
		}
		if(team2 != null && tName.equalsIgnoreCase(team2.getName())){
			x = 2;
		}
		return x;
	}
	/** 
     * this method search the Employee by usin his name
     * <b>pre:</b> the name of the Employee
     * <b>post:</b> an integer wich is the Employee position on the array 
     * @param name String, Employee's name
     * @return Employee position on the array
     */
	public int findEmployee(String name){
		int x = -1;
		for(int i = 0; i <  workers.size(); i++){
			if(workers.get(i).getName().equalsIgnoreCase(name)){
				x = i;
			}
		}
		return x;
	}
	/** 
     * this method uses the  data to add values to a team 
     * <b>pre:</b> it must have been called by the main
     * <b>post:</b> adds data to the team 
     * @param name String, Team's name
     * @return confirms if the team was created succesfully
     */
	public String addTeam(String name){
		String x = "No se pueden crear mas equipos";
		if(team1 == null){
			team1 = new Team(name);
			x = "El primer equipo ha sido creado";
		}else if(team2 == null){
			team2 = new Team(name);
			x = "El segundo equipo ha sido creado";
		}
		return x;
	}
	public boolean repets(Employee element){
		boolean salir = false;
		for(int i = 0; i < workers.size(); i++){
			if(workers.get(i) != null && element.getName().equalsIgnoreCase(workers.get(i).getName()) &&
			    element.getId() == workers.get(i).getId() && salir == false){
				salir = true;
			}
		}
		return salir;
	}
	/** 
     * this method uses the  data to call the constructor and make a Player
     * <b>pre:</b> it must have been called by the main
     * <b>post:</b> calls the constructor and makes a Player
     * @param name String, Player's name
     * @param id int, Player's id
     * @param salary double, Player's salary
     * @param tShirt int, Player's t-shirt number
     * @param goals int, Player's amount of goals
     * @param averageScore double, Player's average score
     * @param pos int, Player's position
     */
	public void addPlayer(String name, int id, double salary, int tShirt, int goals,
							 double averageScore, int pos){
		Player carry;
		Position position = null;
		int i = 0;
		boolean encontro = false;
		switch(pos){
			case 1: position = Position.DELANTERO;
			break;
			case 2: position = Position.DEFENSOR;
			break;
			case 3: position = Position.PORTERO;
			break;
			case 4: position = Position.VOLANTE;
			break;
		}
		carry = new Player(name,id,salary,tShirt,goals,averageScore,position);
		encontro = repets(carry);
		if(encontro == true){
			System.out.println("El empleado no se puede agregar porque tiene un nombre o id igual a otro que ya existe");
		}
		if(encontro == false){
			workers.add(carry);
		}
	}
	/** 
     * this method uses the  data to call the constructor and make a MainCoach
     * <b>pre:</b> it must have been called by the main
     * <b>post:</b> calls the constructor and makes a MainCoach
     * @param name String, MainCoach's name
     * @param id int, MainCoach's id
     * @param salary double, MainCoach's salary
     * @param experienceYears int, the years of experience of the MainCoach
     * @param teamsNum int, the amount of teams tat the MainCoach has worked on
     * @param wonChampions int, MainCoach's won champions
     */
	public void addMainCoach(String name, int id, double salary,
							 int experienceYears, int teamsNum, int wonChampions){
		MainCoach carry;
		int i = 0;
		boolean encontro = false;
		carry = new MainCoach(name,id,salary,experienceYears,teamsNum,wonChampions);
		encontro = repets(carry);
		if(encontro == true){
			System.out.println("El empleado no se puede agregar porque tiene un nombre o id igual a otro que ya existe");
		}
		if(encontro == false){
			workers.add(carry);
		}
	}
	/** 
     * this method uses the  data to call the constructor and make a AssistantCoach
     * <b>pre:</b> it must have been called by the main
     * <b>post:</b> calls the constructor and makes a AssistantCoach
     * @param name String, AssistantCoach's name
     * @param id int, AssistantCoach's id
     * @param salary double, AssistantCoach's salary
     * @param experienceYears int, the years of experience of the AssistantCoach
     * @param pro boolean, if the AssistantCoach was a profesional player
     * @param expertice int, AssistantCoach's Expertice
     */
	public void addAssistantCoach(String name, int id, double salary, int experienceYears, boolean pro,
							  int expertice){
		Expertice expert = null;
		int i = 0;
		AssistantCoach carry;
		boolean encontro = false;
		switch(expertice){
			case 1: expert = Expertice.OFENSIVO;
			break;
			case 2: expert = Expertice.POSESION;
			break;
			case 3: expert = Expertice.JUGADA_DE_LABORATORIO;
			break;
			case 4: expert = Expertice.DEFENSIVO;
			break;
		}
		carry = new AssistantCoach(name,id,salary,experienceYears,pro,expert);
		encontro = repets(carry);
		if(encontro == true){
			System.out.println("El empleado no se puede agregar porque tiene un nombre o id igual a otro que ya existe");
		}
		if(encontro == false){
			workers.add(carry);
		}
	}
	//Get
	/*public getDressroomA (){
		for 
	}*/
	public String getName(){
		return this.name;
	}
	//Set
	public void setName(String name){
		this.name = name;
	}
}