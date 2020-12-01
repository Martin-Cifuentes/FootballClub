package model;
public abstract class Employee implements Calculate{
	public String name;
	public int id;
	public double salary;
	public boolean active;
	/** 
     * this constructor method creates a Employee objet
     * @param name String, name of the Employee
     * @param id int, id number of the Employee
     * @param salary String, salary of the Employee
     */
	public Employee(String name, int id, double salary){
		this.name = name;
		this.id = id;
		this.salary = salary;
		this.active = true;
	}
	/** 
     * this method calculates the price of the Employee
     * <b>pre:</b> it must have been called by a method on Club
     * <b>post:</b> shows the data
     * @return the Employee's price
     */
	public abstract double calculatePrice();
	/** 
     * this method calculates the level of the Employee
     * <b>pre:</b> it must have been called by a method on Club
     * <b>post:</b> shows the data
     * @return the Employee's level
     */
	public abstract double calculateLevel();
	public String toString(){
		String empleo = "El empleado esta contratado";
		if(!active){
			empleo = "El empleado fue despedido";
		}
		String x = "__Nombre: " + name + "\n" + "__ID: " + id + "\n" + "__Salario: " + salary + "\n" + empleo;
		return x;
	}
	//Gets
	public String getName(){
		return this.name;
	}
	public int getId(){
		return this.id;
	}
	public double getSalary(){
		return this.salary;
	}
	public boolean getActive(){
		return this.active;
	}
	//Sets
	public void setName(String name){
		this.name = name;
	}
	public void setId(int id){
		this.id = id;
	}
	public void setSalary(double salary){
		this.salary = salary;
	}
	public void setActive(boolean active){
		this.active = active;
	}
}