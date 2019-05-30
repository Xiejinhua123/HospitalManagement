package cn.vote.action;

import java.util.List;

import cn.vote.entity.UserAddress;
import cn.vote.service.UserAddressService;

public class UserAddressAction extends ActionBase{

	private UserAddressService userAddressService;
	private UserAddress address;
	private String addressId;
	
	public void addAddress()
	{
		try{
			userAddressService.add(address);
			super.setJson("success");
		}catch (Exception e) {
			super.setJson("error");
			e.printStackTrace();
		}finally{
			super.witerJson();
		}
	}
	public void delAddress()
	{
		try{ 
			userAddressService.delUserAddress(addressId);
			super.setJson("success");
		}catch (Exception e) {
			super.setJson("error");
			e.printStackTrace();
		}finally{
			super.witerJson();
		}
	}
	public void updateAddress()
	{
		try{
			userAddressService.updateUserAddress(address);
			super.setJson("success");
		}catch (Exception e) {
			super.setJson("error");
			e.printStackTrace();
		}finally{
			super.witerJson();
		}
	}
	public void getAddressById()
	{
		try{
			UserAddress ua=	userAddressService.getUserAddressById(addressId);
			if(ua!=null) super.setJson(ua);
			else super.setJson("fail");
		}catch (Exception e) {
			e.printStackTrace();
			super.setJson("error");
		}finally{
			super.witerJson();
		}
	}
	public void getAllAddress()
	{
		try{
			List<UserAddress> ua=	userAddressService.getAll();
			if(ua!=null) super.setJson(ua);
			else super.setJson("null");
		}catch (Exception e) {
			e.printStackTrace();
			super.setJson("error");
		}finally{
			super.witerJson();
		}
	}
	public UserAddressService getUserAddressService() {
		return userAddressService;
	}
	public void setUserAddressService(UserAddressService userAddressService) {
		this.userAddressService = userAddressService;
	}
	public UserAddress getAddress() {
		return address;
	}
	public void setAddress(UserAddress address) {
		this.address = address;
	}
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	
	
	
	
}
