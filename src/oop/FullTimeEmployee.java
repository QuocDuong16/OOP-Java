package oop;

public class FullTimeEmployee extends Employee {
    private int bonusHour;
    public FullTimeEmployee() {
        super();
        this.bonusHour = 0;
    }
    public FullTimeEmployee(String fullName, int age, String gender, String address, double amountPerHour, int bonusHour) {
        super(fullName, age, gender, address, amountPerHour);
        this.bonusHour = bonusHour;
    }
    public FullTimeEmployee(String id, String fullName, int age, String gender, String address, double amountPerHour, int bonusHour) {
        super(id, fullName, age, gender, address, amountPerHour);
        this.bonusHour = bonusHour;
    }
    @Override
    public double calculateSalary() {
        return Math.round((super.amountPerHour * (56 + this.bonusHour))*100.0)/100.0;
    }
    @Override
    public void getInformation() {
        super.getInformation();
        do {
            try {
                System.out.print("Bonus Hour: ");
                this.bonusHour = Integer.valueOf(sc.nextLine());
            }
            catch (NumberFormatException e) {
                this.bonusHour = -1;
            }
        }
        while (this.bonusHour < 0);
    }
    @Override
    public void showInformation() {
        super.showInformation();
        System.out.println("Salary          : " + calculateSalary());
        System.out.println("--------------------------------");
    }
    @Override
    public String toStringForWriteFile() {
        return super.toStringForWriteFile() + ";" + this.bonusHour + ";" + "FT";
    }
}
