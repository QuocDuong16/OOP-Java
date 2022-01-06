package oop;
import java.util.Scanner;

public abstract class Person implements IGet, IShow {
    protected Scanner sc = new Scanner(System.in);
    protected String id;
    private String fullName;
    private int age;
    private String gender;
    private String address;
    public Person() {
        this.fullName = "no name";
        this.age = 0;
        this.gender = "none";
        this.address = "none";
    }
    public Person(String fullName, int age, String gender, String address) {
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }
    public String getId() {
        return this.id;
    }
    public String getFullName() {
        return this.fullName;
    }
    public String getAddress() {
        return this.address;
    }
    @Override
    public void getInformation() {
        String tmpGender;
        System.out.print("Full name: ");
        this.fullName = sc.nextLine();
        do {
            try {
                System.out.print("Age: ");
                this.age = Integer.valueOf(sc.nextLine());
            } catch (NumberFormatException e) {
               this.age = -1;
            }
        } while (this.age <= 0);
        do {
            System.out.print("Gender (male or female or intersex): ");
            tmpGender = sc.nextLine();
            this.gender = tmpGender;
            tmpGender = tmpGender.toLowerCase();
        }
        while (tmpGender.equals("male") == false && tmpGender.equals("female") == false && tmpGender.equals("intersex") == false);
        System.out.print("Address: ");
        this.address = sc.nextLine();
    }
    @Override
    public void showInformation() {
        System.out.println("--------------Info--------------");
        System.out.println("Id              : " + this.id);
        System.out.println("Full name       : " + this.fullName);
        System.out.println("Age             : " + this.age);
        System.out.println("Gender          : " + this.gender);
        System.out.println("Address         : " + this.address);
    }
    public String toStringForWriteFile() {
        return this.id + ";" + this.fullName + ";" + this.age + ";" + this.gender + ";" + this.address;
    }
}
