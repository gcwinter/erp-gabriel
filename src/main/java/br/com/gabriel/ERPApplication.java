package br.com.gabriel;

import br.com.gabriel.controller.StockController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ERPApplication {

    public static void main(String[] args) throws IOException {
        final var bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final var newStock = new StockController();
        var console = "";
        do {
            System.out.println("------------Menu------------");
            System.out.println("Digite 1 para adicionar");
            System.out.println("Digite 2 para listar");
            System.out.println("Digite 3 para sair");
            console = bufferedReader.readLine();
            if ("1".equals(console)) {
                System.out.println("Insira o numero de serie");
                final var serialNumber = bufferedReader.readLine();
                System.out.println("Insira o modelo");
                final var model = bufferedReader.readLine();
                System.out.println("Insira o preço");
                final var price = bufferedReader.readLine();
                System.out.println("Insira a data de importação");
                final var importationDate = bufferedReader.readLine();
                System.out.println("Insira a quantidade em estoque");
                final var stockAmount = Integer.parseInt(bufferedReader.readLine());
                try {
                    newStock.registerProduct(serialNumber, model, price, importationDate, stockAmount);
                } catch (RuntimeException e) {
                    System.err.println(e.getMessage());
                }
            }
            if ("2".equals(console)) {
                newStock.stockList();
            }
            if ("3".equals(console)) {
                console = "exit";
            }
        } while (!"exit".equalsIgnoreCase(console));
    }
}