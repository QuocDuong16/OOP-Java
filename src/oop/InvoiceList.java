package oop;

import java.util.Scanner;
import java.util.Arrays;

public class InvoiceList {
    Scanner sc = new Scanner(System.in);
    private Invoice[] invoice;
    private int n;
    public InvoiceList() {
        n = 0;
        invoice = new Invoice[n];
    }
    public InvoiceList(int n, Invoice[] invoice) {
        this.n = n;
        this.invoice = new Invoice[n];
        this.invoice = invoice;
    }
    public void insert(Invoice copy) {
        invoice = Arrays.copyOf(invoice, n + 1);
        invoice[n] = copy;
        n++;
    }
    public void insert() {
        invoice = Arrays.copyOf(invoice, n + 1);
        invoice[n] = new Invoice();
        invoice[n].getInformation();
        n++;
    }
    public void update() {
        int invoiceId;
        do {
            try {
                System.out.print("Enter the invoice ID to fix: ");
                invoiceId = Integer.valueOf(sc.nextLine());
            } catch (NumberFormatException e) {
                invoiceId = -1;
            }
        } while (invoiceId == -1);
        update(invoiceId);
    }
    public void update(int invoiceId) {
        for (Invoice p : invoice) {
            if (p.getId() == invoiceId) {
            System.out.println("-------Enter information invoice------ ");
            p.getInformation();
            }
        }
    }
    public void delete() {
        int invoiceId;
        do {
            try {
                System.out.print("Enter the ID to delete: ");
                invoiceId = Integer.valueOf(sc.nextLine());
            } catch (NumberFormatException e) {
                invoiceId = -1;
            }
        } while (invoiceId == -1);
        delete(invoiceId);
    }
    public void delete(int invoiceId) {
        for (int i = 0; i < n; i++) {
            if (invoice[i].getId() == invoiceId) {
                for (int j = i; j < n - 1; j++) {
                    invoice[j] = invoice[j + 1];
                }
                invoice = Arrays.copyOf(invoice, n - 1);
                n--;
                return;
            }
        }
    }
    public void select() {
        int invoiceId;
        do {
            try {
                System.out.print("Enter the ID to search: ");
                invoiceId = Integer.valueOf(sc.nextLine());
            } catch (NumberFormatException e) {
                invoiceId = -1;
            }
        } while (invoiceId == -1);
        select(invoiceId);
    }
    public void select(int invoiceId) {
        for (Invoice p : invoice) {
            System.out.println("---The name to search is---");
            if (p.getId()== invoiceId) {
                p.showInformation();
                return;
            }
        }
    } 
    public void display() {
        for (Invoice i : invoice) {
            i.showInformation();
        }
    }
    @Override
    public String toString() {
        String tmp = "";
        for (Invoice i : invoice) {
            tmp = tmp + i.toStringForWriteFile() + "\n";
        }
        return tmp;
    }
}
