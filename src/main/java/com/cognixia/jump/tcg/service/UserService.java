package com.cognixia.jump.tcg.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognixia.jump.tcg.exceptions.ResourceNotFoundException;
import com.cognixia.jump.tcg.model.Address;
import com.cognixia.jump.tcg.model.User;
import com.cognixia.jump.tcg.repository.AddressRepository;
import com.cognixia.jump.tcg.repository.UserRepository;

// This is also a specific type of @component
@Service
public class UserService {
	
	@Autowired
	UserRepository ur;
	
	@Autowired
	AddressRepository ar;

	//logic abstracted from controller to return all Users
	public List<User> getAllUsers(){

		return ur.findAll();
	}
	
	//List Users by first and last name
	public Optional<User> findByUsername(String username) 
			throws ResourceNotFoundException {
		
		Optional<User> search = ur.findByUsername(username);
		
		if (search.isEmpty()) {
			throw new ResourceNotFoundException("User: " + username);
		}
		
		return search;
	}
	
	//add a User
	public boolean addUser(User User) {
		
		if (User != null) {
			
			ur.save(User);
			return true;
			
		}
		
		return false;
	}
	
	
	public boolean joinUserAndsAddress(Long addressId, Long UserId) throws ResourceNotFoundException {
			
			Optional<Address> addressAdd = ar.findById(addressId);
			Optional<User> UserAdd = ur.findById(UserId);
			
			if (addressAdd.isPresent() && UserAdd.isPresent()) 
			{
				addAddressToUser(addressId,UserId);
				addUserToAddress(addressId,UserId);
				return true;
			}
//			else if(addressAdd.isPresent())
//			{
//				throw new ResourceNotFoundException("Address is Present");
//			}
//			else if(UserAdd.isPresent())
//			{
//				throw new ResourceNotFoundException("User is Present");
//			}
			else 
			{
				return false;
			}
	}
	
	public boolean addAddressToUser(Long addressId, Long UserId) throws ResourceNotFoundException {
		
		Optional<Address> addressAdd = ar.findById(addressId);
		Optional<User> UserAdd = ur.findById(UserId);
		
		if (addressAdd.isPresent() && UserAdd.isPresent()) 
		{
			
			//addressAdd.get().addUser(UserAdd.get());
			UserAdd.get().setAddress(addressAdd.get());
			
			//ar.save(addressAdd.get());
			ur.save(UserAdd.get());
			
			return true;
		}
//		else if(addressAdd.isPresent())
//		{
//			throw new ResourceNotFoundException("Address is Present");
//		}
//		else if(UserAdd.isPresent())
//		{
//			throw new ResourceNotFoundException("User is Present");
//		}
		else 
		{
			return false;
		}
		
		//return false;
	}
	
	public boolean addUserToAddress(Long addressId, Long UserId) throws ResourceNotFoundException {
		
		Optional<Address> addressAdd = ar.findById(addressId);
		Optional<User> UserAdd = ur.findById(UserId);
		
		if (addressAdd.isPresent() && UserAdd.isPresent()) 
		{
			
			addressAdd.get().addUser(UserAdd.get());
			//UserAdd.get().setAddress(addressAdd.get());
			
			ar.save(addressAdd.get());
			//ur.save(UserAdd.get());
			
			return true;
		}
//		else if(addressAdd.isPresent())
//		{
//			throw new ResourceNotFoundException("Address is Present");
//		}
//		else if(UserAdd.isPresent())
//		{
//			throw new ResourceNotFoundException("User is Present");
//		}
		else 
		{
			return false;
		}
		
		//return false;
	}


	public boolean deleteUserByName(String username) {
		
		Optional<User> found = ur.findByUsername(username);
		
		if (!found.isEmpty()) {
			ur.delete(found.get());
			return true;
		}
		
		return false;
		
	}
	
	
	
}
