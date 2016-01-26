/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Baidu company (the "License");
 * you may not use this file except in compliance with the License.
 */
package com.sunyue.util.calculator.impl.operator.math;

import java.math.BigDecimal;

/**
 * This class is used to perform subtract calculation.
 * 
 * @author sunyue05
 */
public class SubtractOperator extends MathOperatorSupport {
    
    private static final String DEFAULT_SYMBOL = "-";

    public SubtractOperator(String symbol, int priority) {
        super(symbol, priority);
    }

    public SubtractOperator(String symbol) {
        super(symbol);
    }

    public SubtractOperator() {
        super(DEFAULT_SYMBOL);
    }

    @Override
    public Object calculate(Object[] args) {
        BigDecimal n1 = super.getNumber(args[0]);
        BigDecimal n2 = super.getNumber(args[1]);
        return n1.subtract(n2);
    }
}
