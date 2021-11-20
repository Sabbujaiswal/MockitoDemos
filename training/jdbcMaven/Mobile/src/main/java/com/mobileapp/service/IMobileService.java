package com.mobileapp.service;

import java.util.List;

import com.mobileapp.exceptions.IdNotFoundException;
import com.mobileapp.exceptions.MobileNotFoundException;
import com.mobileapp.model.Mobile;

public interface IMobileService {
	//admin methods;
		void addMobile(Mobile mobile);
		void updateMobile(int mobileId,double price)throws IdNotFoundException;
		Mobile findById(int mobileId)throws IdNotFoundException;
		void deleteMobile(int mobileId)throws IdNotFoundException;
		
		
		//called by users;
		List<Mobile> findAll();
		List<Mobile> findByBrand(String brand)throws MobileNotFoundException;
		List<Mobile> findByBrandAndModel(String model,String brand)throws MobileNotFoundException;
		List<Mobile> findByOs(String os)throws MobileNotFoundException;
		List<Mobile> findByLasserPrice(double lowerPrice)throws MobileNotFoundException; 
		

}
