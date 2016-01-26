/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Baidu company (the "License");
 * you may not use this file except in compliance with the License.
 */
package com.sunyue.util.calculator.impl.operator.math;

import java.math.BigDecimal;

/**
 * This class is used to perform division calculation.
 * 
 * @author sunyue05
 */
public class DivisionOperator extends MathOperatorSupport {
    
    private static final String DEFAULT_SYMBOL = "/";

    public DivisionOperator(String symbol, int priority) {
        super(symbol, priority);
    }

    public DivisionOperator(String symbol) {
        super(symbol, 20);
    }

    public DivisionOperator() {
        super(DEFAULT_SYMBOL, 20);
    }

    @Override
    public Object calculate(Object[] args) {
        BigDecimal n1 = super.getNumber(args[0]);
        BigDecimal n2 = super.getNumber(args[1]);
        return n1.divide(n2);
    }

    @Override
    public boolean support(Object[] args) {
        return super.support(args)
                && !BigDecimal.ZERO.equals(getNumber(args[1]));
    }

}
