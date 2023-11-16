package com.eclipse.UirShop.transformer;

import com.eclipse.UirShop.entities.Order;
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
                OrderTransformer.convertOrderToDto(payment.getOrder())
        );

    }

    public static Payment toEntity(PaymentDto paymentDto) {

        return new Payment(
                paymentDto.getFirstName(),
                paymentDto.getLastName(),
                paymentDto.getModePayment(),
                paymentDto.getNumberCard(),
                paymentDto.getExpirationDate(),
                paymentDto.getSecurityCode(),
                paymentDto.getOrderDto()
        );

    }

    public static List<PaymentDto> convertPaymentsToDtoList(List<Payment> payments) {
        return payments.stream()
                .map(PaymentTransformer::convertPaymentToDto)
                .collect(Collectors.toList());
    }

}
