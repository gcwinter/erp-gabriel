package br.com.gabriel.model;

public class Product {

    private final String serialNumber;
    private final String model;
    private final String price;
    private final String importationDate;
    private int quantity;

    public Product(String serialNumber, String model, String price, String importationDate, int quantity) {
        this.serialNumber = serialNumber;
        this.model = model;
        this.price = price;
        this.importationDate = importationDate;
        this.quantity = quantity;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }

    public void removeQuantity(int quantity) {
        this.quantity -= quantity;
    }

//    public String getInformation() {
//        return String.format(
//                "Serial Number:    %s\nModel:           %s\nPrice:            %s EUR\nImportation Date: %s\nQuantity:         %d",
//                this.serialNumber, this.model, this.price, this.importationDate, this.quantity);
//    }

    public int getQuantity() {
        return quantity;
    }

    public String getImportationDate() {
        return importationDate;
    }

    public String getModel() {
        return model;
    }

    public String getPrice() {
        return price;
    }
}
