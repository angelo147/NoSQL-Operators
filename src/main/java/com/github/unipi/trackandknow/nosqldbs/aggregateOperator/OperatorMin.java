package com.github.unipi.trackandknow.nosqldbs.aggregateOperator;

public class OperatorMin extends AggregateOperator {

    private OperatorMin(String fieldName){
        super(fieldName, "min_"+fieldName);
    }

    public static OperatorMin newOperatorMin(String fieldName){
        return new OperatorMin(fieldName);
    }

    @Override
    protected String getOperatorJsonField() {
        return "min";
    }
}