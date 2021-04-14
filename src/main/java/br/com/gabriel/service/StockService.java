package br.com.gabriel.service;

import br.com.gabriel.model.Product;

import java.util.List;

public interface StockService {

    void registerProduct(String serialNumber, String model, String price, String importationDate, int quantity);

    void productOut(String item, int removeQuantity);

    void productIn(String item, int addQuantity);

    List<Product> stockList();
}
