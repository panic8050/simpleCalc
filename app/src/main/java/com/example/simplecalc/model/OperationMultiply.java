package com.example.simplecalc.model;

public class OperationMultiply implements Operation {

    @Override
    public double execute(double a, double b) {
        return a * b;
    }

}
