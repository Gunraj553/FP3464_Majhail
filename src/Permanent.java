public class Permanent extends Contract {
    private int nbChildren;
    private boolean married;
    private double monthlySalary;
    private double bonusPerChildPerMonth;
    private int accumulatedDays;

    public Permanent(int nbChildren, boolean married, double monthlySalary, double bonusPerChildPerMonth, int accumulatedDays) {
        super(nbChildren,married,monthlySalary,bonusPerChildPerMonth,accumulatedDays);

    }

    public double calculateSalary() {
        double baseSalary = monthlySalary + (married ? nbChildren * bonusPerChildPerMonth : 0);
        return baseSalary * (accumulatedDays / 20.0);
    }
}
