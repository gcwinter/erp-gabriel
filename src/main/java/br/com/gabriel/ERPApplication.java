package br.com.gabriel;

import br.com.gabriel.controller.ClientController;
import br.com.gabriel.controller.StockController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ERPApplication {

    public static void main(String[] args) throws IOException {
        final var bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final var newStock = new StockController();
        final var client = new ClientController();
        var console = "";
        do {
            System.out.println("------------Menu------------");
            System.out.println("Digite 1 para adicionar");
            System.out.println("Digite 2 para listar");
            System.out.println("Digite 3 para sair");
            System.out.println("Digite 4 para buscar um produto pelo ID");
            System.out.println("Digite 5 para deletar um produto pelo ID");
            System.out.println("Digite 6 para remover uma quantidade de um produto pelo ID");
            System.out.println("Digite 7 para adicionar uma quantidade de um produto pelo ID");

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
            if ("4".equals(console)) {
                System.out.println("Digite o numero do ID desejado:");
                final int id = Integer.parseInt(bufferedReader.readLine());
                newStock.findProduct(id);
            }
            if ("5".equals(console)) {
                System.out.println("Digite o numero do ID desejado:");
                final int id = Integer.parseInt(bufferedReader.readLine());
                newStock.deleteProduct(id);

            }
            if ("6".equals(console)) {
                System.out.println("Digite o numero do ID desejado:");
                final int id = Integer.parseInt(bufferedReader.readLine());
                System.out.println("Digite a quantidade a ser retirada do estoque:");
                final int quantity = Integer.parseInt(bufferedReader.readLine());
                newStock.productOut(id,quantity);

            }
            if ("7".equals(console)) {
                System.out.println("Digite o numero do ID desejado:");
                final int id = Integer.parseInt(bufferedReader.readLine());
                System.out.println("Digite a quantidade a ser adicionada do estoque:");
                final int quantity = Integer.parseInt(bufferedReader.readLine());
                newStock.productIn(id,quantity);

            }
        } while (!"exit".equalsIgnoreCase(console));
    }

}