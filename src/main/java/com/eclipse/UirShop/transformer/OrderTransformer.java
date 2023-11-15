package com.eclipse.UirShop.transformer;

import com.eclipse.UirShop.entities.Order;
import com.eclipse.UirShop.entitiesDto.OrderDto;
import com.eclipse.UirShop.entitiesDto.PaymentDto;

import java.util.List;
import java.util.stream.Collectors;

public class OrderTransformer {
    public static OrderDto convertOrderToDto(Order order) {
        PaymentDto paymentDto = null;
        if (order.getPayment() != null) {
            paymentDto = new PaymentDto(
                    order.getPayment().getId(),
                    order.getPayment().getFirstName(),
                    order.getPayment().getLastName(),
                    order.getPayment().getModePayment(),
                    order.getPayment().getNumberCard(),
                    order.getPayment().getExpirationDate(),
                    order.getPayment().getSecurityCode(),
                    order.getPayment().getOrder()
            );
        }

        return new OrderDto(
                order.getId(),
                order.getOrderDate(),
                order.getStatutOrder(),
                order.getTotalAmount(),
                paymentDto
        );
    }

    public static List<OrderDto> convertOrdersToDtoList(List<Order> orders) {
        return orders.stream()
                .map(OrderTransformer::convertOrderToDto)
                .collect(Collectors.toList());
    }

}
