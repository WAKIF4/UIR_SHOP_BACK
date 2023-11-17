package com.eclipse.UirShop.entities;

import com.eclipse.UirShop.enums.StatutOrder;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter Long id;

    private @Getter @Setter Date orderDate;
    @Enumerated(EnumType.STRING)
    private @Getter @Setter StatutOrder statutOrder;
    private @Getter @Setter Long totalAmount;
    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private @Getter @Setter Payment payment;
    @OneToMany(mappedBy ="orders")
    private @Setter @Getter List<CommandeProduit> commandeProduits;

    public Order(Long id, Date orderDate, StatutOrder statutOrder, Long totalAmount) {
        this.orderDate = orderDate;
        this.statutOrder = statutOrder;
        this.totalAmount = totalAmount;
    }
}
