package com.example.simplecalc.model;

public class OperationPlus implements Operation {

    @Override
    public double execute(double a, double b) {
        return a + b;
    }

}
