package com.eclipse.UirShop.entities;

import com.eclipse.UirShop.enums.ModePayment;
import jakarta.persistence.*;
import jdk.jfr.Name;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "payment")
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter Long id;
    private @Getter @Setter String firstName;
    private @Getter @Setter String lastName;
    @Enumerated(EnumType.STRING)
    private @Getter @Setter ModePayment modePayment;
    private @Getter @Setter String numberCard;
    private @Getter @Setter String expirationDate;
    private @Getter @Setter String securityCode;
    @OneToOne
    @JoinColumn(name = "order_id")
    private @Getter @Setter Order order;

    public Payment(String firstName, String lastName, ModePayment modePayment, String numberCard, String expirationDate, String securityCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.modePayment = modePayment;
        this.numberCard = numberCard;
        this.expirationDate = expirationDate;
        this.securityCode = securityCode;
    }
}
