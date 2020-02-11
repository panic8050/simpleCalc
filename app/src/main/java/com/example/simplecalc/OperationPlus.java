package com.example.simplecalc;

public class OperationPlus implements Operation {

    @Override
    public double execute(double a, double b) {
        return a + b;
    }

}
