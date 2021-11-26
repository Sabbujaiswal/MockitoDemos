package com.mobileapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.mobileapp.Model.Mobile;
import com.mobileapp.exception.MobileNotFoundException;



public class OrderDetails {
	IMobileService mobileService;

	public void setMobileService(IMobileService mobileService) {
		this.mobileService = mobileService;
	}

	public String orderMobile(int mobileId) {
		Mobile mobile = null;
		
		try {
			mobile = mobileService.findMobileById(mobileId);
			
		}catch(MobileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		if(mobile == null || (mobile.getBrand() == null && mobile.getMobileId() == null)) 
			return "Mobile Not Ordered";
			else
		
		
		return "mobile ordered";
	
	}

	public List<Mobile> showMobiles(String brand) throws MobileNotFoundException {
		List<Mobile> mobileList = new ArrayList<>();
		try {
			mobileList = mobileService.findMobileByBrand(brand);
		} catch (MobileNotFoundException e) {

			throw e;
		}

		if (mobileList != null) {
			return mobileList.stream().sorted((item1, item2) -> item1.getMobileId().compareTo(item2.getMobileId()))
					.collect(Collectors.toList());
		} else {
			return mobileList;
		}

	}

}
