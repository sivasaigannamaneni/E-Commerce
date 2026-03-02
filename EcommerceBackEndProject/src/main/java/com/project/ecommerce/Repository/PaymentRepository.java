package com.project.ecommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.ecommerce.Model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
	
}
