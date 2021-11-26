package com.mobileapp.testcases;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mobileapp.Model.Mobile;
import com.mobileapp.exception.EmptyCartException;

import com.mobileapp.exception.MobileNotFoundException;
import com.mobileapp.service.CartDetails;
import com.mobileapp.service.ICartService;

@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
class CartDetailsTest {
	@Mock
	ICartService cartService;
	@InjectMocks
	CartDetails cartDetails;
	Mobile mobile1, mobile2, mobile3, mobile4, mobile5, mobile6;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		mobile1 = new Mobile("S20", "Samsung", 1, 20000);
		mobile2 = new Mobile("X123", "Vivo", 2, 2000);
		mobile3 = new Mobile("M12", "Samsung", 3, 120000);
		mobile4 = new Mobile("ipHhone", "Apple", 4, 200000);
		mobile5 = new Mobile("A52", "Samsung", 5, 20000);
		mobile6 = new Mobile("V09", "Vivo", 6, 42000);
		List<Mobile> mobileData = Arrays.asList(mobile1, mobile2, mobile3, mobile4, mobile5, mobile6);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@DisplayName("Checking with Addcart")
	void tesAddCart() throws MobileNotFoundException {
		doNothing().when(cartService).addtoCart(mobile1);
		String actual = cartDetails.addtoCart(mobile1);
		String expected = "Added successfully";
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Checking with exception")
	void testAddCartException() throws MobileNotFoundException {
		doThrow(new MobileNotFoundException("Invailid mobile")).when(cartService).addtoCart(mobile1);
		assertThrows(MobileNotFoundException.class, () -> cartDetails.addtoCart(mobile1));
	}

	@Test
	@DisplayName("Checking with cart")
	void testShowCart() throws EmptyCartException {
		List<Mobile> expectedMobile = Arrays.asList(mobile3, mobile1, mobile2);
		doReturn(expectedMobile).when(cartService).showCart();
		List<Mobile> actualMobile = cartDetails.showCart();
		assertEquals(expectedMobile, actualMobile, "not equal");
	}

	@Test
	@DisplayName("Checking with Empty")
	void testShowCartEmpty() throws EmptyCartException {
		when(cartService.showCart()).thenThrow(new EmptyCartException());
		assertThrows(EmptyCartException.class, () -> cartDetails.showCart());
	}

	@Test
	@DisplayName("Checking with Null cart")
	void testShowCartNull() throws MobileNotFoundException, EmptyCartException {
		doReturn(null).when(cartService).showCart();
		assertNull(cartDetails.showCart());
	}
	
	}
