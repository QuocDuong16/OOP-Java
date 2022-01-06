package oop;
import java.util.Scanner;
import java.util.Vector;

public class CustomerList {
    // Khai báo biến
    Scanner sc = new Scanner(System.in);
    private Vector<Person> cl;
    // getter
    public Vector<Person> getCl() {
        return cl;
    }
    // constructor
    public CustomerList() {
        this.cl = new Vector<>();
    }
    public CustomerList(Vector<Person> cl) {
        this.cl = new Vector<>();
        this.cl.addAll(cl);
    }
    // Thêm mới 1 person customer
    public void insert(Person cl) {
        this.cl.add(cl);
    }
    // Thêm mới tự nhập
    public void insert() {
        Person newCustomer;
        newCustomer = new Customer();
        newCustomer.getInformation();
        cl.add(newCustomer);
    }
    // Tìm theo Id nhập
    public void select() {
        String id;
        System.out.print("Enter id to search: ");
        id = sc.nextLine();
        select(id);
    }
    public void select(String id) {
        boolean flag = false;
        for (Person i : cl) {
            if (i.getId().equals(id)) {
                i.showInformation();
                flag = true;
            }
        }
        if (flag == false) {
            System.out.println("Not found");
        }
    }
    // Tìm id trả về index
    public int selectId(String id) {
        for (Person i : cl) {
            if (i.getId().equals(id)) {
                return cl.indexOf(i);
            }
        }
        return -1;
    }
    // Xóa theo id nhập
    public void delete() {
        String id;
        System.out.print("Enter id to delete: ");
        id = sc.nextLine();
        delete(id);
    }
    public void delete(String id) {
        for (Person i : cl) {
            if (i.getId().equals(id)) {
                cl.remove(i);
                System.out.println("Deletion complete");
                return;
            }
        }
    }
    // Sửa theo id nhập
    public void update() {
        String id;
        System.out.print("Enter id to update: ");
        id = sc.nextLine();
        update(id);
    }
    public void update(String id) {
        for (Person i : cl) {
            if (i.getId().equals(id)) {
                i.getInformation();
                return;
            }
        }
    }
    // Xuất ra danh sách khách hàng
    public void display() {
        cl.forEach((action) -> action.showInformation());
    }
    // Chuyển toàn bộ danh sách thành chuỗi
    @Override
    public String toString() {
        String tmp = "";
        for (Person i : cl) {
            tmp = tmp + i.toStringForWriteFile() + "\n";
        }
        return tmp;
    }
}
