package com.optum.fs.rest.service.util.microsft.comany.preparation;

import java.util.Stack;

public class ExpressionParser {
    public static void main(String[] args) {
        String expressioin = "((1+2)/(3*4))";
        System.out.println(evaluateExpression(expressioin));
    }

    private static double evaluateExpression(String expressioin) {
        Stack<String> operators = new Stack<String>();
        Stack<Double> operands = new Stack<Double>();
        double result = 0.0;
        if (expressioin.isEmpty()) {
            return 0.0;
        } else {
            for (String val : expressioin.split("")) {
                if (val.equals("(")) {
                } else if (val.equals("+")) {
                    operators.push(val);
                } else if (val.equals("-")) {
                    operators.push(val);
                } else if (val.equals("*")) {
                    operators.push(val);
                } else if (val.equals("/")) {
                    operators.push(val);
                } else if (val.equals("%")) {
                    operators.push(val);
                } else if (val.equals(")")) {
                    String op = operators.pop();
                    Double popped = operands.pop();
                    if (op.equals("+")) {
                        result = operands.pop() + popped;
                    } else if (op.equals("-")) {
                        result = operands.pop() - popped;
                    } else if (op.equals("*")) {
                        result = operands.pop() * popped;
                    } else if (op.equals("/")) {
                        result = operands.pop() / popped;
                    } else if (op.equals("%")) {
                        result = operands.pop() % popped;
                    }
                    operands.push(result);

                } else {
                    operands.push(Double.parseDouble(val));
                }
            }
            return operands.pop();
        }


    }
}
