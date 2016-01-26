/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Baidu company (the "License");
 * you may not use this file except in compliance with the License.
 */
package com.sunyue.util.calculator.api;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sunyue.util.calculator.api.SimpleMathCalculator;

import org.testng.Assert;

/**
 * Test calculator
 * 
 * @author SunYue
 */
public class CalculatorTest {

    private SimpleMathCalculator tester;

    @BeforeClass
    protected void setUp() throws Exception {
        tester = new SimpleMathCalculator();
    }

    /**
     * Test calculation result are correct
     */
    @Test
    public void testCalculate() {
        Number result = (Number) tester.calculate("2*(9-5)+8/2+55");
        Assert.assertEquals(result.intValue(), 67);
        result = (Number) tester.calculate("2+8/2+55");
        Assert.assertEquals(result.intValue(), 61);
    }

}
