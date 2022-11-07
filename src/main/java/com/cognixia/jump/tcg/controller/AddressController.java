package com.cognixia.jump.tcg.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.tcg.exceptions.AddressNotFoundException;
//import com.cognixia.jump.exception.InvalidArgumentException;
import com.cognixia.jump.tcg.model.Address;
import com.cognixia.jump.tcg.repository.AddressRepository;
import com.cognixia.jump.tcg.repository.UserRepository;
import com.cognixia.jump.tcg.service.AddressService;


@RequestMapping("/api")
@RestController
public class AddressController 
{

	@Autowired
	AddressService as;
	
	@Autowired
	AddressRepository ar;
	
	@Autowired
	UserRepository ur;
	
	@GetMapping("/address")
	public List<Address> getAllAddress()
	{
		return as.getAllAddress();
	}
	
	@PostMapping("users/address/add")
	public boolean addUser(@RequestBody Address a) //throws InvalidArgumentException
	{
		return as.addUser(a);
	}
	
	@GetMapping("/address/all")
	public ResponseEntity<?> getAllAddresses()
	{
		return new ResponseEntity<>(as.getAllAddress(), HttpStatus.OK);
	}
	
//	@GetMapping("/address/all")
//	public ResponseEntity<?> getAddress()
//	{
//		return new ResponseEntity<>(as.getAllAddress(), HttpStatus.OK);
//	}
	
//	@PutMapping("/users/join/address/{username}/{addressId}")
//	public boolean setAddressUser(@PathVariable String username, @PathVariable Long addressId) throws UsernameNotFoundException,AddressNotFoundException
//	{
//		Optional<User> user = ur.findByUsername(username);
//		if(user.isEmpty())
//		{
//			throw new UsernameNotFoundException("User with username " + username + " not found");
//		}
//		Optional<Address> address = ar.findById(addressId);
//		if(address.isEmpty())
//		{
//			throw new AddressNotFoundException("Address with id " + addressId + " not found");
//		}
//
//
//		user.get().setAddress(address.get());
//		address.get().addUser(user.get());
//		
//
//		
//		
//		return true;
//	}
	
	@GetMapping("/address/{addressId}")
	public String getCurrentAddress(@PathVariable Long addressId) throws AddressNotFoundException
	{
		Optional<Address> address = ar.findById(addressId);
		if(address.isEmpty())
		{
			throw new AddressNotFoundException("Address with id " + addressId + " not found");
		}
		return address.get().toString();
	}
	
}
