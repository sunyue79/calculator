/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Baidu company (the "License");
 * you may not use this file except in compliance with the License.
 */
package com.sunyue.util.calculator.impl.operator.logic;

import com.sunyue.util.calculator.api.Operator;

/**
 * This class is used to perform NOT logic calculation.
 * 
 * @author sunyue05
 */
public class NotOperator extends LogicOperatorSupport {

    private static final String DEFAULT_SYMBOL = "!";

    public NotOperator(String symbol, int priority) {
        super(symbol, 1, priority);
    }

    public NotOperator(String symbol) {
        super(symbol, 1, Operator.DEFAULT_PRIORITY);
    }

    public NotOperator() {
        super(DEFAULT_SYMBOL, 1, Operator.DEFAULT_PRIORITY);
    }

    @Override
    public Object calculate(Object[] args) {
        Boolean n1 = super.getBoolean(args[0]);
        return !n1;
    }

}
