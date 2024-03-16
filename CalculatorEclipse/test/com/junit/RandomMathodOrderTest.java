package com.junit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@DisplayName("Random Method Order Demo Class")
@TestMethodOrder(MethodOrderer.Random.class)
public class RandomMathodOrderTest {
	
	@Test
	public void testA() {
		System.out.println("Running Test A");
	}
	
	@Test
	public void testB() {
		System.out.println("Running Test B");
	}
	
	@Test
	public void testC() {
		System.out.println("Running Test C");
	}
	
	@Test
	public void testD() {
		System.out.println("Running Test D");
	}

}
