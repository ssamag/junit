package com.junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

@DisplayName("Order Index Method Order Demo Class")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OrderIndexMathodOrderTest {
	
	StringBuilder testVariable = new StringBuilder();
	
	@AfterEach
	public void afterEach() {
		System.out.println("The state of variable is: " + testVariable);
	}
	
	@Order(1)
	@Test
	public void testD() {
		System.out.println("Running Test D");
		testVariable.append("1");
	}
	
	@Order(2)
	@Test
	public void testA() {
		System.out.println("Running Test A");
		testVariable.append("2");
	}
	
	@Order(3)
	@Test
	public void testC() {
		System.out.println("Running Test C");
		testVariable.append("3");
	}
	
	@Order(4)
	@Test
	public void testB() {
		System.out.println("Running Test B");
		testVariable.append("4");
	}
	
	

}
