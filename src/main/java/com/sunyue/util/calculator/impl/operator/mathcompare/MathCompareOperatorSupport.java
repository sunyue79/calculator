/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Baidu company (the "License");
 * you may not use this file except in compliance with the License.
 */
package com.sunyue.util.calculator.impl.operator.mathcompare;

import com.sunyue.util.calculator.impl.operator.math.MathOperatorSupport;

/**
 * This class is used to provide utilities for mathematics comparison
 * calculation. Only support <code>java.lang.Number</code> or String which can
 * be convert to <code>java.lang.Number</code>.
 * 
 * @author sunyue05
 */
public abstract class MathCompareOperatorSupport extends MathOperatorSupport {

    public MathCompareOperatorSupport(String symbol, int priority) {
        super(symbol, priority);
    }

    public MathCompareOperatorSupport(String symbol) {
        super(symbol);
    }

    protected int compare(Object n1, Object n2) {
        return super.getNumber(n1).compareTo(super.getNumber(n2));
    }
}
