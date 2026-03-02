package com.project.ecommerce.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.ecommerce.Exception.UserException;
import com.project.ecommerce.Model.User;
import com.project.ecommerce.ModelDTO.AdminDTO;
import com.project.ecommerce.ModelDTO.CustomerDTO;
import com.project.ecommerce.ModelDTO.UserDTO;


@Service
public interface UserService {
	
	
	
	public User getUserByEmailId(String emailId)throws UserException;

	public User addUser(CustomerDTO customer)  throws UserException;
	
	public User addUserAdmin(AdminDTO admin	)  throws UserException;

	public User changePassword(Integer userId, UserDTO customer)  throws UserException;

	public String deactivateUser(Integer userId) throws UserException;

	public User getUserDetails(Integer userId)throws UserException;

	public List<User> getAllUserDetails() throws UserException;
}
