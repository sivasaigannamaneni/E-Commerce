package com.project.ecommerce.Service;

import com.project.ecommerce.Exception.PaymentException;
import com.project.ecommerce.Model.Payment;

public interface PaymentService {
	
	 Payment makePayment(Integer orderId,Integer userId) throws PaymentException;
}
