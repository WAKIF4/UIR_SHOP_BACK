package com.eclipse.UirShop.entitiesDto;

import com.eclipse.UirShop.entities.Payment;
import com.eclipse.UirShop.enums.StatutOrder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class OrderDto {
    private @Getter
    @Setter Long id;
    private @Getter @Setter Date orderDate;
    private @Getter @Setter StatutOrder statutOrder;
    private @Getter @Setter Long totalAmount;
    private @Getter @Setter Payment payment;

    public OrderDto(Long id, Date orderDate, StatutOrder statutOrder, Long totalAmount) {
        this.id = id;
        this.orderDate = orderDate;
        this.statutOrder = statutOrder;
        this.totalAmount = totalAmount;
    }
}
