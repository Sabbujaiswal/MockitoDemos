package com.mobileapp.service;

import java.util.List;

import com.mobileapp.Model.Mobile;

import com.mobileapp.exception.MobileNotFoundException;

public interface IMobileService {
	List<Mobile> showMobiles();

	List<Mobile> findMobileByBrand(String brand) throws MobileNotFoundException;

	Mobile findMobileById(int mobileId) throws MobileNotFoundException;

}
