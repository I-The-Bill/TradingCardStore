package com.cognixia.jump.tcg.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognixia.jump.tcg.model.VanguardCard;

@Repository 
public interface VanguardRepository extends JpaRepository<VanguardCard, Long>
{
	public Optional<VanguardCard> findBysetId(String setId); 
}
