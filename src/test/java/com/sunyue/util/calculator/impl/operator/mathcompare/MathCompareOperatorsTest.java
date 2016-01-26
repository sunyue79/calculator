/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Baidu company (the "License");
 * you may not use this file except in compliance with the License.
 */
package com.sunyue.util.calculator.impl.operator.mathcompare;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test concrete operator implementation
 * 
 * @author sunyue05
 * 
 */
public class MathCompareOperatorsTest {

    private MathCompareOperatorSupport tester;

    /**
     * Test basic calculation
     */
    @Test
    public void testOperatorCalculation() {
        tester = new EqualOperator();
        Assert.assertEquals(
                tester.calculate(new Object[] { 8, "8" }), true);
        Assert.assertEquals(
                tester.calculate(new Object[] { 7L, 7 }), true);
        Assert.assertEquals(
                tester.calculate(new Object[] { 3.1415926, "3.1415926" }), true);
        Assert.assertEquals(
                tester.calculate(new Object[] { 15.000, 15.001 }), false);

        tester = new LargeEqualOperator();
        Assert.assertEquals(
                tester.calculate(new Object[] { 8, "8" }), true);
        Assert.assertEquals(
                tester.calculate(new Object[] { 107L, 7 }), true);
        Assert.assertEquals(
                tester.calculate(new Object[] { 3.1415925, "3.1415926" }), false);
        Assert.assertEquals(
                tester.calculate(new Object[] { -15.000, 15.001 }), false);

        tester = new LessEqualOperator();
        Assert.assertEquals(
                tester.calculate(new Object[] { 8, "8" }), true);
        Assert.assertEquals(
                tester.calculate(new Object[] { 107L, 7 }), false);
        Assert.assertEquals(
                tester.calculate(new Object[] { 3.1415925, "3.1415926" }), true);
        Assert.assertEquals(
                tester.calculate(new Object[] { -15.000, 15.001 }), true);

        tester = new LargeThanOperator();
        Assert.assertEquals(
                tester.calculate(new Object[] { 8, "8" }), false);
        Assert.assertEquals(
                tester.calculate(new Object[] { 107L, 7 }), true);
        Assert.assertEquals(
                tester.calculate(new Object[] { 3.1415925, "3.1415926" }), false);
        Assert.assertEquals(
                tester.calculate(new Object[] { -15.000, 15.001 }), false);

        tester = new LessThanOperator();
        Assert.assertEquals(
                tester.calculate(new Object[] { 8, "8" }), false);
        Assert.assertEquals(
                tester.calculate(new Object[] { 107L, 7 }), false);
        Assert.assertEquals(
                tester.calculate(new Object[] { 3.1415925, "3.1415926" }), true);
        Assert.assertEquals(
                tester.calculate(new Object[] { -15.000, 15.001 }), true);
    }
}
