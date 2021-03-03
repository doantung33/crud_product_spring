package service;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceProduct implements IServiceProduct{
    private static Map<Integer,Product>products=new HashMap<>();
    static {
        products.put(1,new Product(1,"name1",1,"des1"));
        products.put(2,new Product(2,"name2",2,"des2"));
        products.put(3,new Product(3,"name3",3,"des3"));
        products.put(4,new Product(4,"name4",4,"des4"));
        products.put(5,new Product(5,"name5",5,"des5"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(),product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id,product);
    }

    @Override
    public void remote(int id) {
        products.remove(id);
    }
}
