package com.coforge.training.mockitodemo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class MathApplicationTest {
	
	@InjectMocks // It is used to create and inject the mock object
	MathApplication mathApplication;
	
	@Mock // --Create a Mock object to be injected
	CalculatorService calcService;

	@BeforeEach
	void setUp() throws Exception {
		
		mathApplication =new MathApplication();
		MockitoAnnotations.initMocks(this);
	}
	

	@Test
	void testAdd() {
		//add the behavior of Calculator Service to add two numbers
		when(calcService.add(20.0, 30.0)).thenReturn(50.00);
		
		//test the add function
		assertEquals(mathApplication.add(20.0, 30.0),50.0,0);
		
		//verify the behavior
		verify(calcService).add(20.0,30.0);
		System.out.println(verify(calcService).add(20.0, 30.0));
	}
	

	@Test
	void testSubtract() {
		//add the behavior of Calculator Service to add two numbers
				when(calcService.subtract(30.0, 20.0)).thenReturn(10.00);
				
				//test the add function
				assertEquals(mathApplication.subtract(30.0, 20.0),10.0,0);
				
				//verify the behavior
				verify(calcService).subtract(30.0,20.0);
				System.out.println(verify(calcService).subtract(30.0, 20.0));
	}

	@Test
	void testMultiply() {
		//add the behavior of Calculator Service to add two numbers
				when(calcService.multiply(10.0, 10.0)).thenReturn(100.00);
				
				//test the add function
				assertEquals(mathApplication.multiply(10.0, 10.0),100.0,0);
				
				//verify the behavior
				verify(calcService).multiply(10.0,10.0);
				System.out.println(verify(calcService).multiply(10.0, 10.0));
	}

	@Test
	void testDivide() {
		//add the behavior of Calculator Service to add two numbers
				when(calcService.divide(100.0, 10.0)).thenReturn(10.00);
				
				//test the add function
				assertEquals(mathApplication.divide(100.0, 10.0),10.0,0);
				
				//verify the behavior
				verify(calcService).divide(100.0,10.0);
				System.out.println(verify(calcService).divide(100.0, 10.0));
	}

}
