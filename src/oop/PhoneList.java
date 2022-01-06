package oop;

import java.util.Scanner;
import java.util.Arrays;

public class PhoneList {
    Scanner sc = new Scanner(System.in);
    private Phone[] phone;
    private int n;
    public Phone[] getPhone() {
        return phone;
    }
    public PhoneList() {
        n = 0;
        phone = new Phone[n];
    }
    public PhoneList(int n, Phone[] phone) {
        this.n = n;
        this.phone = new Phone[n];
        this.phone = phone;
    }    
    public void insert(Phone copy) {
        phone = Arrays.copyOf(phone,n + 1);
        phone[n] = copy;
        n++;
    }
    public void insert() {
        int add_check;
        phone = Arrays.copyOf(phone,n + 1);
        do {
            try{
                System.out.println("-------------------------------------");
                System.out.println("Select phone type: ");
                System.out.println("1. SmartPhone.");
                System.out.println("2. BangerPhone.");
                System.out.print("Option ");
                add_check = Integer.valueOf(sc.nextLine());
            } catch (NumberFormatException e) {
                add_check = 0;
            }
        } while (add_check != 1 && add_check!= 2);
        if (add_check == 1) {
            phone[n] = new SmartPhone();
        }
        else {
            phone[n] = new BangerPhone();
        }
        phone[n].getInformation();
        n++;
    }
    public void update() {
        int phoneId;
        do {
            try {
                System.out.print("Enter the phone ID to fix: ");
                phoneId = Integer.valueOf(sc.nextLine());
            } catch (NumberFormatException e) {
                phoneId = -1;
            }
        } while (phoneId < 0);
        update(phoneId);
    }
    public void update(int phoneId) {
        for (Phone p: phone) {
            if (p.getId() == phoneId) {
                if (p instanceof SmartPhone s) {
                    System.out.println("-------Enter information SmartPhone------ ");
                    s.getInformation();
                }
                if (p instanceof BangerPhone b) {
                    System.out.println("---------Enter information BangerPhone--------. ");
                    b.getInformation();
                }
                return;
            }
        }
    }
    public void delete() {
        int phoneId;
        do {
            try {
                System.out.print("Enter the ID to delete: ");
                phoneId = Integer.valueOf(sc.nextLine());
            } catch (NumberFormatException e) {
                phoneId = -1;
            }
        } while (phoneId < 0);
        delete(phoneId);
    }
    public void delete(int phoneId) {
        for (int i = 0; i < n; i++) {
            if (phone[i].getId() == phoneId) {
                for (int j = i; j < n - 1; j++) {
                    phone[j] = phone[j + 1];
                }
                phone = Arrays.copyOf(phone, n - 1);
                n--;
                return;
            }
        }
    }
    public void select() {
        int phoneId;
        do {
            try {
                System.out.print("Enter the ID you want to search for: ");
                phoneId = Integer.valueOf(sc.nextLine());
            } catch (NumberFormatException e) {
                phoneId = -1;
            }
        } while (phoneId < 0);
        select(phoneId);
    }
    public void select(int phoneId) {
        boolean flag = false;
        for (Phone p : phone) {
            System.out.println("---The name to search is---");
            if (p.getId()== phoneId) {
                p.showInformation();
                flag = true;
            }
        }
        if (flag == false) {
            System.out.println("Not found");
        }
    }
    public int selectId(int id) {
        for (int i = 0; i < n; i++) {
            if (phone[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }
    public void display() {
        for (Phone i : phone) {
            i.showInformation();
        }
    }
    @Override
    public String toString() {
        String tmp = "";
        for (Phone i : phone) {
            tmp = tmp + i.toStringForWriteFile() + "\n";
        }
        return tmp;
    }
}