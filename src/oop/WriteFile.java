package oop;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
    private EmployeeList els;
    private CustomerList cls;
    private PhoneList pls;
    private InvoiceList ils;
    public WriteFile(EmployeeList els, CustomerList cls, PhoneList pls, InvoiceList ils) {
        this.els = new EmployeeList();
        this.els = els;
        this.cls = new CustomerList();
        this.cls = cls;
        this.pls = new PhoneList();
        this.pls = pls;
        this.ils = new InvoiceList();
        this.ils = ils;
    }
    public void writeEmployeeList() {
        try {
            FileWriter fw = new FileWriter("data1.txt");
            fw.write(els.toString());
            System.out.println("Data has been exported to file 1.");
            fw.close();
        } catch (IOException e) {}
    }
    public void writeCustomerList() {
        try {
            FileWriter fw = new FileWriter("data2.txt");
            fw.write(cls.toString());
            System.out.println("Data has been exported to file 2.");
            fw.close();
        } catch (IOException e) {}
    }
    public void writePhoneList() {
        try {
            FileWriter fw = new FileWriter("data3.txt");
            fw.write(pls.toString());
            System.out.println("Data has been exported to file 3.");
            fw.close();
        } catch (IOException e) {}
    }
    public void writeInvoiceList() {
        try {
            FileWriter fw = new FileWriter("data4.txt");
            fw.write(ils.toString());
            System.out.println("Data has been exported to file 4.");
            fw.close();
        } catch (IOException e) {}
    }
}
