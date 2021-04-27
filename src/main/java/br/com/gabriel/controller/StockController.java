package br.com.gabriel.controller;

import br.com.gabriel.model.Product;
import br.com.gabriel.service.StockService;
import br.com.gabriel.service.impl.StockServiceImpl;

public class StockController {

    private final StockService stockService = new StockServiceImpl();

    public void findProduct(int id) {

        if (id > 0) {
            final var product = stockService.findProduct(id);
            System.out.println(String.format(
                    "ID:\t\t\t\t\t\t\t%d\nSerial Number:\t\t\t\t%s\nModel:\t\t\t\t\t\t%s\nPrice:\t\t\t\t\t\t%s EUR\nImportation Date:\t\t\t%s\nQuantity:\t\t\t\t\t%d", product.getId(),
                    product.getSerialNumber(), product.getModel(), product.getPrice(), product.getImportationDate(), product.getQuantity()));
        }

    }

    public void registerProduct(String serialNumber, String model, String price, String importationDate, int quantity) {
        if (quantity < 0) {
            throw new RuntimeException("Não é permitido cadastro de estoque negativo");
        }

        stockService.registerProduct(serialNumber, model, price, importationDate, quantity);
    }

    public void productOut(int id, int quantity) {
        if (quantity < 0) {
            System.err.println("Não é permitido valores negativos");
        } else {
            stockService.productOut(id, quantity);
        }
    }

    public void productIn(int id, int quantity) {
        if (quantity < 0) {
            System.err.println("Não é permitido valores negativos");
        } else {
            stockService.productIn(id, quantity);
        }
    }

    public void stockList() {
        for (Product product : stockService.stockList()) {
            System.out.println(String.format(
                    "ID:\t\t\t\t\t\t\t%d\nSerial Number:\t\t\t\t%s\nModel:\t\t\t\t\t\t%s\nPrice:\t\t\t\t\t\t%s EUR\nImportation Date:\t\t\t%s\nQuantity:\t\t\t\t\t%d", product.getId(),
                    product.getSerialNumber(), product.getModel(), product.getPrice(), product.getImportationDate(), product.getQuantity()));
            System.out.println("----------------------------------------------------------");
        }
    }

    public void deleteProduct(int id) {

        if (id > 0) {
            System.out.println("o id digitado é inteiro e maior do que zero");
            if (stockService.deleteById(id)) {
                System.out.println("foi deletado com sucesso, a nova lista é:");
                stockList();
            } else {
                System.out.println("o produto não foi encontrado no banco de dados");
            }

        } else {
            System.out.println("o id digitado é menor do que um");
        }

    }
}