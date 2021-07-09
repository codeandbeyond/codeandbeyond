package com.optum.fs.rest.service.util.elastic;

public class ConditionExpression {
    String op;
    String key;
    String value;

    public ConditionExpression(String key, String op, String value) {
        this.key = key;
        this.op = op;
        this.value = value;
    }


    @Override
    public String toString() {
        return "ConditionExpression{" +
                "op='" + op + '\'' +
                ", key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
