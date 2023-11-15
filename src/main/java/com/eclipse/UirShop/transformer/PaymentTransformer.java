package com.eclipse.UirShop.transformer;

import com.eclipse.UirShop.entities.Payment;
import com.eclipse.UirShop.entitiesDto.PaymentDto;

import java.util.List;
import java.util.stream.Collectors;

public class PaymentTransformer {
    public static PaymentDto convertPaymentToDto(Payment payment) {
        return new PaymentDto(
                payment.getId(),
                payment.getFirstName(),
                payment.getLastName(),
                payment.getModePayment(),
                payment.getNumberCard(),
                payment.getExpirationDate(),
                payment.getSecurityCode(),
                payment.getOrder()
        );
    }

    public static List<PaymentDto> convertPaymentsToDtoList(List<Payment> payments) {
        return payments.stream()
                .map(PaymentTransformer::convertPaymentToDto)
                .collect(Collectors.toList());
    }
}
