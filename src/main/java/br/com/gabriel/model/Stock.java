package br.com.gabriel.model;

import java.util.ArrayList;
import java.util.List;

public class Stock {

    private static final List<Product> STOCK = new ArrayList<>();

    public void registerProduct(String serialNumber, String model, String price, String importationDate, int quantity) {
        Product product = new Product(serialNumber, model, price, importationDate, quantity);
        STOCK.add(product);
    }

    public void productOut(String item, int removeQuantity) {
        for (Product product : STOCK) {
            if (item.equals(product.getSerialNumber())) {
                product.removeQuantity(removeQuantity);
            }
        }
    }

    public void productIn(String item, int addQuantity) {
        for (Product product : STOCK) {
            if (item.equals(product.getSerialNumber())) {
                product.addQuantity(addQuantity);
            }
        }
    }

    public List<Product> stockList() {
        return STOCK;
    }

}
