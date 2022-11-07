package com.cognixia.jump.tcg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.cognixia.jump.exception.InvalidArgumentException;
import com.cognixia.jump.tcg.model.Address;
import com.cognixia.jump.tcg.repository.AddressRepository;

@Service
public class AddressService 
{
	public static List<Address> Addresses = new ArrayList<>();
	
	@Autowired
	AddressRepository ar;
	
	public List<Address> getAllAddress()
	{
		return ar.findAll();
	}
	
	public boolean addUser(Address toAdd) //throws InvalidArgumentException
	{
		if (toAdd!= null)
		{
			ar.save(toAdd);
			return true;
		}
		else
		{
			//throw new InvalidArgumentException("The address to be added is invalid");
			return false;
		}
	}
}
