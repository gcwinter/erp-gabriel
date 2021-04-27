package br.com.gabriel.service.impl;

import br.com.gabriel.model.Product;
import br.com.gabriel.repository.ProductRepository;
import br.com.gabriel.repository.impl.ProductMySQLRepository;
import br.com.gabriel.repository.impl.ProductRepositoryImpl;
import br.com.gabriel.service.StockService;

import java.util.ArrayList;
import java.util.List;

public class StockServiceImpl implements StockService {
    public ProductRepository productRepository = new ProductMySQLRepository();

    @Override
    public void registerProduct(String serialNumber, String model, String price, String importationDate, int quantity) {
        final var product = new Product(serialNumber, model, price, importationDate, quantity);
        productRepository.save(product);
    }

    @Override
    public void productOut(int id, int quantity) {
        final var product = productRepository.findById(id);//FIXME
        if (product.getQuantity() < 15) {
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("O estoque do produto " + product.getModel() + " esta abaixo do aceitavel");
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
        if (product.getQuantity() < quantity) {
            System.err.println("Não é possivel tirar mais do que possui no estoque");

        } else {
            product.removeQuantity(quantity);
            productRepository.updateProduct(product);
        }
    }

    @Override
    public void productIn(int id, int quantity) {
        final var product = productRepository.findById(id);
        product.addQuantity(quantity);
        productRepository.updateProduct(product);

    }


    @Override
    public List<Product> stockList() {
        return productRepository.findAll();
    }

    @Override
    public Product findProduct(int id) {

        return productRepository.findById(id);

    }

    @Override
    public boolean deleteById(int id) {
        final var product = productRepository.findById(id);
        if (product.getId() > 0) {
            System.out.println("o produto foi encontrado no banco de dados");
            productRepository.delete(product);
            return true;
        }
        System.out.println("o produto não foi encontrado na base de dados");
        return false;
    }


}
