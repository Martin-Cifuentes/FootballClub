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
		System.out.println("-(10) Mostrar instalaciones");
		System.out.println("-(11) Mostrar Formacion");
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
			case 3: addEmployeeToTeam();
			break;
			/*case 4: createAligment();//done
			break;*/
			case 5: showEmployeeInfo();//done
			break;
			case 6: showTeamInfo();//done
			break;
			case 7: showAllInfo();//done
			break;
			case 8: calculateEmployee();//done
			break;
			case 9: fireEmployee();//done
			break;
			case 10: showFacilities();//done
			break;
			case 12: createFormation();//done
			break;
			/*case 12: showFormation();//done
			break;*/
			default: System.out.println("Opcion no valida, intente nuevamente");
			//menu();
			break;
		}
	}
	public static void createAligment(){
		String tName = "";
		String date = "";
		int tactic = 0;
		int team = 0;
		System.out.println("Ingrese el nombre del equipo al que le va a añadir la alineacion");
		tName = sc.nextLine();
		team = futClub.findTeam(tName);
		System.out.println("Ingrese la fecha de la alineacion");
		date = sc.nextLine();
		System.out.println("Ingrese la tactica de la alineacion:\n(1)POSESION\n(2)CONTRAATAQUE\n(3)PRESION_ALTA\n(4)POR_DEFECTO");
		tactic = sc.nextInt();
		sc.nextLine();
		futClub.addAligment(date,tactic,team);
	}
	public static void createFormation(){
		int a = 0;
		int b = 0;
		int c = 0;
		String tName = "";
		System.out.println("Inserte el nombre del equipo para el que va a hacer la formacion");
		tName = sc.nextLine();
		System.out.println("Inserte un numero para los defensas");
		a = sc.nextInt();
		sc.nextLine();
		if(a < 7){
			System.out.println("Inserte un numero para los centro campistas");
			System.out.print(a + "-");
			b = sc.nextInt();
			sc.nextLine();

			if(b < 7){
				System.out.println("Inserte un numero para los delanteros");
				System.out.print(a + "-" + b + "-");
				c = sc.nextInt();
				sc.nextLine();
				if(a+b+c == 10){
					futClub.makeFormation(tName,a,b,c);
				}else{
					System.out.println("valores no validos, la suma de los numeros tienen que ser 10");
				}
			}else{
				System.out.println("valor no valido, no puede ingresar un valor mayor a 7");
			}
		}else{
			System.out.println("valor no valido, no puede ingresar un valor mayor a 7");
		}
		
	}
	public static void showFacilities(){
		int ans = 0;
		int x = 0;
		String tName = "";
		System.out.println("que instalaciones desea ver?\n(1)Vestidores\n(2)Oficinas");
		ans = sc.nextInt();
		sc.nextLine();
		if(ans == 1){
			System.out.println("escriba el nombre del equipo");
			tName = sc.nextLine();
			x = futClub.findTeam(tName);
			if(x == 1){
				futClub.showDressRoomsA();
			}else if(x == 2){
				futClub.showDressRoomsB();
			}else{
				System.out.println("El equipo no existe");
			}
		}else if(ans == 2){
			futClub.showOffices();
		}
	}
	/** 
     * this method sows all the info
     * <b>pre:</b> it must have been chosen by the user on menu
     * <b>post:</b> shows all the info
     */
	public static void showAllInfo(){
		String x = "";
		String y = "";
		String z = "";
		if(futClub.team1 != null){
			x = futClub.showTeam(futClub.team1.getName());
		}
		if(futClub.team2 != null){
			y = futClub.showTeam(futClub.team2.getName());
		}
		System.out.println(x);
		System.out.println(y);
		futClub.getAllEmployees();
	}
	/** 
     * this method ask for the name of an Employee to show his info
     * <b>pre:</b> it must have been chosen by the user on menu
     * <b>post:</b> shows Employee's info
     */
	public static void showEmployeeInfo(){
		String name = "";
		int pos = 0;
		System.out.println("Ingrese el nombre del empleado");
		name = sc.nextLine();
		pos = futClub.findEmployee(name);
		if(pos >= 0){
			futClub.showEmployee(pos);
		}else{
			System.out.println("El empleado no existe");
		}		
	}
	/** 
     * this method ask for the name of a Team to show his info
     * <b>pre:</b> it must have been chosen by the user on menu
     * <b>post:</b> shows Team's info
     */
	public static void showTeamInfo(){
		String tName = "";
		String x = "";
		int teamPos = 0;
		System.out.println("Ingrese el nombre del equipo");
		tName = sc.nextLine();
		x = futClub.showTeam(tName);
		System.out.println(x);
	}
	/** 
     * this method ask for the necesary data to fire an Employee
     * <b>pre:</b> it must have been chosen by the user on menu
     * <b>post:</b> the data was acquired, calls another method on Club class
     */
	public static void fireEmployee(){
		String name = "";
		int pos = 0;
		System.out.println("Ingrese el nombre del empleado que desea despedir");
		name = sc.nextLine();
		pos = futClub.findEmployee(name);
		futClub.employeeFired(pos);
	}
	/** 
     * this method ask for the necesary data to add an Employee to a Team
     * <b>pre:</b> it must have been chosen by the user on menu
     * <b>post:</b> the data was acquired 
     */
	public static void addEmployeeToTeam(){
		String name = "";
		String tName = "";
		int pos = 0;
		int type = 0;
		int teamPos = 0;
		System.out.println("Ingrese el nombre del empleado que desea agregar");
		name = sc.nextLine();
		System.out.println("Ingrese el nombre del equipo al que desea agregar el empleado");
		tName = sc.nextLine();
		System.out.println("indique el tipo de empleado:\n(1)Jugador\n(2)Entrenador Principal\n(3)Entrenador Asistente");
		type = sc.nextInt();
		sc.nextLine();
		pos = futClub.findEmployee(name);
		teamPos = futClub.findTeam(tName);
		System.out.println(pos + " / " + teamPos);
		if(pos >= 0 || teamPos >= 0){
			switch(type){
				case 1: futClub.addPlayerToTeam(name,teamPos);
				break;
				case 2: futClub.addMainCoachToTeam(name,teamPos);
				break;
				case 3: futClub.addAssistantCoachToTeam(name,teamPos);
				break;
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
		System.out.println("Ingrese el nombre del equipo");
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
		futClub.addPlayer("martin",1111111,35.99,1,6,24,1);//1
		futClub.addPlayer("jorge",2222222,35.99,2,6,24,1);//2
		futClub.addPlayer("andres",3333333,35.99,3,6,24,1);//3
		futClub.addPlayer("raul",444444,35.99,12,4,24,1);//4
		futClub.addPlayer("carlos",5555555,35.99,5,6,24,1);//5
		futClub.addPlayer("daniel",666666,35.99,6,6,24,1);//6
		futClub.addPlayer("edward",777777,35.99,7,6,24,1);//7
		futClub.addPlayer("franco",8888888,35.99,8,6,24,1);//8
		futClub.addPlayer("gabriel",999999,35.99,9,6,24,1);//9
		futClub.addPlayer("hector",10101010,35.99,10,6,24,1);//10
		futClub.addPlayer("ignacio",11011011,35.99,11,6,24,1);//11
		futClub.addPlayer("kevin",12121212,35.99,12,6,24,1);//12
		futClub.addPlayer("laura",13131313,35.99,13,6,24,1);//13
		futClub.addPlayer("nico",141414141,35.99,14,6,24,1);//14
		futClub.addPlayer("oscar",1515151515,35.99,15,6,24,1);//15
		futClub.addMainCoach("pablo",16161616,22.934,23,5,4);//16
		futClub.addMainCoach("quintero",17171717,22.934,23,5,4);//17
		futClub.addAssistantCoach("sarah",18181818,12.85,10,true,1);//18
		futClub.addAssistantCoach("tomas",19191919,12.85,10,true,1);//19
		futClub.addAssistantCoach("ulices",20202020,12.85,10,true,1);//20
		futClub.addTeam("colombia");
		futClub.addTeam("argentina");
		//t1
		futClub.addPlayerToTeam("martin",1);
		futClub.addPlayerToTeam("jorge",1);
		futClub.addPlayerToTeam("andres",1);
		futClub.addPlayerToTeam("raul",1);
		futClub.addPlayerToTeam("carlos",1);
		futClub.addPlayerToTeam("daniel",1);
		futClub.addPlayerToTeam("edward",1);
		//t2
		futClub.addPlayerToTeam("franco",2);
		futClub.addPlayerToTeam("gabriel",2);
		futClub.addPlayerToTeam("hector",2);
		futClub.addPlayerToTeam("ignacio",2);
		futClub.addPlayerToTeam("kevin",2);
		futClub.addPlayerToTeam("laura",2);
		futClub.addPlayerToTeam("nico",2);
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