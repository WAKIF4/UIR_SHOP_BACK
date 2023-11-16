package com.eclipse.UirShop.entitiesDto;

import com.eclipse.UirShop.entities.Order;
import com.eclipse.UirShop.enums.ModePayment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
public class PaymentDto {
    private @Getter
    @Setter Long id;
    private @Getter @Setter String firstName;
    private @Getter @Setter String lastName;
    private @Getter @Setter ModePayment modePayment;
    private @Getter @Setter String numberCard;
    private @Getter @Setter String expirationDate;
    private @Getter @Setter String securityCode;
    private @Getter @Setter OrderDto orderDto;
    public PaymentDto(Long id, String firstName, String lastName, ModePayment modePayment, String numberCard, String expirationDate, String securityCode, OrderDto orderDto) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.modePayment = modePayment;
        this.numberCard = numberCard;
        this.expirationDate = expirationDate;
        this.securityCode = securityCode;
        this.orderDto = orderDto;
    }
}
