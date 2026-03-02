package com.project.ecommerce.ServiceImpl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ecommerce.Enum.OrderStatus;
import com.project.ecommerce.Enum.PaymentMethod;
import com.project.ecommerce.Enum.PaymentStatus;
import com.project.ecommerce.Exception.PaymentException;
import com.project.ecommerce.Exception.UserException;
import com.project.ecommerce.Model.Orders;
import com.project.ecommerce.Model.Payment;
import com.project.ecommerce.Model.User;
import com.project.ecommerce.Repository.OrderRepository;
import com.project.ecommerce.Repository.PaymentRepository;
import com.project.ecommerce.Repository.UserRepository;
import com.project.ecommerce.Service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Payment makePayment(Integer orderId, Integer userId) throws PaymentException {

        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new UserException("User not found in the database."));

        Orders order = orderRepository.findById(orderId)
        		.orElseThrow(() -> new UserException("order not found in the database."));;
        if (order == null) {
            throw new PaymentException("Order not found for the given customer.");
        }

        Payment payment = new Payment();
        payment.setPaymentAmount(order.getTotalAmount());
        payment.setPaymentDate(LocalDateTime.now());
        payment.setPaymentMethod(PaymentMethod.UPI);
        payment.setPaymentStatus(PaymentStatus.SUCCESSFUL);
        payment.setUser(existingUser);
    
        payment.setOrder(order);
        paymentRepository.save(payment);
       
        order.setStatus(OrderStatus.SHIPPED);

        // Set the payment for the order
        order.setPayment(payment);
        // Save the changes to the Order entity, including the associated Payment
        orderRepository.save(order);

        existingUser.getPayments().add(payment);
        // Save the changes to the User entity, including the new payment association
        userRepository.save(existingUser);
        // Save the payment to the database
        return  payment;
    }
}
