public class Temporary extends Contract {
    private double hourlySalary;
    private int accumulatedHours;

    public Temporary(double hourlySalary, int accumulatedHours) {
        super(hourlySalary,accumulatedHours);
    }

    public double getHourlySalary() {
        return hourlySalary;
    }

    public int getAccumulatedHours(){
        return accumulatedHours;
    }

    public double calculateSalary() {
        return hourlySalary * accumulatedHours;
    }
}
