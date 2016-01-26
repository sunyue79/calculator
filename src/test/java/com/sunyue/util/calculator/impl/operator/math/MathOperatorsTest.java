/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Baidu company (the "License");
 * you may not use this file except in compliance with the License.
 */
package com.sunyue.util.calculator.impl.operator.math;

import java.math.BigDecimal;

import org.testng.annotations.Test;

import com.sunyue.util.calculator.impl.operator.math.AdditionOperator;
import com.sunyue.util.calculator.impl.operator.math.DivisionOperator;
import com.sunyue.util.calculator.impl.operator.math.MathOperatorSupport;
import com.sunyue.util.calculator.impl.operator.math.MultiplyOperator;
import com.sunyue.util.calculator.impl.operator.math.SubtractOperator;

import org.testng.Assert;

/**
 * Test concrete operator implementation
 * 
 * @author sunyue05
 * 
 */
public class MathOperatorsTest {

    private MathOperatorSupport tester;

    /**
     * Test support function implemented by base class
     */
    @Test
    public void testMathOperatorSupport() {
        tester = new AdditionOperator();
        Assert.assertTrue(tester.support(new Object[] { 4, 89.67F }));
        Assert.assertTrue(tester.support(new Object[] { "27", "12.006" }));
        Assert.assertTrue(tester.support(new Object[] { -52, "1204.99" }));

        Assert.assertFalse(tester.support(new Object[] { 4, 89.67F, 15 }));
        Assert.assertFalse(tester.support(new Object[] { "A", "12.006" }));
        Assert.assertFalse(tester.support(new Object[] { 52, 's' }));
        Assert.assertFalse(tester.support(null));
    }

    /**
     * Test division support implemented by itself
     */
    @Test
    public void testDivisionOperator() {
        tester = new DivisionOperator();
        Assert.assertTrue(tester.support(new Object[] { 0, 89.67F }));

        Assert.assertFalse(tester.support(new Object[] { 4, 0 }));
    }

    /**
     * Test basic calculation
     */
    @Test
    public void testOperatorCalculation() {
        tester = new AdditionOperator();
        Assert.assertEquals(tester.calculate(new Object[] { "2", 13 }),
                new BigDecimal(15));
        Assert.assertEquals(tester.calculate(new Object[] { 17, "12.04" }),
                new BigDecimal("29.04"));

        tester = new SubtractOperator();
        Assert.assertEquals(tester.calculate(new Object[] { "2", 13 }),
                new BigDecimal(-11));
        Assert.assertEquals(tester.calculate(new Object[] { 17, "12.04" }),
                new BigDecimal("4.96"));

        tester = new MultiplyOperator();
        Assert.assertEquals(tester.calculate(new Object[] { "2", 13 }),
                new BigDecimal(26));
        Assert.assertEquals(tester.calculate(new Object[] { 17, "12.04" }),
                new BigDecimal("204.68"));

        tester = new DivisionOperator();
        Assert.assertEquals(tester.calculate(new Object[] { "13", 2 }),
                new BigDecimal("6.5"));
        Assert.assertEquals(tester.calculate(new Object[] { 12.5, "2.5" }),
                new BigDecimal(5));
    }
}
