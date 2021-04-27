package br.com.gabriel.repository;

import br.com.gabriel.model.Product;

import java.util.List;

public interface ProductRepository {

    void save(Product product);

    List<Product> findAll();

    void delete(Product product);

    Product findById(int id);

    void updateProduct(Product product);
}
