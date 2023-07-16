package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import controller.NotFoundException;
import model.Order;
import repository.OrderRepository;

@Service
public class OrderService {
	
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Order not found with ID: " + id));
    }

    public Order createOrder(Order order) {
        // Additional logic if needed
        return orderRepository.save(order);
    }

    public Order updateOrder(Long id, Order updatedOrder) {
        return orderRepository.findById(id)
                .map(order -> {
                    order.setUser(updatedOrder.getUser());
                    order.setCreatedDate(updatedOrder.getCreatedDate());
                    order.setModifiedDate(updatedOrder.getModifiedDate());
                    order.setTotalPrice(updatedOrder.getTotalPrice());
                    order.setStatus(updatedOrder.getStatus());
                    order.setOrderItems(updatedOrder.getOrderItems());
                    return orderRepository.save(order);
                })
                .orElseThrow(() -> new NotFoundException("Order not found with ID: " + id));
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}

