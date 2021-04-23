package com.example.mycalc.domain;

public interface Calculator {
    double binaryOperation(double argOne, double argTwo, Operation operation);

    double squareOperation(double arg, Operation operation);
}
