package br.com.gabriel;

import br.com.gabriel.controller.StockController;

public class ERPApplication {

    public static void main(String[] args) {
//
//        Client marelli = new Client( "Magneti Marelli", "11 4555-6666", "Av blablabla 165", "000-2222,222/0001", "ashuhuashusa ");
//        marelli.newContact("Gabriel", "1155625", "gwinter", "", "");
//        marelli.contactList();
//        marelli.getInformation();
//---------------------
        StockController newStock = new StockController();
        newStock.registerProduct("11111", "plkuto1", "499.50", "25/07/55", 10);
        newStock.registerProduct("2222", "111", "1111", "25/07/55", 20);
        newStock.registerProduct("33333", "111", "1111", "25/07/55", 30);
        try {
            newStock.registerProduct("2222", "111", "1111", "25/07/55", -20);
        } catch (RuntimeException e) {
            System.err.println("===========================================================");
            System.err.println(e.getMessage());
            System.err.println("===========================================================");
        }
        newStock.productOut("2222", 3);
        newStock.productIn("2222", 10);
        newStock.stockList();
    }
}