package oop;

public class BangerPhone extends Phone {
    // constructor
    public BangerPhone() {}
    public BangerPhone(String phoneProvider, String phoneName, String phoneBrandName, int price, int publishingYear) {
        super(phoneProvider, phoneName, phoneBrandName, price, publishingYear);
    }
    @Override
    public void PhoneFeatures() {
        System.out .println("BangerPhone is A cheap phone that cannot access the internet ");
    }
    @Override
    public String toStringForWriteFile() {
        return super.toStringForWriteFile() + ";" + "BP";
    }
}