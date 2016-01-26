/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Baidu company (the "License");
 * you may not use this file except in compliance with the License.
 */
package com.sunyue.util.calculator.core;

import java.util.Arrays;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sunyue.util.calculator.api.CalculationException;
import com.sunyue.util.calculator.api.ExpressionParser;
import com.sunyue.util.calculator.api.Operator;
import com.sunyue.util.calculator.core.ExpressionConverter;
import com.sunyue.util.calculator.impl.operator.math.AdditionOperator;
import com.sunyue.util.calculator.impl.operator.math.DivisionOperator;
import com.sunyue.util.calculator.impl.operator.math.MultiplyOperator;
import com.sunyue.util.calculator.impl.operator.math.SubtractOperator;
import com.sunyue.util.calculator.impl.parser.SimpleExpressionParser;

import org.testng.Assert;

/**
 * Test ExpressionConverter
 * 
 * @author SunYue
 */
public class ExpressionConverterTest {

    private ExpressionParser parser;

    @BeforeClass
    protected void setUp() throws Exception {
        parser = new SimpleExpressionParser(new Operator[] {
                new AdditionOperator(), new SubtractOperator(),
                new MultiplyOperator(), new DivisionOperator() });
    }

    /**
     * Test converting valid expression
     */
    @Test
    public void testValidExpression() {
        String exp = "1+2*3";
        Object[] convertResult = ExpressionConverter.convert(parser.parse(exp));
        Assert.assertTrue(Arrays.equals(convertResult, new Object[] { "1", "2",
                "3", new MultiplyOperator(), new AdditionOperator() }));

        exp = "4+2*(5.9-9.9/3)";
        convertResult = ExpressionConverter.convert(parser.parse(exp));
        Assert.assertTrue(Arrays.equals(convertResult, new Object[] { "4", "2",
                "5.9", "9.9", "3", new DivisionOperator(),
                new SubtractOperator(), new MultiplyOperator(),
                new AdditionOperator() }));
    }

    /**
     * Test converting invalid expression, unpaired bracket
     */
    @SuppressWarnings("unused")
    @Test(expectedExceptions = CalculationException.class)
    public void testInvalidExpression1() {
        String exp = "(1+2";
        Object[] convertResult = ExpressionConverter.convert(parser.parse(exp));
    }

    /**
     * Test converting valid expression, unpaired bracket in complex expression
     */
    @SuppressWarnings("unused")
    @Test(expectedExceptions = CalculationException.class)
    public void testInvalidExpression2() {
        String exp = "4+2*(5.9-9.9/3";
        Object[] convertResult = ExpressionConverter.convert(parser.parse(exp));
    }
}
