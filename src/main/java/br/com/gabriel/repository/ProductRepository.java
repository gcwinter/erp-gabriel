package br.com.gabriel.repository;

import br.com.gabriel.model.Product;

import java.util.List;

public interface ProductRepository {

    Product save(Product product);

    List<Product> findAll();
}
