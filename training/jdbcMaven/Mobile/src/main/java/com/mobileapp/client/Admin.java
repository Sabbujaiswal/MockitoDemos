package com.mobileapp.client;

import com.mobileapp.exceptions.IdNotFoundException;
import com.mobileapp.exceptions.MobileNotFoundException;
import com.mobileapp.model.Mobile;
import com.mobileapp.repository.IMobileRepository;
import com.mobileapp.repository.MobileRepositoryImpl;
import com.mobileapp.service.IMobileService;
import com.mobileapp.service.MobileServiceImpl;

public class Admin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Mobile mobile = new Mobile("3pro","Realme","64GB","Android",14000);
		IMobileService mobileService=new MobileServiceImpl();
		//mobileService.addMobile(mobile);
//		try {
//			mobileService.updateMobile(2, 12000);
//		} catch (IdNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			System.out.println(mobileService.findById(2));
//			
//		} catch (IdNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//try {
//	mobileService.deleteMobile(1);
//} catch (IdNotFoundException e) {
//	// TODO Auto-generated catch block
//	e.printStackTrace();
//}
//mobileService.findAll();
//		try {
//			mobileService.findByBrand("Realme");
//		} catch (MobileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
		//}
//		
try {
	System.out.println(mobileService.findByOs("Android"));
} catch (MobileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}
	
	}
