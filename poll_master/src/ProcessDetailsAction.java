package mystructs.demo;


public class ProcessDetailsAction {

    private String name;
    private double salary;

    public String execute() {
    	salary *= 1.25;
    	return "success";
    }

    public String getName() {
    	return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
    	return salary;
    }
    
    public void setSalary(double salary) {
        this.salary = salary;
    }    
}

