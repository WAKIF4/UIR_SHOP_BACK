package com.eclipse.UirShop.transformer;

import com.eclipse.UirShop.entities.Order;
import com.eclipse.UirShop.entitiesDto.OrderDto;
import com.eclipse.UirShop.entitiesDto.PaymentDto;

import java.util.List;
import java.util.stream.Collectors;

public class OrderTransformer {
    public static OrderDto convertOrderToDto(Order order) {

        return new OrderDto(
                order.getId(),
                order.getOrderDate(),
                order.getStatutOrder(),
                order.getTotalAmount()
        );
    }
    public static Order convertOrderToEntity(OrderDto orderDto) {

        return new Order(
                orderDto.getId(),
                orderDto.getOrderDate(),
                orderDto.getStatutOrder(),
                orderDto.getTotalAmount()
        );
    }



    public static List<OrderDto> convertOrdersToDtoList(List<Order> orders) {
        return orders.stream()
                .map(OrderTransformer::convertOrderToDto)
                .collect(Collectors.toList());
    }


}
