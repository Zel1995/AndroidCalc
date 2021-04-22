package com.example.mycalc.ui;

public interface CalculatorView {
    void showResult(String result);

    void clearResultView();

    void showInput(String input);

    void setData(CalculatorData data);
}
