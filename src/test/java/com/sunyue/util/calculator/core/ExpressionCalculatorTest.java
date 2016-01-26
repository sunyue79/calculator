/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Baidu company (the "License");
 * you may not use this file except in compliance with the License.
 */
package com.sunyue.util.calculator.core;

import java.math.BigDecimal;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sunyue.util.calculator.core.ExpressionCalculator;
import com.sunyue.util.calculator.impl.operator.math.AdditionOperator;

import org.testng.Assert;

/**
 * Test ExpressionCalculator calculation
 * 
 * @author SunYue
 */
public class ExpressionCalculatorTest {

    private ExpressionCalculator tester;

    @BeforeClass
    protected void setUp() throws Exception {
        tester = new ExpressionCalculator();
    }

    /**
     * Test calculation result is correct
     */
    @Test
    public void testCalculate() {
        Object[] exp = new Object[] { "1", "2.01", new AdditionOperator() };
        Object result = tester.calculate(exp);
        Assert.assertEquals(result, new BigDecimal("3.01"));
    }

}
