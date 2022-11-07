package com.cognixia.jump.tcg.requestmodels;

public class UserAndAddressReqModel 
{
	private Long userId;
	private Long addressId;
	
	public UserAndAddressReqModel() {
		this.userId = 0L;
		this.addressId = 0L;;
	}
	
	public UserAndAddressReqModel(Long UserId, Long addressId) {
		super();
		this.userId = UserId;
		this.addressId = addressId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long UserId) {
		this.userId = UserId;
	}
	public Long getAddressId() {
		return addressId;
	}
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	@Override
	public String toString() {
		return "UserAndAddressReqModel [UserId=" + userId + ", addressId=" + addressId + "]";
	}
}
