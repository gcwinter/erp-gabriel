package br.com.gabriel.repository.impl;

import br.com.gabriel.model.Product;
import br.com.gabriel.repository.ConnectionMySQL;
import br.com.gabriel.repository.ProductRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductMySQLRepository implements ProductRepository {

    private static final Connection CONNECTION_MY_SQL = ConnectionMySQL.getConnectionMySQL();

    @Override
    public void save(Product product) {
        //TODO implementa o save usando o google para me ajudar a salvar um valor no banco de dados,
        // sugestão de busca como salvar dados no mysql usando jdbc
        try {


            final var query = "INSERT INTO Product(serial_number,model,price,quantity,importation_date) VALUES (?,?,?,?,?)";

            final var preparedStatement = CONNECTION_MY_SQL.prepareStatement(query);
            preparedStatement.setString(1, product.getSerialNumber());
            preparedStatement.setString(2, product.getModel());
            preparedStatement.setString(3, product.getPrice());
            preparedStatement.setInt(4, product.getQuantity());
            preparedStatement.setString(5, product.getImportationDate());
            preparedStatement.execute();

        } catch (SQLException throwables) {
            System.out.println(throwables.getErrorCode());

        }
    }

    @Override
    public List<Product> findAll() {
        try {
            final var query = "SELECT * FROM Product;";
            final var preparedStatement = CONNECTION_MY_SQL.prepareStatement(query);
            final var resultSet = preparedStatement.executeQuery();

            final var products = new ArrayList<Product>();
            while (resultSet.next()) {

                final var product = getProduct(resultSet);
                products.add(product);
            }
            return products;

        } catch (SQLException throwables) {
            System.err.println("Erro ao conectar ou buscar dados do banco");
            return new ArrayList<>();
        }


    }

    @Override
    public void delete(Product product) {
        try {
            final var query = "DELETE FROM Product WHERE id = ?;";
            final var preparedStatement = CONNECTION_MY_SQL.prepareStatement(query);
            preparedStatement.setInt(1, product.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }


    }

    @Override
    public Product findById(int id) {
        try {
            final var query = "SELECT * FROM Product WHERE id = ?;";
            final var preparedStatement = CONNECTION_MY_SQL.prepareStatement(query);
            preparedStatement.setInt(1, id);
            final var resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return getProduct(resultSet);
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return new Product(null, null, null, null, 0);

    }

    @Override
    public void updateProduct(Product product) {
        try {
            final var query = "UPDATE Product SET quantity = ? WHERE id = ?";
            final var preparedStatement = CONNECTION_MY_SQL.prepareStatement(query);
            preparedStatement.setInt(1, product.getQuantity());
            preparedStatement.setInt(2, product.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            System.out.println(throwables.getErrorCode());
        }
    }

    private Product getProduct(ResultSet resultSet) throws SQLException {
        final var id = resultSet.getInt("id");
        final var serialNumber = resultSet.getString("serial_number");
        final var model = resultSet.getString("model");
        final var price = resultSet.getString("price");
        final var importationDate = resultSet.getString("importation_date");
        final var quantity = resultSet.getInt("quantity");
        final var product = new Product(serialNumber, model, price, importationDate, quantity);
        product.setId(id);
        return product;


    }
}



