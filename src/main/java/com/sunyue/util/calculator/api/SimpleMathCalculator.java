/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Baidu company (the "License");
 * you may not use this file except in compliance with the License.
 */
package com.sunyue.util.calculator.api;

import java.math.BigDecimal;

import com.sunyue.util.calculator.core.ExpressionCalculator;
import com.sunyue.util.calculator.core.ExpressionConverter;
import com.sunyue.util.calculator.impl.operator.math.AdditionOperator;
import com.sunyue.util.calculator.impl.operator.math.DivisionOperator;
import com.sunyue.util.calculator.impl.operator.math.MultiplyOperator;
import com.sunyue.util.calculator.impl.operator.math.SubtractOperator;
import com.sunyue.util.calculator.impl.parser.SimpleExpressionParser;

/**
 * This class is an example of simple mathematics calculator. Only support add,
 * subtract, multiply and division calculation by default.
 * 
 * @author sunyue05
 */
public class SimpleMathCalculator {

    private ExpressionParser parser;

    private ExpressionCalculator expressionCalculator = new ExpressionCalculator();

    public SimpleMathCalculator() {
        this(null);
    }

    public SimpleMathCalculator(ExpressionParser parser) {
        if (parser == null) {
            this.parser = new SimpleExpressionParser(new Operator[] {
                    new AdditionOperator(), new SubtractOperator(),
                    new MultiplyOperator(), new DivisionOperator() });
        } else {
            this.parser = parser;
        }
    }

    public BigDecimal calculate(String expression) {
        Object[] result = parser.parse(expression);
        result = ExpressionConverter.convert(result);
        return (BigDecimal) expressionCalculator.calculate(result);
    }
}
