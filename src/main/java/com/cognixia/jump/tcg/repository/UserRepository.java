package com.cognixia.jump.tcg.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cognixia.jump.tcg.model.User;

@Repository 
public interface UserRepository extends JpaRepository<User, Long>
{  //JPA REpsoitory <table name, id/primary key type)

	//cutom query for finding users by userneam
	//importen for sedcurity, security will only know how to find user by username
	//
	
	public Optional<User> findByUsername(String username); 
}
