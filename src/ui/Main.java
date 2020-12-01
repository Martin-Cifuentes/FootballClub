package ui;
import model.*;
import java.util.Scanner;
public class Main{

	public static Club futClub;
	public final static Scanner sc = new Scanner(System.in);

	public static void main(String[] args){
		loadData();
		//addClubData();
		int o = 1;
		while(o != 0){
			o = menu();
			definineAction(o);
		}
		
		createEmployee();
	}
	/** 
     * this method shows the posible actions that the user is able to do
     * <b>pre:</b> doesn't aply
     * <b>post:</b> returns the user decision
     * @return int user decision
     */
	public static int menu(){
		int opcion;
		System.out.println("________PPPPPPPPPPPPPPPPPPPPPPPPPP _________");
		System.out.println("________PPPPPPPPPPPPPPPPPPPPPPPPPP _________");
		System.out.println("___PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP ___");
		System.out.println("_PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP _");
		System.out.println("PPPP _____PPPPPPPPPPPPPPPPPPPPPP_______PPPP ");
		System.out.println("PPP ______PPPPPPPPPPPPPPPPPPPPPP________PPP ");
		System.out.println("PP _______PPPPPPPPPPPPPPPPPPPPPP________PPP ");
		System.out.println("PPP ____PPPPPPPPPPPPPPPPPPPPPPPPPP______PPP ");
		System.out.println("PPP ___PPPPPPPPPPPPPPPPPPPPPPPPPPPP____PPPP ");
		System.out.println("_PPP __PPP_PPPPPPPPPPPPPPPPPPPP_PPP____PPP _");
		System.out.println("_PPPP __PPP_PPPPPPPPPPPPPPPPPP_PPPP__PPPP __");
		System.out.println("___PPPP _PPPPPPPPPPPPPPPPPPPPPPPPP_PPPPP ___");
		System.out.println("____PPPPPPP_PPPPPPPPPPPPPPPP_PPPPPPPPPP ____");
		System.out.println("______PPPPPP__PPPPPPPPPPPPPP___PPPPPP ______");
		System.out.println("_______________PPPPPPPPPPPP ________________");
		System.out.println("_________________PPPPPPPP __________________");
		System.out.println("___________________PPPP ____________________");
		System.out.println("___________________PPPP ____________________");
		System.out.println("___________________PPPP ____________________");
		System.out.println("___________________PPPP ____________________");
		System.out.println("_______________PPPPPPPPPPPP ________________");
		System.out.println("____________PPPPPPPPPPPPPPPPPP _____________");
		System.out.println("____________PPPPPPPPPPPPPPPPPP _____________");
		System.out.println("____________PPP_Bienvenido_PPP _____________");
		System.out.println("____________PPP_____Al_____PPP _____________");
		System.out.println("____________PPP__Club_App__PPP _____________");
		System.out.println("____________PPPPPPPPPPPPPPPPPP _____________");
		System.out.println("____________PPPPPPPPPPPPPPPPPP _____________");
		System.out.println("__________PPPPPPPPPPPPPPPPPPPPPP ___________");
		System.out.println("_________PPPPPPPPPPPPPPPPPPPPPPPPP__________");
		System.out.println("____________________MENU____________________");
		System.out.println("-(1) Agregar Empleado");
		System.out.println("-(2) Agregar Equipo");
		System.out.println("-(3) asignar Empleado a equipo");
		System.out.println("-(4) Crear Formacion");
		System.out.println("-(5) Mostrar informacion de empleado");
		System.out.println("-(6) Mostrar informacion de equipo");
		System.out.println("-(7) Mostrar toda la informacion");
		System.out.println("-(8) Calcular precio y nivel de un Empleado");
		System.out.println("-(9) Despedir a un empleado");
		System.out.println("-(10) Eliminar a un empleado de un equipo");
		System.out.println("-(0) Salir");
		System.out.println("____________________________________________");
		opcion = sc.nextInt();
		sc.nextLine();
		return opcion;
	}
	/** 
     * this method calls to another, guided by the option that the user choose
     * <b>pre:</b> the param number must be an integer and a valid option
     * <b>post:</b> the user's action has been defined
     * @param op valid int betwen the options
     */
	public static void definineAction(int op){
		switch(op){
			case 0: //done
			break;
			case 1: createEmployee();//done
			break;
			case 2: createTeam();//done
			break;
			case 3: addEmployeeToTeam();//done
			break;
			/*case 4: createFormation();//done
			break;
			case 5: showEmployeeInfo();//done
			break;
			case 6: showTeamInfo();//done
			break;
			case 7: showAllInfo();//done
			break;*/
			case 8: calculateEmployee();//done
			break;
			case 9: fireEmployee();//done
			break;
			default: System.out.println("Opcion no valida, intente nuevamente");
			//menu();
			break;
		}
	}

