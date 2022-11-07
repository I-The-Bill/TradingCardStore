package com.cognixia.jump.tcg.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.tcg.exceptions.AddressNotFoundException;
import com.cognixia.jump.tcg.exceptions.ResourceNotFoundException;
import com.cognixia.jump.tcg.model.Address;
import com.cognixia.jump.tcg.model.User;
import com.cognixia.jump.tcg.repository.AddressRepository;
import com.cognixia.jump.tcg.repository.UserRepository;
import com.cognixia.jump.tcg.requestmodels.UserAndAddressReqModel;
import com.cognixia.jump.tcg.service.UserService;


@RestController
@RequestMapping("/api")
public class UserController 
{
	@Autowired
	UserRepository ur;
	
	@Autowired
	AddressRepository ar;
	
	@Autowired
	UserService us;
	
	@Autowired
	PasswordEncoder encoder;
	
	@GetMapping("/testing")
	public String getHello()
	{
		return "Hello, This Works";
	}
	
	@GetMapping("/user")
	public List<User> getUsers()
	{
		return us.getAllUsers();
	}
	
	@PostMapping("/users/user")
	public ResponseEntity<?> createUser(@RequestBody User user)
	{
		user.setId(null);
		user.setPassword(encoder.encode(user.getPassword())); //ensures each new users password gets encoded
		User made = ur.save(user);
		
		
		return ResponseEntity.status(201).body(made);
	}
	
	@GetMapping("/user/{username}")
	public String getUser(@PathVariable String username) throws ResourceNotFoundException
	{
		Optional<User> user = us.findByUsername(username);
		if(user.isEmpty())
		{
			throw new UsernameNotFoundException("User with username " + username + " not found");
		}
		return user.get().toString();
	}
	
	@GetMapping("/users/user/address/{username}")
	public String getAddress(@PathVariable String username) throws AddressNotFoundException
	{
		Optional<User> user = ur.findByUsername(username);
		if(user.isEmpty())
		{
			throw new UsernameNotFoundException("User with username " + username + " not found");
		}
		if(user.get().getAddress() == null)
		{
			throw new AddressNotFoundException("Address for user " + username + " is null");
		}
		return user.get().getAddress().toString();
		
		
	}
	
//	@PutMapping("/users/join/address/{username}")
//	public boolean setAddressUser(@PathVariable String username, @RequestBody Address address) throws UsernameNotFoundException,AddressNotFoundException
//	{
//		Optional<User> user = ur.findByUsername(username);
//		if(user.isEmpty())
//		{
//			throw new UsernameNotFoundException("User with username " + username + " not found");
//		}
////		Optional<Address> address = ar.findById(addressId);
////		if(address.isEmpty())
////		{
////			throw new AddressNotFoundException("Address with id " + addressId + " not found");
////		}
//
//
//		user.get().setAddress(address);//address.get());
//		//address.get().addUser(user.get());
		
	//return true;
	//}
	
		@PutMapping("/users/addaddress")
		public ResponseEntity<?> addStudent(@RequestBody UserAndAddressReqModel model) throws ResourceNotFoundException 
		{
			if (us.joinUserAndsAddress(model.getAddressId(), model.getUserId())) 
			{
				return new ResponseEntity<>("updated User", HttpStatus.CREATED);
			}
		return new ResponseEntity<>("Failed to update User.", HttpStatus.NOT_ACCEPTABLE);
		}
		
		
		
	
}

