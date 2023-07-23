package controller;


import java.util.List;
import java.math.BigDecimal;
import java.util.stream.Collectors;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import entitiesDTO.OrderDTO;
import entitiesDTO.OrderItemDTO;
import model.Order;
import model.OrderItem;
import repository.OrderRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/orders")
public class OrderController {
	
    private final OrderRepository orderRepository;

    //@Autowired
    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    
    @GetMapping
    public List<OrderDTO> getAllOrders() {
    	List<Order> order = orderRepository.findAll();
    	return order.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public OrderDTO getOrderById(@PathVariable("id") Long id) {
    	Order order = orderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Order not found with ID: " + id));
    	return convertToDTO(order);
    }
    

    @PostMapping("/")
    public Order createOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }

    @PutMapping("/{id}")
    public Order updateOrder(Long id, Order updatedOrder) {
        return orderRepository.findById(id)
                .map(order -> {
                    order.setUser(updatedOrder.getUser());
                    order.setCreatedDate(updatedOrder.getCreatedDate());
                    order.setModifiedDate(updatedOrder.getModifiedDate());
                    order.setTotalPrice();
                    order.setStatus(updatedOrder.getStatus());
                    order.setOrderItems(updatedOrder.getOrderItems());
                    return orderRepository.save(order);
                })
                .orElseThrow(() -> new NotFoundException("Order not found with ID: " + id));
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable("id") Long id) {
    	orderRepository.deleteById(id);
    }
    
    protected OrderDTO convertToDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setUserID(order.getUser().getId());
        orderDTO.setUserName(order.getUser().getFirstName() + " " + order.getUser().getLastName() );
        orderDTO.setCreatedDate(order.getCreatedDate());
        orderDTO.setModifiedDate(order.getModifiedDate());        
        orderDTO.setStatus(order.getStatus());
        orderDTO.setOrderItems(convertToOrderItemDTOs(order.getOrderItems()));
        
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (OrderItem orderItem : order.getOrderItems()) {
            totalPrice = totalPrice.add(orderItem.getBook().getPrice());
        }
        orderDTO.setTotalPrice(totalPrice);
        return orderDTO;
    }
    
    private List<OrderItemDTO> convertToOrderItemDTOs(List<OrderItem> orderItems) {
        return orderItems.stream()
                .map(this::convertToOrderItemDTO)
                .collect(Collectors.toList());
    }
    
    private OrderItemDTO convertToOrderItemDTO(OrderItem orderItem) {
        OrderItemDTO orderItemDTO = new OrderItemDTO();
        
        orderItemDTO.setId(orderItem.getId());
        orderItemDTO.setOrderID(orderItem.getOrder().getId());
        orderItemDTO.setBook(orderItem.getBook().getTitle());
        orderItemDTO.setQuantity(orderItem.getQuantity());
        orderItemDTO.setPrice(orderItem.getBook().getPrice());
        return orderItemDTO;
    }
    
}



