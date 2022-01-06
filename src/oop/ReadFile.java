package oop;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static oop.Employee.EmployeeId;
import static oop.Customer.CustomerId;

public class ReadFile {
    private EmployeeList els;
    private CustomerList cls;
    private PhoneList pls;
    private InvoiceList ils;
    public ReadFile(EmployeeList els, CustomerList cls, PhoneList pls, InvoiceList ils) {
        this.els = new EmployeeList();
        this.els = els;
        this.cls = new CustomerList();
        this.cls = cls;
        this.pls = new PhoneList();
        this.pls = pls;
        this.ils = new InvoiceList();
        this.ils = ils;
    }
   
    public void readEmployeeList() {
        try {
            BufferedReader input;
            input = new BufferedReader(new FileReader ("data1.txt"));
            String line = input.readLine();
            int temp = 0;
            while(line != null) {
                Person newEmployee = null;
                String arr[] = line.split(";");
                String id = arr[0];
                if (temp < Integer.valueOf(arr[0].substring(1)))
                    temp = Integer.valueOf(arr[0].substring(1));
                String fullName = arr[1];
                int age = Integer.valueOf(arr[2]);
                String gender = arr[3];
                String address = arr[4];
                double amountPerHour = Double.valueOf(arr[5]);
                if (arr[7].equals("FT")) {
                    int bonusHour = Integer.valueOf(arr[6]);
                    newEmployee = new FullTimeEmployee(id, fullName, age, gender, address, amountPerHour, bonusHour);
                }
                else if (arr[7].equals("PT")) {
                    int workingHours = Integer.valueOf(arr[6]);
                    newEmployee = new PartTimeEmployee(id, fullName, age, gender, address, amountPerHour, workingHours);
                }
                els.insert(newEmployee);
                line = input.readLine();
            }
            EmployeeId = temp;
            System.out.println("The data of file 1 has been imported.");
            input.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File 1 not created.");
        } catch (IOException ex) {}
    }
     public void readCustomerList() {
        try {
            BufferedReader input;
            input = new BufferedReader(new FileReader ("data2.txt"));
            String line = input.readLine();
            int temp = 0;
            while(line != null) {
                Person newCustomer = null;
                String arr[] = line.split(";");
                String id = arr[0];
                if (temp < Integer.valueOf(arr[0].substring(1)))
                    temp = Integer.valueOf(arr[0].substring(1));
                String fullName = arr[1];
                int age = Integer.valueOf(arr[2]);
                String gender = arr[3]; 
                String address = arr[4];
                String phoneNumber =arr[5];
                String email = arr[6];
                newCustomer = new Customer(id, fullName, age, gender, address, phoneNumber, email);
                cls.insert(newCustomer);
                line = input.readLine();
            }
            CustomerId = temp;
            System.out.println("The data of file 2 has been imported.");
            input.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File 2 not created.");
        } catch (IOException ex) {}
    }
   public void readPhoneList() {
        try {
            BufferedReader input;
            input = new BufferedReader(new FileReader ("data3.txt"));
            String line = input.readLine();
            while(line != null) {
                Phone newPhone = null;
                String arr[] = line.split(";");
                String phoneProvider = arr[0];
                String phoneName = arr[1];
                String phoneBrandName = arr[2];
                int price = Integer.valueOf(arr[3]);
                int publishingYear = Integer.valueOf(arr[4]);
                if (arr[5].equals("SP")) {
                    newPhone = new SmartPhone(phoneProvider, phoneName, phoneBrandName, price, publishingYear);
                } else {
                    newPhone = new BangerPhone(phoneProvider, phoneName, phoneBrandName, price, publishingYear);
                }
                pls.insert(newPhone);
                line = input.readLine();
            }
            System.out.println("The data of file 3 has been imported.");
            input.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File 3 not created.");
        } catch (IOException ex) {}
    }
    public void readInvoiceList() {
        try {
            BufferedReader input;
            input = new BufferedReader(new FileReader ("data4.txt"));
            String line = input.readLine();
            while(line != null) {
                String arr[] = line.split(";");
                Person employee = els.getEl().elementAt(els.selectId(arr[0]));
                Person customer = cls.getCl().elementAt(cls.selectId(arr[1]));
                Phone phone = pls.getPhone()[pls.selectId(Integer.valueOf(arr[2]))];
                int quantity = Integer.valueOf(arr[3]);
                Invoice newInvoice = new Invoice(employee, customer, phone, quantity);
                ils.insert(newInvoice);
                line = input.readLine();
            }
            System.out.println("The data of file 4 has been imported.");
            input.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File 4 not created.");
        } catch (IOException ex) {}
    }
}
