package com.example.simplecalc.utils;

public class NumbersUtils {

    public static String formatNumber(Double number){
        if (number == Math.floor(number)) return String.valueOf(number.intValue());
        else return String.valueOf(number);
    }

}
