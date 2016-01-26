/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Baidu company (the "License");
 * you may not use this file except in compliance with the License.
 */
package com.sunyue.util.calculator.impl.operator.mathcompare;

/**
 * This class is used to perform larger than calculation.
 * 
 * @author sunyue05
 */
public class LargeThanOperator extends MathCompareOperatorSupport {

    private static final String DEFAULT_SYMBOL = ">";

    public LargeThanOperator(String symbol, int priority) {
        super(symbol, priority);
    }

    public LargeThanOperator(String symbol) {
        super(symbol);
    }

    public LargeThanOperator() {
        super(DEFAULT_SYMBOL);
    }

    @Override
    public Object calculate(Object[] args) {
        return 1 == super.compare(args[0], args[1]);
    }

}
