package com.project.ecommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.ecommerce.Model.ShippingDetails;

public interface ShippingRepository extends JpaRepository<ShippingDetails, Integer> {

}
