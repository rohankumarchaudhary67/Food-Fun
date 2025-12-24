package com.foodnfun.backend.service.impl;
import com.foodnfun.backend.entity.Payment;
import com.foodnfun.backend.repository.PaymentRepository;
import com.foodnfun.backend.service.PaymentService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PaymentServiceImpl implements PaymentService{
	
	private final PaymentRepository paymentRepository;
	
	public PaymentServiceImpl(PaymentRepository paymentRepository) {
		this.paymentRepository=paymentRepository;
	}
	
	@Override
	public Payment makePayment(Payment payment) {
		payment.setPaymentDate(LocalDateTime.now());
		payment.setStatus("Success");
		return paymentRepository.save(payment);
	}
}
