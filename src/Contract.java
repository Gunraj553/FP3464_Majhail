public class Contract {
    private int numberOfChildren;
    private boolean isMarried;
    private double fixedMonthlySalary;
    private double monthlyChildAllowance;
    private int accumulatedDays;

    private double hourlySalary;
    private int accumulatedHours;

    public Contract(double hourlySalary ,  int accumulatedHours){
        this.hourlySalary = hourlySalary;
        this.accumulatedHours = accumulatedHours;

    }

    public Contract(int numberOfChildren, boolean isMarried, double fixedMonthlySalary , double monthlyChildAllowance, int accumulatedDays){
        this.numberOfChildren = numberOfChildren;
        this.isMarried = isMarried;
        this.fixedMonthlySalary = fixedMonthlySalary;
        this.monthlyChildAllowance = monthlyChildAllowance;
        this.accumulatedDays =accumulatedDays;
    }
    public int getNumberOfChildren() {
        return numberOfChildren;
    }

    public boolean isMarried() {
        return isMarried;
    }

    public double getHourlySalary() {
        return hourlySalary;
    }

    public int getAccumulatedHours() {
        return accumulatedHours;
    }

    public double getFixedMonthlySalary() {
        return fixedMonthlySalary;
    }

    public double getMonthlyChildAllowance() {
        return monthlyChildAllowance;
    }

    public int getAccumulatedDays() {
        return accumulatedDays;
    }



    public String contractInfo() {


        StringBuilder outputBuilder = new StringBuilder();

        if (getClass() == Temporary.class ){

            outputBuilder.append(" He/She is a temporary employee with ").append(hourlySalary);
            outputBuilder.append(" hourly salary and he has worked for ").append(accumulatedHours).append(" hours.");


        }else{
            if (isMarried) {
                outputBuilder.append(" He/She is married and ");
            } else {
                outputBuilder.append(" He/She is not married and ");
            }

            if (numberOfChildren > 0) {
                outputBuilder.append("he/she has ").append(numberOfChildren).append(" children.");
            } else {
                outputBuilder.append("he/she does not have any children.");
            }

            outputBuilder.append("He/She has worked for ").append(accumulatedDays);
            outputBuilder.append(" days and upon contract his/her monthly salary is ").append(fixedMonthlySalary);

        }

        String output = outputBuilder.toString();
        return output;
    }

    @Override
    public String toString() {
        return contractInfo();
    }
}
