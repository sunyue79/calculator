/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Baidu company (the "License");
 * you may not use this file except in compliance with the License.
 */
package com.sunyue.util.calculator.core;

import java.util.Stack;

import com.sunyue.util.calculator.api.CalculationException;
import com.sunyue.util.calculator.api.Operator;

/**
 * This class is used to calculate a postfix expression.
 * 
 * @author sunyue05
 */
public class ExpressionCalculator {

    /**
     * Calculate a postfix expression.
     * 
     * @param exp
     * @return
     */
    public final Object calculate(Object[] exp) {
        if (exp == null || exp.length == 0) {
            throw new CalculationException(
                    "Wrong expression : empty expression.");
        }
        if (exp.length == 1) {
            if (exp[0] instanceof Operator) {
                throw new CalculationException(
                        "Wrong expression : only single operator.");
            } else {
                return exp[0];
            }
        }
        Stack<Object> stack = new Stack<Object>();
        for (int i = 0; i < exp.length; i++) {
            if (exp[i] instanceof Operator) {
                // operator
                Operator op = (Operator) exp[i];
                if (stack.size() < op.getDimension()) {
                    // no enough numbers
                    throw new CalculationException(
                            "Arguments number wrong, expected = "
                                    + op.getDimension() + ", actual = "
                                    + stack.size());
                } else {
                    // get numbers according to dimension and keep correct order
                    Object[] args = new Object[op.getDimension()];
                    for (int j = op.getDimension() - 1; j >= 0; j--) {
                        args[j] = stack.pop();
                    }
                    // calculate and put result into stack
                    stack.push(operate(op, args));
                }
            } else {
                // put result into stack
                stack.push(exp[i]);
            }
        }
        if (stack.size() != 1) {
            throw new CalculationException("Wrong expression : " + stack.size()
                    + " numbers remaind at last.");
        }
        return stack.pop();
    }

    /**
     * Perform basic calculation, sub class can override this method to provide
     * extra features such as supporting variables.
     * 
     * @param op
     *            operator
     * @param args
     *            operation numbers
     * @return
     */
    protected Object operate(Operator op, Object[] args) {
        return op.calculate(args);
    }
}
