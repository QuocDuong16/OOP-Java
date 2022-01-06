package oop;
import java.util.Scanner;
import static oop.Manage.els;
import static oop.Manage.cls;
import static oop.Manage.pls;

public class Invoice implements IShow, IGet  {
    Scanner sc = new Scanner(System.in);
    private static int invoiceId = 0;
    private int id; // Mã hóa đơn
    private Person employee; // Nhân viên
    private Person customer; // Khách hàng
    private Phone phone; //Điện thoại
    private int quantity; //Số lượng
    public Invoice() {
        invoiceId++;
        this.id = invoiceId;
    }
    public Invoice(Person employee, Person customer, Phone phone, int quantity) {
        invoiceId++;
        this.id = invoiceId;
        this.employee = employee;
        this.customer = customer;
        this.phone = phone;
        this.quantity = quantity;
    }
    public int getId() {
        return id;
    }
    @Override
    public void getInformation() {
        String EmployeeId, CustomerId;
        int PhoneId;
        do {
            System.out.print("Enter employee id: ");
            EmployeeId = sc.nextLine();
            int temp = els.selectId(EmployeeId);
            if (temp != -1) {
                this.employee = els.getEl().elementAt(temp);
            } else {
                System.out.println("The employee does not exist.");
            }
        } while (els.selectId(EmployeeId) == -1); 
        do {
            System.out.print("Enter customer id: ");
            CustomerId = sc.nextLine();
            int temp = cls.selectId(CustomerId);
            if (temp != -1) {
                this.customer = cls.getCl().elementAt(temp);
            } else {
                System.out.println("The customer does not exist.");
            }
        } while (cls.selectId(CustomerId) == -1);
        int temp;
        do {
            try {
                System.out.print("Enter phone id: ");
                PhoneId = Integer.valueOf(sc.nextLine());
                temp = pls.selectId(PhoneId);
                if (temp != -1) {
                    this.phone = pls.getPhone()[temp];
                } else {
                    System.out.println("The phone does not exist.");
                }
            } catch (NumberFormatException e) {
                temp = -1;
            }
        } while (temp == -1);
        do {
            try {
                System.out.print("Quantity: ");
                quantity = Integer.valueOf(sc.nextLine());
            } catch (NumberFormatException e) {
                quantity = -1;
            }
        } while (quantity < 0);
    }
    @Override
    public void showInformation() {
        System.out.println("--------------Info--------------");
        System.out.println("Invoice Id: " + id);
        System.out.println("Name Employee: " + employee.getFullName());
        System.out.println("Name Customer: " + customer.getFullName());
        System.out.println("Address Customer: " + customer.getAddress());
        System.out.println("Name Phone: " + phone.getPhoneName());
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Price: " + totalPrice());
        System.out.println("--------------------------------");
    }
    private int totalPrice() {
        return quantity * phone.getPrice();
    }
    public String toStringForWriteFile() {
        return this.employee.getId() + ";" + this.customer.getId() + ";" + this.phone.getId() + ";" + this.quantity;
    }
}
