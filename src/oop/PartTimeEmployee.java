package oop;

public class PartTimeEmployee extends Employee {
    private int workingHours;
    public PartTimeEmployee() {
        super();
        this.workingHours = 0;
    }
    public PartTimeEmployee(String fullName, int age, String gender, String address, double amountPerHour, int workingHours) {
        super(fullName, age, gender, address, amountPerHour);
        this.workingHours = workingHours;
    }
    public PartTimeEmployee(String id, String fullName, int age, String gender, String address, double amountPerHour, int workingHours) {
        super(id, fullName, age, gender, address, amountPerHour);
        this.workingHours = workingHours;
    }
    @Override
    public double calculateSalary() {
        return Math.round((super.amountPerHour * this.workingHours)*100.0)/100.0;
    }
    @Override
    public void getInformation() {
        super.getInformation();
        do {
            try {
                System.out.print("Working hours: ");
                this.workingHours = Integer.valueOf(sc.nextLine());
            }
            catch (NumberFormatException e) {
                this.workingHours = -1;
            }
        }
        while (this.workingHours < 0);
    }
    @Override
    public void showInformation() {
        super.showInformation();
        System.out.println("Salary          : " + calculateSalary());
        System.out.println("--------------------------------");
    }
    @Override
    public String toStringForWriteFile() {
        return super.toStringForWriteFile() + ";" + this.workingHours + ";" + "PT";
    }
}
