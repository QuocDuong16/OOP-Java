package oop;
import java.util.Scanner;

public class Manage {
    Scanner sc = new Scanner(System.in);
    public static EmployeeList els;
    public static CustomerList cls;
    public static PhoneList pls;
    private InvoiceList ils;
    public Manage() {
        els = new EmployeeList();
        cls = new CustomerList();
        pls = new PhoneList();
        ils = new InvoiceList();
    }
    public void menu() {
        while(true) {
            int choice = 0;
            ReadFile r = new ReadFile(els, cls, pls, ils);
            WriteFile w = new WriteFile(els, cls, pls, ils);
            do {
                try {
                    System.out.println("---------------MENU---------------");
                    System.out.println("1. Employee List.");
                    System.out.println("2. Customer List.");
                    System.out.println("3. Phone List.");
                    System.out.println("4. Invoice List.");
                    System.out.println("5. Import data from file.");
                    System.out.println("6. Export data to file.");
                    System.out.println("7. Exit.");
                    System.out.print("Your choice: ");
                    choice = Integer.valueOf(sc.nextLine());
                }
                catch (NumberFormatException e) {
                    choice = 0;
                }
            }
            while(choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5 && choice != 6 && choice != 7);
            switch (choice) {
                case 1 -> menuEmployeeList();
                case 2 -> menuCustomerList();
                case 3 -> menuPhoneList();
                case 4 -> menuInvoiceList();
                case 5 -> {
                    r.readEmployeeList();
                    r.readCustomerList();
                    r.readPhoneList();
                    r.readInvoiceList();
                }
                case 6 -> {
                    w.writeEmployeeList();
                    w.writeCustomerList();
                    w.writePhoneList();
                    w.writeInvoiceList();
                }
                case 7 -> {
                    return;
                }
            }
        }
    }
    public int Choice() {
        int choice;
        do {
            try {
                System.out.println("----------------------------------");
                System.out.println("1. Select.");
                System.out.println("2. Insert.");
                System.out.println("3. Update.");
                System.out.println("4. Delete.");
                System.out.println("5. Display.");
                System.out.println("6. Back.");
                System.out.print("Your choice: ");
                choice = Integer.valueOf(sc.nextLine());
            }
            catch (NumberFormatException e) {
                choice = 0;
            }
        }
        while(choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5 && choice != 6);
        return choice;
    }
    public void menuEmployeeList() {
        do {
            switch(Choice()) {
                case 1 -> els.select();
                case 2 -> els.insert();
                case 3 -> els.update();
                case 4 -> els.delete();
                case 5 -> els.display();
                case 6 -> {
                    return;
                }
            }
        }
        while(true);
    }
     public void menuCustomerList() {
        do {
            switch(Choice()) {
                case 1 -> cls.select();
                case 2 -> cls.insert();
                case 3 -> cls.update();
                case 4 -> cls.delete();
                case 5 -> cls.display();
                case 6 -> {
                    return;
                }
            }
        }
        while(true);
    }
    public void menuPhoneList() {
        do {
            switch(Choice()) {
                case 1 -> pls.select();
                case 2 -> pls.insert();
                case 3 -> pls.update();
                case 4 -> pls.delete();
                case 5 -> pls.display();
                case 6 -> {
                    return;
               }
            }
        }
        while(true);
    }
    public void menuInvoiceList() {
       do {
            switch(Choice()) {
                case 1 -> ils.select();
                case 2 -> ils.insert();
                case 3 -> ils.update();
                case 4 -> ils.delete();
                case 5 -> ils.display();
                case 6 -> {
                    return;
                }
            }
        }
        while(true);
    }
}