package ru.nemtsov;

import ru.nemtsov.entity.Product;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import java.util.Collection;


@ManagedBean(name = "products")
@SessionScoped
public class ProductsBean {

    @Inject
    private ProductRepository productRepository;

    private Product product;

    public int getId() {
        return product.getId();
    }

    public void setId(int id) {
        product.setId(id);
    }

    public String getName() {
        return product.getName();
    }

    public void setName(String name) {
        product.setName(name);
    }

    public int getPrice() {
        return product.getPrice();
    }

    public void setPrice(int price) {
        product.setPrice(price);
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Collection<Product> getProductList() {
        return productRepository.getAll();
    }

    public String editAction(Product product) {
        this.product = product;
        return "/product.xhtml?faces-redirect=true";
    }

    public void deleteAction(Product product) {
        productRepository.delete(product);
    }

    public String saveProduct() {
        productRepository.save(product);
        return "/products.xhtml?faces-redirect=true";
    }

    public String addAction() {
        this.product = new Product(productRepository.getCurrentId(), "", 0);
        return "/product.xhtml?faces-redirect=true";
    }
}