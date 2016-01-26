/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Baidu company (the "License");
 * you may not use this file except in compliance with the License.
 */
package com.sunyue.util.calculator.impl.operator.mathcompare;

/**
 * This class is used to perform less or equal calculation.
 * 
 * @author sunyue05
 */
public class LessEqualOperator extends MathCompareOperatorSupport {

    private static final String DEFAULT_SYMBOL = "<=";

    public LessEqualOperator(String symbol, int priority) {
        super(symbol, priority);
    }

    public LessEqualOperator(String symbol) {
        super(symbol);
    }

    public LessEqualOperator() {
        super(DEFAULT_SYMBOL);
    }

    @Override
    public Object calculate(Object[] args) {
        int result = super.compare(args[0], args[1]);
        return 0 == result || -1 == result;
    }

}
