package oop;
import java.util.Scanner;
import java.util.Vector;

public class EmployeeList {
    Scanner sc = new Scanner(System.in);
    private Vector<Person> el;
    // getter
    public Vector<Person> getEl() {
        return el;
    }
    // constructor
    public EmployeeList() {
        this.el = new Vector<>();
    }
    public EmployeeList(Vector<Person> el) {
        this.el = new Vector<>();
        this.el.addAll(el);
    }
    public void insert(Person copy) {
        el.add(copy);
    }
    public void insert() {
        int choice;
        Person newEmployee;
        do {
            try {
                System.out.println("Select the employee you want to add to the list:");
                System.out.println("1. Full-time employee.");
                System.out.println("2. Part-time employee.");
                System.out.print("Your choice: ");
                choice = Integer.valueOf(sc.nextLine());
            } catch (NumberFormatException e) {
                choice = 0;
            }
        } while (choice != 1 && choice != 2);
        if (choice == 1) {
            newEmployee = new FullTimeEmployee();
        }
        else {
            newEmployee = new PartTimeEmployee();
        }
        newEmployee.getInformation();
        el.add(newEmployee);
    }
    public void select() {
        String id;
        System.out.print("Enter id to search: ");
        id = sc.nextLine();
        select(id);
    }
    public void select(String id) {
        boolean flag = false;
        for (Person i : el) {
            if (i.getId().equals(id)) {
                i.showInformation();
                flag = true;
            }
        }
        if (flag == false) {
            System.out.println("Not found");
        }
    }
    public int selectId(String id) {
        for (Person i : el) {
            if (i.getId().equals(id)) {
                return el.indexOf(i);
            }
        }
        return -1;
    }
    public void delete() {
        String id;
        System.out.print("Enter id to delete: ");
        id = sc.nextLine();
        delete(id);
    }
    public void delete(String id) {
        for (Person i : el) {
            if (i.getId().equals(id)) {
                el.remove(i);
                System.out.println("Deletion complete");
                return;
            }
        }
    }
    public void update() {
        String id;
        System.out.print("Enter id to update: ");
        id = sc.nextLine();
        update(id);
    }
    public void update(String id) {
        for (Person i : el) {
            if (i.getId().equals(id)) {
                i.getInformation();
                return;
            }
        }
    }
    public void display() {
        el.forEach((action) -> action.showInformation());
    }
    @Override
    public String toString() {
        String tmp = "";
        for (Person i : el) {
            tmp = tmp + i.toStringForWriteFile() + "\n";
        }
        return tmp;
    }
}
