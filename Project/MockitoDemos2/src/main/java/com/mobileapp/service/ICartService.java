package com.mobileapp.service;

import java.util.List;

import com.mobileapp.Model.Mobile;
import com.mobileapp.exception.EmptyCartException;

import com.mobileapp.exception.MobileNotFoundException;

public interface ICartService {
	// empty,null,list,exception
	List<Mobile> showCart() throws EmptyCartException;

	void addtoCart(Mobile mobile) throws MobileNotFoundException;

	boolean removeFromCart(Mobile mobile) throws MobileNotFoundException;
}
