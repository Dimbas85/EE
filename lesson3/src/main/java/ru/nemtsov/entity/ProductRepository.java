package ru.nemtsov.entity;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class ProductRepository {

    private Map<String, Product> productMap = new LinkedHashMap<>();

    public ProductRepository() {
        productMap.put("1", new Product(1, "MARGHERITA", "100", "Our most popular pizza – and the one by which all pizzerias should be judged."));
        productMap.put("2", new Product(2, "MARINARA", "80", "Simplicity itself – but do not be fooled!"));
        productMap.put("3", new Product(3, "NDUJA", "100", "A true discovery of our “Pizza Pilgrimage” – the Nduja pizza has become one of our signature pizzas – and a real favourite of PP fans."));
        productMap.put("4", new Product(4, "SALAMI", "110", "Probably the closest thing that we have to a “Pepperoni Pizza” – this is one for the meat lovers."));
    }

    public void addProduct(Product product) {
        productMap.put("" + product.getId(), product);
    }

    public Collection<Product> getAll() {
        return productMap.values();
    }

    public Product getProductByID(String id) {
        return productMap.get(id);
    }

}
