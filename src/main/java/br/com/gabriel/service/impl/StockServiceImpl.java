package br.com.gabriel.service.impl;

import br.com.gabriel.model.Product;
import br.com.gabriel.model.Stock;
import br.com.gabriel.service.StockService;

import java.util.List;

public class StockServiceImpl implements StockService {
    public Stock stock = new Stock();

    @Override
    public void registerProduct(String serialNumber, String model, String price, String importationDate, int quantity) {
        stock.registerProduct(serialNumber, model, price, importationDate, quantity);
    }

    @Override
    public void productOut(String item, int removeQuantity) {

        for (Product product : stock.stockList()) {
            if (product.getQuantity() < 15) {
                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println("O estoque do produto " + product.getModel() + " esta abaixo do aceitavel");
                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            }
        }

        stock.productOut(item, removeQuantity);
    }

    @Override
    public void productIn(String item, int addQuantity) {
        stock.productIn(item, addQuantity);
    }

    @Override
    public List<Product> stockList() {
        return stock.stockList();
    }
}
