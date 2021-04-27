package br.com.gabriel.repository.impl;

import br.com.gabriel.model.Product;
import br.com.gabriel.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {

    private static final List<Product> STOCK = new ArrayList<>();

    @Override
    public void save(Product product) {
        STOCK.add(product);

    }

    @Override
    public List<Product> findAll() {
        return STOCK;
    }

    @Override
    public void delete(Product product) {

    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public void updateProduct(Product product) {

    }
}
