package com.eclipse.UirShop.controllers;

import com.eclipse.UirShop.entitiesDto.PaymentDto;
import com.eclipse.UirShop.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/all")
    public ResponseEntity<List<PaymentDto>> getAllPayments() {
        List<PaymentDto> paymentDtos = paymentService.getAllPayments();
        return new ResponseEntity<>(paymentDtos, HttpStatus.OK);
    }

    @GetMapping("/by-id/{paymentId}")
    public ResponseEntity<PaymentDto> getPaymentById(@PathVariable Long paymentId) {
        PaymentDto paymentDto = paymentService.getPaymentById(paymentId);
        if (paymentDto != null) {
            return new ResponseEntity<>(paymentDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<PaymentDto> createPayment(@RequestBody PaymentDto paymentDto) {
        PaymentDto createdPayment = paymentService.createPayment(paymentDto);
        return new ResponseEntity<>(createdPayment, HttpStatus.CREATED);
    }

    @PutMapping("/update/{paymentId}")
    public ResponseEntity<PaymentDto> updatePayment(@PathVariable Long paymentId, @RequestBody PaymentDto updatedPaymentDto) {
        PaymentDto updatedPayment = paymentService.updatePayment(paymentId, updatedPaymentDto);
        if (updatedPayment != null) {
            return new ResponseEntity<>(updatedPayment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{paymentId}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long paymentId) {
        paymentService.deletePayment(paymentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
