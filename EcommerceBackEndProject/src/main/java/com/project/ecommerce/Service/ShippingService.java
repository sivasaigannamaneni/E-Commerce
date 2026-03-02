package com.project.ecommerce.Service;

import com.project.ecommerce.Exception.ShippingException;
import com.project.ecommerce.Model.ShippingDetails;
import com.project.ecommerce.ModelDTO.ShippingDTO;

public interface ShippingService {
	
  public ShippingDetails setShippingDetails(Integer orderId,Integer shipperId,ShippingDetails shippingDetails) throws ShippingException;
  
  public ShippingDetails updateShippingAddress(Integer shippingId,ShippingDTO shippingDTO)throws ShippingException;
  
  public void deleteShippingDetails(Integer shippingId)throws ShippingException;
  
  
}
