package com.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

@DisplayName("Repeated Test Demo Class")
public class RepeatedTest {
	
	private Calculator calculator;
	
	@BeforeEach
	public void beforeEachTestMethod() {
		calculator = new Calculator();
		System.out.println("Running @BeforeEach");
	}
	
	@DisplayName("Test Divide By Zero")
	@org.junit.jupiter.api.RepeatedTest(value =3,name = " {displayName}. Repetition {currentRepetition} of" + "{totalRepetitions}")
	public void testIntegerDivision_WhenDividendIsDividedByZero_ShouldThrowArithmaticException(RepetitionInfo repetitionInfo,TestInfo testInfo) {
		System.out.println("Running " + testInfo.getTestMethod().get().getName());
		System.out.println("Repetition# " + repetitionInfo.getCurrentRepetition() + "of " + repetitionInfo.getTotalRepetitions());
		int divisor = 0;
		int dividend = 20;
		String expectedMessage = "/ by zero";

		ArithmeticException arithmeticException = assertThrows(ArithmeticException.class,
				() -> calculator.integerDivision(dividend, divisor),
				"Divide by zero should throw Arithmetic Exception");
		assertEquals(expectedMessage, arithmeticException.getMessage(), "Unexpected Exception Message");
		// fail("Not Implemented Yet");
	}
	

}
