import java.time.Year;

public class Employee {
    private String name;
    private int birthYear;
    private double occupationRate;
    private double monthlyIncome;

    private  Vehicle employeeVehicle;

    private Contract contract;
    private static final double DEFAULT_OCCUPATION_RATE = 100.0;
    private static final double MIN_OCCUPATION_RATE = 10.0;
    private static final double MAX_OCCUPATION_RATE = 100.0;

    public Employee(String name, int birthYear, double monthlyIncome,double occupationRate) {
        this.name = name;
        this.birthYear = birthYear;
        setMonthlyIncome(monthlyIncome);
        setOccupationRate(occupationRate);
//        this.occupationRate = DEFAULT_OCCUPATION_RATE;

    }
    public Employee(String name, int birthYear, double monthlyIncome) {
        this(name, birthYear, monthlyIncome, DEFAULT_OCCUPATION_RATE);
    }


    public Employee(String name, int birthYear, double monthlyIncome, double occupationRate, Vehicle employeeVehicle) {

        this.name = name;
        this.birthYear = birthYear;
        setMonthlyIncome(monthlyIncome);
        setOccupationRate(occupationRate);
        this.employeeVehicle = employeeVehicle;
    }

    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public double getOccupationRate() {
        return occupationRate;
    }

    public void setOccupationRate(double occupationRate) {
        if (occupationRate < MIN_OCCUPATION_RATE) {
            this.occupationRate = MIN_OCCUPATION_RATE;
        } else if (occupationRate > MAX_OCCUPATION_RATE) {
            this.occupationRate = MAX_OCCUPATION_RATE;
        } else {
            this.occupationRate = occupationRate;
        }
    }

    public void signContract(Contract contract) {
        this.contract = contract;
    }


    public int getAge() {
        int currentYear = Year.now().getValue();
        return currentYear - birthYear;
    }

    public Contract getcontract(){return contract;}
    public Vehicle getEmployeeVehicle() {
        return employeeVehicle;
    }

    public double annualIncome() {
        return 12 * monthlyIncome * occupationRate;
    }

    public void displayInfo() {
        System.out.println("Name: " + name + ", a " + getClass().getSimpleName());
        System.out.println("Age: " + getAge());
        System.out.println("Employee has a " + getEmployeeVehicle());


        if (this instanceof Manager) {
            ((Manager) this).displayManagerInfo();
        } else if (this instanceof Tester) {
            ((Tester) this).displayTesterInfo();
        } else if (this instanceof Programmer) {
            ((Programmer) this).displayProgrammerInfo();
        }

    }

    public StringBuilder contractInfo(){


        StringBuilder final_output = new StringBuilder();
        final_output.append("\n");
        final_output.append(this.name);
        final_output.append(getcontract());
        return final_output;
    }

}

class Manager extends Employee {
    private int travelledDays;
    private int newClients;


    private static final int GAIN_FACTOR_CLIENT = 500;
    private static final int GAIN_FACTOR_TRAVEL = 100;


    public Manager(String name, int birthYear, int newClients, int travelledDays) {
        super(name, birthYear, 0); // Monthly income is not specified for Managers
        this.travelledDays = travelledDays;
        this.newClients = newClients;
        displayInitializationMessage();
    }

    public Manager(String name, int birthYear, int newClients, int travelledDays, double occupationRate) {
        super(name, birthYear, 0,occupationRate);
        this.travelledDays = travelledDays;
        this.newClients = newClients;
        displayInitializationMessage();
    }

    public Manager(String name, int birthYear, int newClients, int travelledDays,Vehicle employeeVehicle) {
        super(name, birthYear, 0,100,employeeVehicle); // Monthly income is not specified for Managers
        this.travelledDays = travelledDays;
        this.newClients = newClients;
        displayInitializationMessage();
    }

    public Manager(String name, int birthYear, int newClients, int travelledDays, double occupationRate,Vehicle employeeVehicle) {
        super(name, birthYear, 0,occupationRate,employeeVehicle);
        this.travelledDays = travelledDays;
        this.newClients = newClients;
        displayInitializationMessage();
    }


    // Getter and Setter methods for Manager-specific properties
    public int getTravelledDays() {
        return travelledDays;
    }

    public void setTravelledDays(int travelledDays) {
        this.travelledDays = travelledDays;
    }

    public int getNewClients() {
        return newClients;
    }

    public void setNewClients(int newClients) {
        this.newClients = newClients;
    }

    // Override the annualIncome method to include Manager-specific bonuses
    @Override
    public double annualIncome() {
        double baseIncome = super.annualIncome();
        double clientBonus = newClients * GAIN_FACTOR_CLIENT;
        double travelBonus = travelledDays * GAIN_FACTOR_TRAVEL;
        return baseIncome + clientBonus + travelBonus;
    }

    // Override the displayInitializationMessage method for Manager-specific message

