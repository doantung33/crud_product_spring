package service;

import model.Product;

import java.util.List;

public interface IServiceProduct {
    List<Product> findAll();
    void save(Product product);
    Product findById(int id);
    void update(int id,Product product);
    void remote(int id);
}
