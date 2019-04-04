package ru.nemtsov;

import ru.nemtsov.persistance.CategoryRepository;
import ru.nemtsov.persistance.ProductRepository;
import ru.nemtsov.persistance.entity.Category;
import ru.nemtsov.persistance.entity.Product;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collection;


@Named("products")
@SessionScoped
public class ProductsBean implements Serializable {

    @Inject
    private ProductRepository productRepository;

    @Inject
    private CategoryRepository categoryRepository;

    @Inject
    private CategoriesBean categoriesBean;

    @Inject
    private CartViewBean cartViewBean;

    // наличие такого поля для хранения текущего элемента является стандартным для JSF
    private Product product;

    private Collection<Product> productList;

    public void preloadProductList(ComponentSystemEvent event) throws AbortProcessingException {
        boolean postback = FacesContext.getCurrentInstance().isPostback();
        boolean ajaxRequest = FacesContext.getCurrentInstance().getPartialViewContext().isAjaxRequest();

        if (categoriesBean.getCategory() != null) {
            productList = productRepository.getByCategory(categoriesBean.getCategory().getId());
            return;
        }
        productList = productRepository.getAll();
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getCategoryId() {
        if (product == null || product.getCategory() == null) {
            return "-1L";
        }
        return String.valueOf(product.getCategory().getId());
    }

    public void setCategoryId(String id) {
        if (id == null || id.isEmpty()) {
            return;
        }
        Category newCategory = categoryRepository.getById(Long.valueOf(id));
        if (newCategory != null) {
            product.setCategory(newCategory);
        }
    }

    public Collection<Product> getProductList() {
        return productList;
    }

    public void newProductAction() {
        this.product = new Product();
        this.product.setCategory(categoriesBean.getCategory());
    }

    public void deleteAction(Product product) {
        productRepository.remove(product);
    }

    public void addToCart(Product product) {
        cartViewBean.addToCard(product);
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/index.xhtml?faces-redirect=true";
    }


    public void saveProduct() {
        productRepository.merge(product);
    }

    public void setCategoriesBean(CategoriesBean categoriesBean) {
        this.categoriesBean = categoriesBean;
    }
}