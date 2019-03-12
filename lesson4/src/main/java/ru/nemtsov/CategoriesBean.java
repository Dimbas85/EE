package ru.nemtsov;

import ru.nemtsov.entity.Category;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import java.util.Collection;

@ManagedBean (name = "categories")
@SessionScoped
public class CategoriesBean {

    @Inject
    private CategoryRepository categoryRepository;

    private Category category;

    public int getId() {
        return category.getId();
    }

    public void setId(int id) {
        category.setId(id);
    }

    public String getName() {
        return category.getName();
    }

    public void setName(String name) {
        category.setName(name);
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Collection<Category> getCategoryList() {
        return categoryRepository.getAll();
    }

    public String editAction(Category category) {
        this.category = category;
        return "/category.xhtml?faces-redirect=true";
    }

    public void deleteAction(Category category) {
        categoryRepository.delete(category);
    }

    public String saveCategory() {
        categoryRepository.save(category);
        return "/categories.xhtml?faces-redirect=true"; // после сохранения продукта возвращаемся на главную страницу
    }

    public String addAction() {
        this.category = new Category(categoryRepository.getCurrentId(), "");
        return "/category.xhtml?faces-redirect=true";
    }

}
