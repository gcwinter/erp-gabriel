package br.com.gabriel.controller;

import br.com.gabriel.model.Product;
import br.com.gabriel.service.StockService;
import br.com.gabriel.service.impl.StockServiceImpl;

public class StockController {

    private final StockService stockService = new StockServiceImpl();

    public void registerProduct(String serialNumber, String model, String price, String importationDate, int quantity) {
        if (quantity < 0) {
            throw new RuntimeException("Não é permitido cadastro de estoque negativo");
        }

        stockService.registerProduct(serialNumber, model, price, importationDate, quantity);
    }

    public void productOut(String item, int quantity) {
        stockService.productOut(item, quantity);
    }

    public void productIn(String item, int quantity) {
        stockService.productIn(item, quantity);
    }

    public void stockList() {
        for (Product product : stockService.stockList()) {
            System.out.println(String.format(
                    "Serial Number:\t\t\t\t%s\nModel:\t\t\t\t\t\t%s\nPrice:\t\t\t\t\t\t%s EUR\nImportation Date:\t\t\t%s\nQuantity:\t\t\t\t\t%d",
                    product.getSerialNumber(), product.getModel(), product.getPrice(), product.getImportationDate(), product.getQuantity()));
            System.out.println("----------------------------------------------------------");
        }
    }
}