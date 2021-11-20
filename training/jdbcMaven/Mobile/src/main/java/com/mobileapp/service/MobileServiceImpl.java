package com.mobileapp.service;

import java.util.List;

import com.mobileapp.exceptions.IdNotFoundException;
import com.mobileapp.exceptions.MobileNotFoundException;
import com.mobileapp.model.Mobile;
import com.mobileapp.repository.IMobileRepository;
import com.mobileapp.repository.MobileRepositoryImpl;

public class MobileServiceImpl implements IMobileService {
	IMobileRepository mobileRepository=new MobileRepositoryImpl();

	public void addMobile(Mobile mobile) {
		// TODO Auto-generated method stub
		mobileRepository.addMobile(mobile);
		
	}

	public void updateMobile(int mobileId, double price) throws IdNotFoundException {
		// TODO Auto-generated method stub
		mobileRepository.updateMobile(mobileId, price);
		
		
	}

	public Mobile findById(int mobileId) throws IdNotFoundException {
		
		return mobileRepository.findById(mobileId);
	}

	public void deleteMobile(int mobileId) throws IdNotFoundException {
		// TODO Auto-generated method stub
		mobileRepository.deleteMobile(mobileId);
		
	}

	public List<Mobile> findAll() {
		// TODO Auto-generated method stub
		return mobileRepository.findAll();
	}

	public List<Mobile> findByBrand(String brand) throws MobileNotFoundException {
		// TODO Auto-generated method stub
		return mobileRepository.findByBrand(brand);
	}

	public List<Mobile> findByBrandAndModel(String model, String brand) throws MobileNotFoundException {
		// TODO Auto-generated method stub
		
		return mobileRepository.findByBrandAndModel(model, brand);
	}

	public List<Mobile> findByOs(String os) throws MobileNotFoundException {
		// TODO Auto-generated method stub
		return mobileRepository.findByOs(os);
	}

	public List<Mobile> findByLasserPrice(double lowerPrice) throws MobileNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
