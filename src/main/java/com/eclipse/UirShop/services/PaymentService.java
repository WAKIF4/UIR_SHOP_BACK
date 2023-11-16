package com.eclipse.UirShop.services;

import com.eclipse.UirShop.entities.Order;
import com.eclipse.UirShop.entities.Payment;
import com.eclipse.UirShop.entitiesDto.PaymentDto;
import com.eclipse.UirShop.exceptions.NotFoundException;
import com.eclipse.UirShop.repositories.IOrderRepository;
import com.eclipse.UirShop.repositories.IPaymentRepository;
import com.eclipse.UirShop.transformers.PaymentTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
    @Autowired
    private IPaymentRepository paymentRepository;
    @Autowired
    private IOrderRepository orderRepository;

    public List<PaymentDto> getAllPayments() {
        List<Payment> payments = paymentRepository.findAll();
        return PaymentTransformer.convertPaymentsToDtoList(payments);
    }

    public PaymentDto getPaymentById(Long paymentId) {
        Optional<Payment> paymentOptional = paymentRepository.findById(paymentId);
        return paymentOptional.map(PaymentTransformer::convertPaymentToDto).orElse(null);
    }

    public PaymentDto createPayment(PaymentDto paymentDto) {

            Order order = orderRepository.findById(paymentDto.getOrderDto().getId()).orElseThrow(()->{
                return new NotFoundException("Order not found");
            });

            Payment payment = PaymentTransformer.toEntity(paymentDto);
            payment.setOrder(order);

            paymentRepository.save(payment);

            return PaymentTransformer.convertPaymentToDto(payment);


    }

    public PaymentDto updatePayment(Long paymentId, PaymentDto updatedPaymentDto) {
        Optional<Payment> paymentOptional = paymentRepository.findById(paymentId);
        if (paymentOptional.isPresent()) {
            Payment existingPayment = paymentOptional.get();
            existingPayment.setFirstName(updatedPaymentDto.getFirstName());
            existingPayment.setLastName(updatedPaymentDto.getLastName());
            existingPayment.setModePayment(updatedPaymentDto.getModePayment());
            existingPayment.setNumberCard(updatedPaymentDto.getNumberCard());
            existingPayment.setExpirationDate(updatedPaymentDto.getExpirationDate());
            existingPayment.setSecurityCode(updatedPaymentDto.getSecurityCode());

            paymentRepository.save(existingPayment);
            return PaymentTransformer.convertPaymentToDto(existingPayment);
        } else {
            return null;
        }
    }

//    public void deletePayment(Long paymentId) {
//        paymentRepository.deleteById(paymentId);
//    }
}
