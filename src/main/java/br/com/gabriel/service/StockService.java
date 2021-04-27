package br.com.gabriel.service;

import br.com.gabriel.model.Product;

import java.util.List;

public interface StockService {

    void registerProduct(String serialNumber, String model, String price, String importationDate, int quantity);

    void productOut(int id, int quantity);

    void productIn(int id, int addQuantity);

    List<Product> stockList();

    Product findProduct(int id);

    boolean deleteById(int id);
}
