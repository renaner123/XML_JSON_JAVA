package DOMParser;

class Employee {
	
    private String Firstname;
    private String Lastname;
    private double salary;
    
    public Employee() {

    }
    
    public Employee(String Firstname, String Lastname, double salary) {
        this.Firstname = Firstname;
        this.Lastname = Lastname;
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "[" + Firstname + ", " + Lastname + ", "+ salary + "]";
    }

	public String getFirstname() {
		return Firstname;
	}

	public void setFirstname(String firstname) {
		Firstname = firstname;
	}

	public String getLastname() {
		return Lastname;
	}

	public void setLastname(String lastname) {
		Lastname = lastname;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
    
    
    
    
}
