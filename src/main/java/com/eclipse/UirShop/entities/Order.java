package com.eclipse.UirShop.entities;

import com.eclipse.UirShop.enums.StatutOrder;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "orders")
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter Long id;
    @Temporal(TemporalType.TIME)
    private @Getter @Setter Date orderDate;
    @Enumerated(EnumType.STRING)
    private @Getter @Setter StatutOrder statutOrder;
    private @Getter @Setter Long totalAmount;
    @OneToOne(mappedBy = "order")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private @Getter @Setter Payment payment;

    public Order(Long id, Date orderDate, StatutOrder statutOrder, Long totalAmount) {
        this.orderDate = orderDate;
        this.statutOrder = statutOrder;
        this.totalAmount = totalAmount;
    }
}
