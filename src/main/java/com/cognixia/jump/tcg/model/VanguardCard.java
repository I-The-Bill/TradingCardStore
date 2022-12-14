package com.cognixia.jump.tcg.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.validator.constraints.Range;

@Entity
public class VanguardCard implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // incrementation will use auto_increment
	@Column(name = "vgc_id")
	private Long id;

	@Column(unique = true, nullable = false)
	private String setId;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String clan_Nation;

	@Column(nullable = false)
	@Range(min = 0, max=5)
	private int grade;

	@Column(nullable = false)
	@Range(min = 0)
	private int power;
	
	@Column(nullable = true)
	@Range(min = 0)
	private int shield;
	
	//@Column(nullable = true,length =1500)
	//private String skill;
	
	@Column(nullable = false)
	private double cost;
	
	@Column(nullable = false)
	@Range(min = 0)
	private int inventoryCount;

	public VanguardCard()
	{
		super();
		this.id = 0L;
		this.setId = "0000";
		this.name = "N/A";
		this.clan_Nation = "N/A";
		this.grade = 0;
		this.power = 0;
		this.shield = 0;
		//this.skill = "";
		this.cost = 0.0;
		this.inventoryCount = 0;
	}
	
		
	public VanguardCard(Long id, String setId, String name, String clan_Nation, @Range(min = 0, max = 5) int grade,
			@Range(min = 0) int power, @Range(min = 0) int shield, String skill, @Range(min = 0) double cost,
			@Range(min = 0) int inventoryCount) {
		super();
		this.id = id;
		this.setId = setId;
		this.name = name;
		this.clan_Nation = clan_Nation;
		this.grade = grade;
		this.power = power;
		this.shield = shield;
		//this.skill = skill;
		this.cost = cost;
		this.inventoryCount = inventoryCount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSetId() {
		return setId;
	}

	public void setSetId(String setId) {
		this.setId = setId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClan_Nation() {
		return clan_Nation;
	}

	public void setClan_Nation(String clan_Nation) {
		this.clan_Nation = clan_Nation;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getShield() {
		return shield;
	}

	public void setShield(int shield) {
		this.shield = shield;
	}

//	public String getSkill() {
//		return skill;
//	}
//
//	public void setSkill(String skill) {
//		this.skill = skill;
//	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getInventoryCount() {
		return inventoryCount;
	}

	public void setInventoryCount(int inventoryCount) {
		this.inventoryCount = inventoryCount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(clan_Nation, cost, grade, id, inventoryCount, name, power, setId, shield);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VanguardCard other = (VanguardCard) obj;
		return Objects.equals(clan_Nation, other.clan_Nation) && cost == other.cost && grade == other.grade
				&& Objects.equals(id, other.id) && inventoryCount == other.inventoryCount
				&& Objects.equals(name, other.name) && power == other.power && Objects.equals(setId, other.setId)
				&& shield == other.shield;// && Objects.equals(skill, other.skill);
	}

	@Override
	public String toString() {
		return "VanguardCard [id=" + id + ", setId=" + setId + ", name=" + name + ", clan_Nation=" + clan_Nation
				+ ", grade=" + grade + ", power=" + power + ", shield=" + shield + ", cost=" + cost
				+ ", inventoryCount=" + inventoryCount + "]";
	}

//	@ManyToOne
//	@JoinColumn(name = "address_id")
//	private Address address;
	
	
//    "id": 1,
//    "setId": "V-BT04",
//    "name": "Fantasy Petal Storm, Shirayuki",
//    "clan_Nation": "Murakumo",
//    "grade": 3,
//    "power": 12000,
//    "shield": 0,
//    "cost": 0,
//    "inventoryCount": 17
	
//    "id": 2,
//    "setId": "V-TD01/004",
//    "name": "Blaster Blade",
//    "clan_Nation": "Royal Paladin",
//    "grade": 2,
//    "power": 10000,
//    "shield": 5000,
//    "cost": 0,
//    "inventoryCount": 20
	
//    "id": 4,
//    "setId": "V-TD01/005EN",
//    "name": "Blaster Blade",
//    "clan_Nation": "Royal Paladin",
//    "grade": 2,
//    "power": 10000,
//    "shield": 5000,
//    "cost": 0.48,
//    "inventoryCount": 20
	
//	   "id": 2,
//	   "setId": "D-BT06/FFR01EN",
//	   "name": "Chakrabarthi Phoenix Dragon, Nirvana Jheva",
//	   "clan_Nation": "Dragon Empire",
//	   "grade": 3,
//	   "power": 13000,
//	   "shield": 0,
//	   "cost": 95.0,
//	   "inventoryCount": 19
}
