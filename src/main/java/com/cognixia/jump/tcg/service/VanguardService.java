package com.cognixia.jump.tcg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognixia.jump.tcg.exceptions.ResourceNotFoundException;
import com.cognixia.jump.tcg.model.User;
import com.cognixia.jump.tcg.model.VanguardCard;
import com.cognixia.jump.tcg.repository.VanguardRepository;

@Service
public class VanguardService 
{
	
	@Autowired
	VanguardRepository vgr;
	
	public List<VanguardCard> getAllVanguardCards()
	{
		return vgr.findAll();
	}
	
	public Optional<VanguardCard> findBysetId(String setId) throws ResourceNotFoundException {
		
		Optional<VanguardCard> search = vgr.findBysetId(setId);
		
		if (search.isEmpty()) {
			throw new ResourceNotFoundException("Card with: " + setId);
		}
		
		return search;
	}
	
	public boolean addVanguardCard(VanguardCard vgc) {
		
		if (vgc != null) {
			
			vgr.save(vgc);
			return true;
			
		}
		
		return false;
	}

//	public List<VanguardCard> findByCostGreaterThen(double cost)
//	{
//		return vgr.findByCostGreaterThen();
//	}
	

}
