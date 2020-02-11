package com.example.simplecalc;

public class OperationDivide implements Operation {

    @Override
    public double execute(double a, double b) {
        if (b == 0) return 0;
        else return a / b;
    }

}
