/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Baidu company (the "License");
 * you may not use this file except in compliance with the License.
 */
package com.sunyue.util.calculator.api;

import org.testng.annotations.Test;

import com.sunyue.util.calculator.api.CalculationException;
import com.sunyue.util.calculator.api.Operator;

import org.testng.Assert;

/**
 * Test operator
 * 
 * @author sunyue05
 * 
 */
public class OperatorTest {

    private Operator tester;

    /**
     * Test create with default parameters
     */
    @Test
    public void testDefaultCreate() {
        tester = new MockOperator("&");
        Assert.assertEquals(tester.getSymbol(), "&");
        Assert.assertEquals(tester.getPriority(), 10);
        Assert.assertEquals(tester.getDimension(), 2);
    }

    /**
     * Test create with invalid parameter
     */
    @Test(expectedExceptions = CalculationException.class)
    public void testErrorCreate1() {
        tester = new MockOperator(" ");
    }

    /**
     * Test create with invalid parameter
     */
    @Test(expectedExceptions = CalculationException.class)
    public void testErrorCreate2() {
        tester = new MockOperator("(");
    }

    class MockOperator extends Operator {

        /**
         * @param symbol
         */
        public MockOperator(String symbol) {
            super(symbol);
            // TODO Auto-generated constructor stub
        }

        /*
         * (non-Javadoc)
         * 
         * @see
         * com.sunyue.util.calculator.api.Operator#calculate(java.lang.
         * Object [])
         */
        @Override
        public Object calculate(Object[] args) {
            // TODO Auto-generated method stub
            return null;
        }

    }
}