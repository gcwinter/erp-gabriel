package br.com.gabriel.repository.impl;

import br.com.gabriel.model.Product;
import br.com.gabriel.repository.ConnectionMySQL;
import br.com.gabriel.repository.ProductRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductMySQLRepository implements ProductRepository {

    private static final Connection CONNECTION_MY_SQL = ConnectionMySQL.getConnectionMySQL();

    @Override
    public Product save(Product product) {
        //TODO implementa o save usando o google para me ajudar a salvar um valor no banco de dados,
        // sugestão de busca como salvar dados no mysql usando jdbc

        return null;
    }

    @Override
    public List<Product> findAll() {
        try {
            final var query = "SELECT * FROM Product;";
            final var preparedStatement = CONNECTION_MY_SQL.prepareStatement(query);
            final var resultSet = preparedStatement.executeQuery();

            final var products = new ArrayList<Product>();
            while (resultSet.next()) {
                final var id = resultSet.getInt("id");
                final var serialNumber = resultSet.getString("serial_number");
                final var model = resultSet.getString("model");
                final var price = resultSet.getString("price");
                final var importationDate = resultSet.getString("importation_date");
                final var quantity = resultSet.getInt("quantity");
                final var product = new Product(serialNumber, model, price, importationDate, quantity);
                products.add(product);
            }
            return products;

        } catch (SQLException throwables) {
            System.err.println("Erro ao conectar ou buscar dados do banco");
            return new ArrayList<>();
        }
    }


}
