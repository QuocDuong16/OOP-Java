package oop;

import java.util.Scanner;
public abstract class Phone implements IShow,IGet  {
    Scanner sc = new Scanner(System.in);
    private static int phoneId = 0;
    private int id;
    private String phoneProvider; //Tên nhà cung cấp
    private String phoneName; // Tên điện thoại
    private String phoneBrandName; // Tên hãng
    private int price; // Giá tiền
    private int publishingYear; // Năm sản xuất
    public Phone() {
        phoneId++;
        this.id = phoneId;
    }
    public Phone(String phoneProvider, String phoneName, String phoneBrandName, int price, int publishingYear) {
        phoneId++;
        this.id = phoneId;
        this.phoneProvider = phoneProvider;
        this.phoneName = phoneName;
        this.phoneBrandName = phoneBrandName;
        this.price = price;
        this.publishingYear = publishingYear;
    }
    public int getId() {
        return id;
    }
    public String getPhoneName() {
        return phoneName;
    }
    public int getPrice() {
        return price;
    }
    @Override
    public void getInformation() {
        System.out.print("Telephone Provider: ");
        phoneProvider = sc.nextLine();
        System.out.print("Phone Name: ");
        phoneName = sc.nextLine();
        System.out.print("Phone Brand Name: ");
        phoneBrandName = sc.nextLine();
        do {
            try {
                System.out.print("Price: ");
                price = Integer.valueOf(sc.nextLine());
            } catch (NumberFormatException e) {
                price = -1;
            }
        } while (price < 0);
        do {
            try {
                System.out.print("Publishing Year: ");
                publishingYear = Integer.valueOf(sc.nextLine());
            } catch (NumberFormatException e) {
                publishingYear = -1;
            }
        } while (publishingYear < 0);
    }
    @Override
    public void showInformation() {
        System.out.println("--------------Info--------------");
        System.out.println("Phone Id: " + id);
        System.out.println("Telephone Provider: " + phoneProvider);
        System.out.println("Phone Name: " + phoneName);
        System.out.println("Phone Brand Name: " + phoneBrandName);
        System.out.println("Price: "+ price);
        System.out.println("Publishing Year: " + publishingYear);
        PhoneFeatures();
        System.out.println("--------------------------------");
    }
    public abstract void PhoneFeatures();
    public String toStringForWriteFile() {
        return this.phoneProvider + ";" + this.phoneName + ";" + this.phoneBrandName + ";" + this.price + ";" + this.publishingYear;
    }
}
