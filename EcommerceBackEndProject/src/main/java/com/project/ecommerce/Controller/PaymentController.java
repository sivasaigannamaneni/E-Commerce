package com.project.ecommerce.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.ecommerce.Model.Payment;
import com.project.ecommerce.Service.PaymentService;

@RestController

@RequestMapping("/ecom/order-payments")
public class PaymentController {

	@Autowired
	private  PaymentService paymentService;

	@PostMapping("/makePayment")
	public ResponseEntity<Payment> makePayment(@RequestParam Integer orderId, @RequestParam Integer userId
			) {
		Payment payment = paymentService.makePayment(orderId, userId);
		return ResponseEntity.ok(payment);
	}
}
