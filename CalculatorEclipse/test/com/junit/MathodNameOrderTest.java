package com.junit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@DisplayName("Method Name Order Demo Class")
@TestMethodOrder(MethodOrderer.MethodName.class)
public class MathodNameOrderTest {
	
	@Test
	public void testD() {
		System.out.println("Running Test D");
	}
	
	@Test
	public void testA() {
		System.out.println("Running Test A");
	}
	@Test
	public void testC() {
		System.out.println("Running Test C");
	}
	
	@Test
	public void testB() {
		System.out.println("Running Test B");
	}
	
	@Test
	public void testa() {
		System.out.println("Running Test a");
	}
	
	

}
