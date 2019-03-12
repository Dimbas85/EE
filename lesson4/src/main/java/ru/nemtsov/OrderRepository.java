package ru.nemtsov;

import ru.nemtsov.entity.Order;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Named
@ApplicationScoped
public class OrderRepository {
    private Map<Integer, Order> orderMap = new HashMap<>();

    private int currentId = 0;

    public OrderRepository() {
        this.add(new Order(getCurrentId(), "Order 1"));
        this.add(new Order(getCurrentId(), "Order 2"));
        this.add(new Order(getCurrentId(), "Order 3"));
        this.add(new Order(getCurrentId(), "Order 4"));
    }

    public void add (Order order) {
        orderMap.put(order.getId(), order);
    }

    public Collection<Order> getAll() {
        return orderMap.values();
    }

    public Order getById (int id) {
        return orderMap.get(id);
    }

    public void save(Order order) {
        orderMap.put(order.getId(), order);
    }

    public void delete(Order order) {
        orderMap.remove(order.getId());
    }

    public int getCurrentId() {
        currentId++;
        return currentId;
    }
}
