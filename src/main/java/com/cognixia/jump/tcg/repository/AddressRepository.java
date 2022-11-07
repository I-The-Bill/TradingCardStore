package com.cognixia.jump.tcg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognixia.jump.tcg.model.Address;
import com.cognixia.jump.tcg.model.User;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long>
{
//	@Query("SELECT u "
//	+ "FROM Address u "
//	+ "WHERE u.streetNumber = :streetNumber AND"
//	+ "u.streetName = :streetName AND"
//	+ "u.suiteNumber = :suiteNumber AND"
//	+ "u.zipOrPostalCode = :zipOrPostalCode")
//public boolean existsByStreetNumberAndStreetNameAndSuiteNumberAndZipOrPostalCode(
//	@Param("streetNumber")String streetNumber, 
//	@Param("streetName")String streetName, 
//	@Param("suiteNumber")String suiteNumber, 
//	@Param("zipOrPostalCode")String zipOrPostalCode);
}
