package com.cuprumz.demo;

import org.junit.jupiter.api.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class TestApp {


    @Test
    public void test() {
        ExpressionParser parser = new SpelExpressionParser();

        Expression exp = parser.parseExpression("'hello, world'");

        String val = (String) exp.getValue();

        exp = parser.parseExpression("'hello, world'.bytes.length");

        int length = (int) exp.getValue();

        exp = parser.parseExpression("new String('hello world').toUpperCase()");

        val = (String) exp.getValue();

        String randomPhrase = parser.parseExpression(
                "random number is #{T(java.lang.Math).random()*100}",
                new TemplateParserContext()).getValue(String.class);

        System.out.println(randomPhrase);
    }
}
