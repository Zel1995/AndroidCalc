package com.example.mycalc.ui;

import java.io.Serializable;

public final class CalculatorData implements Serializable {
    private StringBuilder arg1 = new StringBuilder();
    private StringBuilder arg2 = new StringBuilder();
    private String result;
    private String operation;

    public void setArg1(StringBuilder arg1) {
        this.arg1 = arg1;
    }

    public void setArg2(StringBuilder arg2) {
        this.arg2 = arg2;
    }

    public StringBuilder getArg1() {
        return arg1;
    }

    public StringBuilder getArg2() {
        return arg2;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }


    public String getResult() {
        return result;
    }

    public String getOperation() {
        return operation;
    }
}
