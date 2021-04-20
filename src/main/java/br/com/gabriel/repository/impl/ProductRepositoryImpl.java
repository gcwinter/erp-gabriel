package br.com.gabriel.repository.impl;

import br.com.gabriel.model.Product;
import br.com.gabriel.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {

    private static final List<Product> STOCK = new ArrayList<>();

    @Override
    public Product save(Product product) {
        STOCK.add(product);
        return product;
    }

    @Override
    public List<Product> findAll() {
        return STOCK;
    }
}
