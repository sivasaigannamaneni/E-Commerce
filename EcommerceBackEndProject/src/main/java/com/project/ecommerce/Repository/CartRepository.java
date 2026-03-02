package com.project.ecommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.ecommerce.Model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {


}
