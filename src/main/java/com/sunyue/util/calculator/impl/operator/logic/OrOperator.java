/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Baidu company (the "License");
 * you may not use this file except in compliance with the License.
 */
package com.sunyue.util.calculator.impl.operator.logic;

/**
 * This class is used to perform OR logic calculation.
 * 
 * @author sunyue05
 */
public class OrOperator extends LogicOperatorSupport {

    private static final String DEFAULT_SYMBOL = "||";

    public OrOperator(String symbol, int priority) {
        super(symbol, priority);
    }

    public OrOperator(String symbol) {
        super(symbol);
    }

    public OrOperator() {
        super(DEFAULT_SYMBOL);
    }

    @Override
    public Object calculate(Object[] args) {
        Boolean n1 = super.getBoolean(args[0]);
        Boolean n2 = super.getBoolean(args[1]);
        return n1 || n2;
    }

}
