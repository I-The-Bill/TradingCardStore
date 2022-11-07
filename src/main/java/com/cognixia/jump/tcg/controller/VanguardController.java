package com.cognixia.jump.tcg.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.tcg.exceptions.ResourceAlreadyExistException;
import com.cognixia.jump.tcg.exceptions.ResourceNotFoundException;
import com.cognixia.jump.tcg.model.VanguardCard;
import com.cognixia.jump.tcg.repository.VanguardRepository;
import com.cognixia.jump.tcg.service.VanguardService;

@RestController
@RequestMapping("/api")
public class VanguardController 
{
	
	@Autowired
	VanguardService vgs;
	
	@Autowired
	VanguardRepository vgr;
	
	@GetMapping("/vanguard/testing")
	public String getAccess()
	{
		return "Hello, Vanguard user Works";
	}
	
	@GetMapping("/admin/vanguard/testing")
	public String getAccess2()
	{
		return "Hello, Vanguard admin Works";
	}
	
	@GetMapping("/vanguard/all")
	public List<VanguardCard> getAllVanGuardCards()
	{

		return vgs.getAllVanguardCards();
	}
	
	@PostMapping("/admin/vanguard/add")
	public ResponseEntity<?> createVanguardCard(@RequestBody VanguardCard vgc) throws ResourceAlreadyExistException, ResourceNotFoundException
	{
		Optional<VanguardCard> isExistingCard = vgr.findBysetId(vgc.getSetId());
		if(!isExistingCard.isEmpty())
		{
			throw new ResourceAlreadyExistException("Card with Set Id " + vgc.getSetId() + " already exist");
		}
		vgc.setId(null);
		VanguardCard made = vgr.save(vgc);
		
		
		return ResponseEntity.status(201).body(made);
	}
	
	
}
