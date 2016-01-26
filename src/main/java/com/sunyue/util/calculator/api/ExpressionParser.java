/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Baidu company (the "License");
 * you may not use this file except in compliance with the License.
 */
package com.sunyue.util.calculator.api;

/**
 * This class is used to parse expression in string into an ordered computable
 * elements.
 * 
 * @author sunyue05
 */
public interface ExpressionParser {

    /**
     * Parse an expression to an ordered computable elements.
     * 
     * @param expression
     * @return the array contains calculation numbers, operators and brackets
     */
    Object[] parse(String expression);

}
