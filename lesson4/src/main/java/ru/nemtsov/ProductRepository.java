package ru.nemtsov;

import ru.nemtsov.entity.Product;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

@Named
@ApplicationScoped
public class ProductRepository {

    private Map<Integer, Product> productMap = new LinkedHashMap<>();

    private int currentId = 0;

    public ProductRepository() {
        this.add(new Product(getCurrentId(), "Pen", 50));
        this.add(new Product(getCurrentId(), "Pencil", 150));
        this.add(new Product(getCurrentId(), "Textbook", 200));
        this.add(new Product(getCurrentId(), "Paper", 500));
        this.add(new Product(getCurrentId(), "Pen", 50));
        this.add(new Product(getCurrentId(), "Eraser", 150));
        this.add(new Product(getCurrentId(), "Marker", 200));
        this.add(new Product(getCurrentId(), "Sticks", 500));
        this.add(new Product(getCurrentId(), "Brash", 50));
        this.add(new Product(getCurrentId(), "Pencil", 150));
        this.add(new Product(getCurrentId(), "Textbook", 200));
        this.add(new Product(getCurrentId(), "Paper", 500));
        this.add(new Product(getCurrentId(), "Pen", 50));
        this.add(new Product(getCurrentId(), "Pencil", 150));
        this.add(new Product(getCurrentId(), "Textbook", 200));
        this.add(new Product(getCurrentId(), "Paper", 500));
    }

    public Collection<Product> getAll() {
        return productMap.values();
    }

    public Product getById(String id) {
        return productMap.get(id);
    }

    public void add(Product product) {
        productMap.put(product.getId(), product);
    }

    public void save(Product product) {
        productMap.put(product.getId(), product);
    }

    public void delete(Product product) {
        productMap.remove(product.getId());
    }

    public int getCurrentId() {
        currentId++;
        return currentId;
    }

}
