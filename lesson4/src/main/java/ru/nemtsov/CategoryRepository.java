package ru.nemtsov;

import ru.nemtsov.entity.Category;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Named
@ApplicationScoped
public class CategoryRepository {

    private Map<Integer, Category> categoryMap = new HashMap<>();

    private int currentId = 0;

    public CategoryRepository() {
        this.add(new Category(getCurrentId(), "Pens"));
        this.add(new Category(getCurrentId(), "Paper"));
        this.add(new Category(getCurrentId(), "Books"));
    }

    public void add(Category category) {
        categoryMap.put(category.getId(), category);
    }

    public Collection<Category> getAll() {
        return categoryMap.values();
    }

    public void save(Category category) {
        categoryMap.put(category.getId(), category);
    }

    public void delete(Category category) {
        categoryMap.remove(category.getId());
    }

    public Category getById(String id) {
        return categoryMap.get(id);
    }

    public int getCurrentId() {
        currentId++;
        return currentId;
    }

}
