package oop;

class SmartPhone extends Phone {
    public SmartPhone() {}
    public SmartPhone(String phoneProvider, String phoneName, String phoneBrandName, int price, int publishingYear) {
        super(phoneProvider, phoneName, phoneBrandName, price, publishingYear);
    }
    @Override
    public void PhoneFeatures() {
        System.out.println("SmartPhone is a portable device that combines mobile telephone and computing functions into one unit. ");
    }
    @Override
    public String toStringForWriteFile() {
        return super.toStringForWriteFile() + ";" + "SP";
    }
}