package br.com.gabriel.service.impl;

import br.com.gabriel.model.Product;
import br.com.gabriel.repository.ProductRepository;
import br.com.gabriel.repository.impl.ProductMySQLRepository;
import br.com.gabriel.repository.impl.ProductRepositoryImpl;
import br.com.gabriel.service.StockService;

import java.util.List;

public class StockServiceImpl implements StockService {
    public ProductRepository productRepository = new ProductMySQLRepository();

    @Override
    public void registerProduct(String serialNumber, String model, String price, String importationDate, int quantity) {
        final var product = new Product(serialNumber, model, price, importationDate, quantity);
        productRepository.save(product);
    }

    @Override
    public void productOut(String item, int removeQuantity) {
        for (Product product : productRepository.findAll()) {
            if (product.getQuantity() < 15) {
                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println("O estoque do produto " + product.getModel() + " esta abaixo do aceitavel");
                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            }
        }

        for (Product product : productRepository.findAll()) {
            if (item.equals(product.getSerialNumber())) {
                product.removeQuantity(removeQuantity);
            }
        }
    }

    @Override
    public void productIn(String item, int addQuantity) {
        for (Product product : productRepository.findAll()) {
            if (item.equals(product.getSerialNumber())) {
                product.addQuantity(addQuantity);
            }
        }
    }

    @Override
    public List<Product> stockList() {
        return productRepository.findAll();
    }
}
