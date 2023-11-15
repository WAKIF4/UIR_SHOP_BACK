package com.eclipse.UirShop.services;

import com.eclipse.UirShop.entities.Order;
import com.eclipse.UirShop.entitiesDto.OrderDto;
import com.eclipse.UirShop.repositories.IOrderRepository;
import com.eclipse.UirShop.transformer.OrderTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private IOrderRepository orderRepository;

    public List<OrderDto> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return OrderTransformer.convertOrdersToDtoList(orders);
    }

    public OrderDto getOrderById(Long orderId) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        return orderOptional.map(OrderTransformer::convertOrderToDto).orElse(null);
    }

    public OrderDto createOrder(OrderDto orderDto) {
        Order order = new Order(
                orderDto.getOrderDate(),
                orderDto.getStatutOrder(),
                orderDto.getTotalAmount()
        );

        order.getPayment();

        orderRepository.save(order);
        return OrderTransformer.convertOrderToDto(order);
    }

    public OrderDto updateOrder(Long orderId, OrderDto updatedOrderDto) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        if (orderOptional.isPresent()) {
            Order existingOrder = orderOptional.get();
            existingOrder.setOrderDate(updatedOrderDto.getOrderDate());
            existingOrder.setStatutOrder(updatedOrderDto.getStatutOrder());
            existingOrder.setTotalAmount(updatedOrderDto.getTotalAmount());

            // Mise à jour des informations de paiement si nécessaire

            orderRepository.save(existingOrder);
            return OrderTransformer.convertOrderToDto(existingOrder);
        } else {
            // Gérer le cas où l'ordre n'est pas trouvé
            return null;
        }
    }

    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }
}
