package com.mobileapp.service;

import java.util.List;
import java.util.stream.Collectors;

import com.mobileapp.Model.Mobile;
import com.mobileapp.exception.EmptyCartException;

import com.mobileapp.exception.MobileNotFoundException;

public class CartDetails {
	ICartService cartService;

	public void setCartService(ICartService cartSerice) {
		this.cartService = cartSerice;
	}

	public List<Mobile> showCart() throws EmptyCartException {
		List<Mobile> mobileList = cartService.showCart();
		if (mobileList != null) {
			return mobileList.stream().sorted((item1, item2) -> item2.getMobileId().compareTo(item1.getMobileId()))
					.collect(Collectors.toList());
		}

		return mobileList;
	}

	public String addtoCart(Mobile mobile) throws MobileNotFoundException {
		cartService.addtoCart(mobile);
		return "Added successfully";
	}

	public boolean removeFromCart(Mobile mobile) throws MobileNotFoundException {
		return false;
	}
	


}
