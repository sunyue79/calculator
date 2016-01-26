/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Baidu company (the "License");
 * you may not use this file except in compliance with the License.
 */
package com.sunyue.util.calculator.impl.operator.mathcompare;

/**
 * This class is used to perform less than calculation.
 * 
 * @author sunyue05
 */
public class LessThanOperator extends MathCompareOperatorSupport {

    private static final String DEFAULT_SYMBOL = "<";

    public LessThanOperator(String symbol, int priority) {
        super(symbol, priority);
    }

    public LessThanOperator(String symbol) {
        super(symbol);
    }

    public LessThanOperator() {
        super(DEFAULT_SYMBOL);
    }

    @Override
    public Object calculate(Object[] args) {
        return -1 == super.compare(args[0], args[1]);
    }

}
