/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Baidu company (the "License");
 * you may not use this file except in compliance with the License.
 */
package com.sunyue.util.calculator.impl.operator.logic;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test concrete operator implementation
 * 
 * @author sunyue05
 * 
 */
public class LogicOperatorsTest {

    private LogicOperatorSupport tester;

    /**
     * Test support function implemented by base class
     */
    @Test
    public void testMathOperatorSupport() {
        tester = new AndOperator();
        Assert.assertTrue(tester.support(new Object[] { true, Boolean.FALSE }));
        Assert.assertTrue(tester.support(new Object[] { "true", "False" }));
        Assert.assertTrue(tester.support(new Object[] { "tRuE", false }));

        Assert.assertFalse(tester.support(new Object[] { 4, 89.67F, 15 }));
        Assert.assertFalse(tester.support(new Object[] { "A", true }));
        Assert.assertFalse(tester.support(new Object[] { 52, "False" }));
        Assert.assertFalse(tester.support(new Object[] { null, null }));
        Assert.assertFalse(tester.support(null));
    }

    /**
     * Test basic calculation
     */
    @Test
    public void testOperatorCalculation() {
        tester = new AndOperator();
        Assert.assertEquals(
                tester.calculate(new Object[] { true, Boolean.TRUE }), true);
        Assert.assertEquals(
                tester.calculate(new Object[] { false, Boolean.TRUE }), false);
        Assert.assertEquals(
                tester.calculate(new Object[] { true, Boolean.FALSE }), false);

        tester = new OrOperator();
        Assert.assertEquals(
                tester.calculate(new Object[] { true, Boolean.TRUE }), true);
        Assert.assertEquals(
                tester.calculate(new Object[] { false, Boolean.TRUE }), true);
        Assert.assertEquals(
                tester.calculate(new Object[] { false, Boolean.FALSE }), false);

        tester = new NotOperator();
        Assert.assertEquals(tester.calculate(new Object[] { Boolean.TRUE }),
                false);
        Assert.assertEquals(tester.calculate(new Object[] { false }), true);
    }
}
