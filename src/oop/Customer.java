package oop;

public class Customer extends Person {
    public static int CustomerId;
    private String phoneNumber;
    private String email;
    public Customer() {
        super();
        CustomerId++;
        super.id = "C" + String.valueOf(CustomerId);
        this.phoneNumber = "no phone";
        this.email = "no email";
    }
    public Customer(String fullName, int age, String gender, String address, String phoneNumber, String email) {
        super(fullName, age, gender, address);
        CustomerId++;
        super.id = "C" + String.valueOf(CustomerId);
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
     public Customer(String id, String fullName, int age, String gender, String address, String phoneNumber, String email) {
        super(fullName, age, gender, address);
        super.id = id;
        this.phoneNumber = phoneNumber;
        this.email=email;
    }
    @Override
    public void getInformation() {
        super.getInformation();
        System.out.print("Phone number: ");
        this.phoneNumber = sc.nextLine();
        System.out.print("Email: ");
        this.email = sc.nextLine();
    }
    @Override
    public void showInformation() {
        super.showInformation();
        System.out.println("Phone number    : " + this.phoneNumber);
        System.out.println("Email           : " + this.email);
        System.out.println("--------------------------------");
    }
    @Override
     public String toStringForWriteFile() {
        return super.toStringForWriteFile() + ";" + this.phoneNumber + ";" + this.email;
    }
}