    protected void displayInitializationMessage() {
        System.out.println("We have a new employee: " + getName() + ", a Manager.");
    }

    public void displayManagerInfo() {
        System.out.println(getName() + " has an Occupation rate: " + getOccupationRate() + "%"
                + " He/She travelled " + travelledDays + " days and has brought " + newClients + " new clients.");
        System.out.println("His/Her estimated annual income is " + annualIncome() + ".");
        System.out.println("-------------------------------------------------------");
    }
}

// Define the Tester class as a subclass of Employee
class Tester extends Employee {
    private int bugsSolved;

    // Constants for bonus factors
    private static final int GAIN_FACTOR_BUGS = 10;

    // Constructor
    public Tester(String name, int birthYear, int bugsSolved) {
        super(name, birthYear, 0); // Monthly income is not specified for Testers
        this.bugsSolved = bugsSolved;
        displayInitializationMessage();
    }

    public Tester(String name, int birthYear, int bugsSolved, double occupationRate) {
        super(name, birthYear, 0,occupationRate);
        this.bugsSolved = bugsSolved;
        displayInitializationMessage();
    }
    public Tester(String name, int birthYear, int bugsSolved,Vehicle employeeVehicle) {
        super(name, birthYear, 0,100,employeeVehicle); // Monthly income is not specified for Testers
        this.bugsSolved = bugsSolved;
        displayInitializationMessage();
    }

    public Tester(String name, int birthYear, int bugsSolved, double occupationRate,Vehicle employeeVehicle) {
        super(name, birthYear, 0,occupationRate,employeeVehicle);
        this.bugsSolved = bugsSolved;
        displayInitializationMessage();
    }

    // Getter and Setter methods for Tester-specific properties
    public int getBugsSolved() {
        return bugsSolved;
    }

    public void setBugsSolved(int bugsSolved) {
        this.bugsSolved = bugsSolved;
    }

    // Override the annualIncome method to include Tester-specific bonus
    @Override
    public double annualIncome() {
        double baseIncome = super.annualIncome();
        double bugBonus = bugsSolved * GAIN_FACTOR_BUGS;
        return baseIncome + bugBonus;
    }

    // Override the displayInitializationMessage method for Tester-specific message

    protected void displayInitializationMessage() {
        System.out.println("We have a new employee: " + getName() + ", a Tester.");
    }
    public void displayTesterInfo() {
        System.out.println(getName() + " has an Occupation rate: " + getOccupationRate() + "%"
                + " Bugs Solved: " + bugsSolved);
        System.out.println("His/Her estimated annual income is " + annualIncome() + ".");
        System.out.println("-------------------------------------------------------");

    }

}

// Define the Programmer class as a subclass of Employee
class Programmer extends Employee {
    private int projectsCompleted;

    // Constants for bonus factors
    private static final int GAIN_FACTOR_PROJECTS = 200;

    // Constructor
    public Programmer(String name, int birthYear, int projectsCompleted) {
        super(name, birthYear, 0); // Monthly income is not specified for Programmers
        this.projectsCompleted = projectsCompleted;
        displayInitializationMessage();
    }

    public Programmer(String name, int birthYear, int projectsCompleted, double occupationalRate) {
        super(name, birthYear, 0,occupationalRate);
        this.projectsCompleted = projectsCompleted;
        displayInitializationMessage();
    }
    public Programmer(String name, int birthYear, int projectsCompleted,Vehicle employeeVehicle) {
        super(name, birthYear, 0,100,employeeVehicle); // Monthly income is not specified for Programmers
        this.projectsCompleted = projectsCompleted;
        displayInitializationMessage();
    }

    public Programmer(String name, int birthYear, int projectsCompleted, double occupationalRate,Vehicle employeeVehicle) {
        super(name, birthYear, 0,occupationalRate,employeeVehicle);
        this.projectsCompleted = projectsCompleted;
        displayInitializationMessage();
    }

    // Getter and Setter methods for Programmer-specific properties
    public int getProjectsCompleted() {
        return projectsCompleted;
    }

    public void setProjectsCompleted(int projectsCompleted) {
        this.projectsCompleted = projectsCompleted;
    }

    // Override the annualIncome method to include Programmer-specific bonus
    @Override
    public double annualIncome() {
        double baseIncome = super.annualIncome();
        double projectBonus = projectsCompleted * GAIN_FACTOR_PROJECTS;
        return baseIncome + projectBonus;
    }

    // Override the displayInitializationMessage method for Programmer-specific message

    protected void displayInitializationMessage() {
        System.out.println("We have a new employee: " + getName() + ", a Programmer.");
    }
    public void displayProgrammerInfo() {
        System.out.println(getName() + " has an Occupation rate: " + getOccupationRate() + "%"
                + " Projects Completed: " + projectsCompleted);
        System.out.println("His/Her estimated annual income is " + annualIncome() + ".");
        System.out.println("-------------------------------------------------------");
    }


    
}