	public static void fireEmployee(){
		String name = "";
		int pos = 0;
		System.out.println("Ingrese el nombre del empleado que desea despedir");
		name = sc.nextLine();
		pos = futClub.findEmployee(name);
		futClub.employeeFired(pos);
	}
	/** 
     * this method ask for the necesary data to add a Employee to a Team
     * <b>pre:</b> it must have been chosen by the user on menu
     * <b>post:</b> the data was acquired 
     */
	public static void addEmployeeToTeam(){
		String name = "";
		String tName = "";
		int type = 0;
		int exist = 0;
		int teamPos = 0;
		System.out.println("Ingrese el nombre del empleado que desea agregar");
		name = sc.nextLine();
		System.out.println("Ingrese el nombre del equipo al que desea agregar el empleado");
		tName = sc.nextLine();
		System.out.println("indique el tipo de empleado:\n(1)Jugador\n(2)Entrenador Principal\n(3)Entrenador Asistente");
		type = sc.nextInt();
		sc.nextLine();
		exist = futClub.findEmployee(name);
		teamPos = futClub.findTeam(tName);
		if(exist > 0 && teamPos > 0){
			switch(type){
				case 1: futClub.addPlayerToTeam(exist,teamPos);
				break;
				/*case 2: futClub.addMainCoachToTeam(exist,teamPos);
				break;
				case 3: futClub.addAssistantCoachToTeam(exist,teamPos);
				break;*/
			}
		}else{
			System.out.println("El equipo o empleado no existe");
		}
	}
	/** 
     * this method ask for the necesary data to create a team
     * <b>pre:</b> it must have been chosen by the user on menu
     * <b>post:</b> the data was acquired 
     */
	public static void createTeam(){
		String name = "";
		String confirm = "";
		System.out.println("Ingrese el nombre del club");
		name = sc.nextLine();
		confirm = futClub.addTeam(name);
		System.out.println(confirm);
	}
	/** 
     * this method ask for the necesary data to make the club
     * <b>pre:</b> doesn't aply
     * <b>post:</b> adds the Club info
     */
	public static void addClubData(){
		String foundation = "";
		String name = "";
		int nit = 0;
		System.out.println("____________________________________________");
		System.out.println("____________________________________________");
		System.out.println("_________________Bienvenido_________________");
		System.out.println("____________________________________________");
		System.out.println("____________________________________________");
		System.out.println("Primero se deben añadir los datos del club...");
		System.out.println("Ingrese el nombre del club");
		name = sc.nextLine();
		System.out.println("Ingrese el NIT del club");
		nit = sc.nextInt();
		sc.nextLine();
		System.out.println("Ingrese la fecha de fundacion del club");
		foundation = sc.nextLine();
		futClub = new Club(name,nit,foundation);
	}
	public static void loadData(){
		futClub = new Club("Football",12345623,"12/08/05");
		futClub.addPlayer("martin",3333333,35.99,12,6,24,1);
		futClub.addMainCoach("toto",24852745,22.934,23,5,4);
		futClub.addAssistantCoach("gogo",1847598734,12.85,10,true,1);
		/*calculate(player1);
		calculate(coach1);
		calculate(coach2);*/
	}
	/** 
     * this method ask for the name of the Employee to calculate the price and level of the employee 
     * <b>pre:</b> it must have been chosen by the user on menu
     * <b>post:</b> calls a method on Club to complete the action
     */
	public static void calculateEmployee(){
		String name = "";
		int employee = 0;
		System.out.println("Inserte el nombre");
		name = sc.nextLine();
		employee = futClub.findEmployee(name);
		if(employee >= 0){
			futClub.calculate(employee);
		}else{
			System.out.println("El empleado no existe");
		}
		System.out.println("____________________________________________");
		System.out.println("____________________________________________");
		
	}
		/** 
     * this method ask for the necesary data to create an Employee
     * <b>pre:</b> it must have been chosen by the user on menu
     * <b>post:</b> the data was acquired 
     */
	public static void createEmployee(){
		String name = "";
		int type, id ;
		double salary;
		boolean proPlay;
		System.out.println("Inserte el nombre");
		name = sc.nextLine();
		System.out.println("Inserte el id");
		id = sc.nextInt();
		sc.nextLine();
		System.out.println("Inserte el salario");
		salary = sc.nextDouble();
		sc.nextLine();
		System.out.println("indique el tipo de empleado:\n(1)Jugador\n(2)Entrenador Principal\n(3)Entrenador Asistente");
		type = sc.nextInt();
		sc.nextLine();
		switch(type){
			case 1: createPlayer(name,id,salary);
			break;
			case 2: createMainCoach(name,id,salary);
			break;
			case 3: createAssistantCoach(name,id,salary);
			break;
		}
	}
	/** 
     * this method ask for the necesary data to create a Player
     * <b>pre:</b> it must have been chosen by the user on menu
     * <b>post:</b> the data was acquired 
     */
	public static void createPlayer(String name, int id, double salary){
		//player
		int tShirt, goals, pos;
		double average;
		System.out.println("Inserte la camiza");
		tShirt = sc.nextInt();
		sc.nextLine();
		System.out.println("Inserte el numero de goles");
		goals = sc.nextInt();
		sc.nextLine();
		System.out.println("Inserte el punteje promedio");
		average = sc.nextDouble();
		sc.nextLine();
		System.out.println("Inserte la posicicion:\n(1)DELANTERO\n(2)DEFENSOR\n(3)PORTERO\n(4)VOLANTE");
		pos = sc.nextInt();
		sc.nextLine();
		futClub.addPlayer(name,id,salary,tShirt,goals,average,pos);
	}
	/** 
     * this method ask for the necesary data to create a Main Coach
     * <b>pre:</b> it must have been chosen by the user on menu
     * <b>post:</b> the data was acquired 
     */
	public static void createMainCoach(String name, int id, double salary){
		int xpYears, won, teams;
		System.out.println("Inserte los anos de experiencia");
		xpYears = sc.nextInt();
		sc.nextLine();
		System.out.println("Inserte el numero de campeonatos ganados");
		won = sc.nextInt();
		sc.nextLine();
		System.out.println("Inserte la cantidad de equipos en que ha estado");
		teams = sc.nextInt();
		sc.nextLine();
		futClub.addMainCoach(name,id,salary,xpYears,won,teams);
	}
	/** 
     * this method ask for the necesary data to create an Assistant Coach
     * <b>pre:</b> it must have been chosen by the user on menu
     * <b>post:</b> the data was acquired 
     */
	public static void createAssistantCoach(String name, int id, double salary){
		int xpYears, pro, expertice;
		boolean proPlay;
		System.out.println("Inserte los anos de experiencia");
		xpYears = sc.nextInt();
		sc.nextLine();
		System.out.println("fue un jugador profesional:\n(1)Si\n(2)No");
		pro = sc.nextInt();
		sc.nextLine();
		System.out.println("Inserte la experticia:\n(1)OFENSIVO\n(2)POSESION\n(3)JUGADA_DE_LABORATORIO\n(4)DEFENSIVO");
		expertice = sc.nextInt();
		sc.nextLine();
		if(pro == 1){
			proPlay = true;
		}else{
			proPlay = false;
		}
		futClub.addAssistantCoach(name,id,salary,xpYears,proPlay,expertice);
	}
}