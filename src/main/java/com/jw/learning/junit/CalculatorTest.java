package com.jw.learning.junit;

import static org.junit.Assert.*;

import org.junit.Test;

/*
 * Run the test from the command line. On Linux or MacOS

java -cp .:junit-4.XX.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore CalculatorTest
and on Windows

java -cp .;junit-4.XX.jar;hamcrest-core-1.3.jar org.junit.runner.JUnitCore CalculatorTest
 * 
 */

public class CalculatorTest {
	  @Test
	  public void evaluatesExpression() {
	    Calculator calculator = new Calculator();
	    int sum = calculator.evaluate("1+2+3");
	    assertEquals(6, sum);
	  }
}
