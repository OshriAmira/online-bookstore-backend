package controller;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import entitiesDTO.OrderItemDTO;
import model.OrderItem;
import repository.OrderItemRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/orderItems")
public class OrderItemController {
	
    private final OrderItemRepository orderItemRepository;

    //@Autowired
    public OrderItemController(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }
    
    @GetMapping
    public List<OrderItemDTO> getAllOrderItem() {
    	List<OrderItem> orderItem = orderItemRepository.findAll();
    	return orderItem.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public OrderItemDTO getOrderItemById(@PathVariable("id") Long id) {
    	OrderItem orderItem = orderItemRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("OrderItem not found with ID: " + id));
    	return convertToDTO(orderItem);
    }
    


    @PostMapping("/")
    public OrderItem createOrderItem(@RequestBody OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    @PutMapping("/{id}")
    public OrderItem updateOrderItem(Long id, OrderItem updatedOrderItem) {
        OrderItem existingOrderItem = orderItemRepository.findById(id)
        		.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        existingOrderItem.setOrder(updatedOrderItem.getOrder());
        existingOrderItem.setBook(updatedOrderItem.getBook());
        existingOrderItem.setQuantity(updatedOrderItem.getQuantity());
        existingOrderItem.setPrice(updatedOrderItem.getPrice());
        return orderItemRepository.save(existingOrderItem);
    }
    
    @DeleteMapping("/{id}")
    public void deleteOrderItem(@PathVariable("id") Long id) {
    	orderItemRepository.deleteById(id);
    }
    
    
    private OrderItemDTO convertToDTO(OrderItem orderItem) {
        OrderItemDTO dto = new OrderItemDTO();
        dto.setId(orderItem.getId());
        dto.setOrderID(orderItem.getOrder().getId());
        dto.setBook(orderItem.getBook().getTitle());
        dto.setQuantity(orderItem.getQuantity());
        dto.setPrice(orderItem.getBook().getPrice());
        return dto;
    }

}


