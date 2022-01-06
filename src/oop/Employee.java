package oop;

public abstract class Employee extends Person implements IEmployee {
    public static int EmployeeId;
    protected double amountPerHour;
    public Employee() {
        super();
        EmployeeId++;
        super.id = "E" + String.valueOf(EmployeeId);
        this.amountPerHour = 10000.0;
    }
    public Employee(String fullName, int age, String gender, String address, double amountPerHour) {
        super(fullName, age, gender, address);
        EmployeeId++;
        super.id = "E" + String.valueOf(EmployeeId);
        this.amountPerHour = amountPerHour;
    }
    public Employee(String id, String fullName, int age, String gender, String address, double amountPerHour) {
        super(fullName, age, gender, address);
        super.id = id;
        this.amountPerHour = amountPerHour;
    }
    @Override
    public abstract double calculateSalary();
    @Override
    public void getInformation() {
        super.getInformation();
        do {
            try {
                System.out.print("Amount per hour: ");
                this.amountPerHour = Double.valueOf(sc.nextLine());
            }
            catch (NumberFormatException e) {
                this.amountPerHour = -1;
            }
        }
        while (this.amountPerHour < 0);
    }
    @Override
    public void showInformation() {
        super.showInformation();
        System.out.println("Amount Per Hour : " + this.amountPerHour);
    }
    @Override
    public String toStringForWriteFile() {
        return super.toStringForWriteFile() + ";" + this.amountPerHour;
    }
}
