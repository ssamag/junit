package com.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Test class to test math operations")
class CalculatorTest {

	private Calculator calculator;

	@BeforeAll
	public static void setUp() {
		System.out.println("Running @BeforeAll");
	}

	@AfterAll
	public static void cleanUp() {
		System.out.println("Running @AfterAll");
	}

	@BeforeEach
	public void beforeEachTestMethod() {
		calculator = new Calculator();
		System.out.println("Running @BeforeEach");
	}

	@AfterEach
	public void afterEachTestMethod() {
		System.out.println("Running @AfterEach");
	}

	// test<System under test>_<Condition or State Change>_<Expected Result>

	@DisplayName("Test 4/2=2")
	@Test
	public void testIntegerDivision_WhenFourIsDividedByTwo_ShouldReturnTwo() {

		System.out.println("Running Test 4/2=2");
		// Arrange //Given

		int dividend = 4;
		int divisor = 2;
		int expectedResult = 2;

		// Act //When
		int actualResult = calculator.integerDivision(dividend, divisor);

		// Assert //Then
		assertEquals(expectedResult, actualResult, "4/2 did not produce 2");
	}

	@DisplayName("Test integer substraction [minuend,subtrahend,expectedResult]")
	@ParameterizedTest
	//@MethodSource("integerSubstractionInputParameters")
	/*
	 * @CsvSource({ "20, 1, 19", "33, 1, 32", "47, 2, 45" })
	 */
	@CsvFileSource(resources = "/integerSubstraction.csv")
	//@Test
	public void testIntegerSubstraction_WhenSevenIsSubstractedFromFortySeven_ShouldReturnForty(int minuend,int subtrahend,int expectedResult) {

		System.out.println("Running Test " + minuend + "-" + subtrahend + " =" + expectedResult);
		//int minuend = 47;
		//int subtrahend = 7;
		//int expectedResult = 40;
		int actualResult = calculator.integerSubstraction(minuend, subtrahend);
		assertEquals(expectedResult, actualResult,
				() -> minuend + "-" + subtrahend + " did not produce " + expectedResult);
	}

	// @Disabled("TODO:Still need to work upon")
	@DisplayName("Test Divide By Zero")
	@Test
	public void testIntegerDivision_WhenDividendIsDividedByZero_ShouldThrowArithmaticException() {
		System.out.println("Running Test Divide By Zero");
		int divisor = 0;
		int dividend = 20;
		String expectedMessage = "/ by zero";

		ArithmeticException arithmeticException = assertThrows(ArithmeticException.class,
				() -> calculator.integerDivision(dividend, divisor),
				"Divide by zero should throw Arithmetic Exception");
		assertEquals(expectedMessage, arithmeticException.getMessage(), "Unexpected Exception Message");
		// fail("Not Implemented Yet");
	}
	
	@ParameterizedTest
	@ValueSource(strings={"Sachin","Saurav","Rahul"})
	public void valueSource(String name) {
		System.out.println("<---Running valueSource: " + name);
		assertNotNull(name);
	}

	private static Stream<Arguments> integerSubstractionInputParameters() {

		return Stream.of(Arguments.of(33, 1, 32), Arguments.of(51, 1, 50), Arguments.of(33, 3, 30));

	}

}
