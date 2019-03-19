package ru.nemtsov;

import ru.nemtsov.entity.Order;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import java.util.Collection;

@ManagedBean (name = "orders")
@SessionScoped
public class OrdersBean {

    @Inject
    private OrderRepository orderRepository;

    private Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getId() {
        return order.getId();
    }

    public void setId(int id) {
        order.setId(id);
    }

    public String getDescription() {
        return order.getDescription();
    }

    public void setDescription(String description) {
        order.setDescription(description);
    }

    public Collection<Order> getOrderList() {
        return orderRepository.getAll();
    }

    public String editAction(Order order) {
        this.order = order;
        return "/order.xhtml?faces-redirect=true";
    }

    public void deleteAction(Order order) {
        orderRepository.delete(order);
    }

    public String saveOrder() {
        orderRepository.save(order);
        return "/orders.xhtml?faces-redirect=true";
    }

    public String addAction() {
        this.order = new Order(orderRepository.getCurrentId(), "");
        return "/order.xhtml?faces-redirect=true";
    }

}
