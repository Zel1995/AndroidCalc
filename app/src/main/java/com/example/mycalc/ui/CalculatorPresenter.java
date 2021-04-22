package com.example.mycalc.ui;

import com.example.mycalc.domain.Calculator;
import com.example.mycalc.domain.Operation;

public class CalculatorPresenter {
    private CalculatorView view;
    private Calculator model;
    private CalculatorData data;

    public CalculatorPresenter(CalculatorView view, Calculator model) {
        this.view = view;
        this.model = model;
        data = new CalculatorData();
    }

    public CalculatorPresenter(CalculatorView view, Calculator model, CalculatorData data) {
        this.view = view;
        this.model = model;
        this.data = data;
        initData();
    }

    public void on1Click() {
        addElement("1");

    }

    public void on2Click() {
        addElement("2");
    }

    public void on3Click() {
        addElement("3");
    }

    public void on4Click() {
        addElement("4");
    }

    public void on5Click() {
        addElement("5");
    }

    public void on6Click() {
        addElement("6");
    }

    public void on7Click() {
        addElement("7");
    }

    public void on8Click() {
        addElement("8");
    }

    public void on9Click() {
        addElement("9");
    }

    public void on0Click() {
        addElement("0");
    }

    public void on00Click() {
        addElement("00");
    }

    public void onClearClick() {
        data = new CalculatorData();
        view.clearResultView();
    }

    public void onSquaredClick() {
        double argument = Double.parseDouble(data.getArg1().toString());
        data.setResult(String.valueOf(model.squareOperation(argument, Operation.SQUARE)));
        view.showResult(data.getResult());
    }

    public void onDivClick() {
        setOperator("/");

    }

    public void onMultClick() {
        setOperator("*");
    }

    public void onPlusClick() {
        setOperator("+");
    }

    public void onMinusClick() {
        setOperator("-");
    }

    public void onEqualClick() {
        if (data.getArg1().length() != 0 && data.getArg2().length() != 0 && data.getOperation() != null) {
            switch (data.getOperation()) {
                case "-": {
                    showResult(Operation.SUB);
                    break;
                }
                case "+": {
                    showResult(Operation.ADD);
                    break;
                }
                case "/": {
                    showResult(Operation.DIV);
                    break;
                }
                case "*": {
                    showResult(Operation.MULT);
                    break;
                }

            }
        }
    }

    public void onDotClick() {
        if (!data.getArg1().toString().contains(".") && data.getArg1().length() >= 1) {
            addElement(".");
        } else if (data.getArg1().toString().contains(".") && data.getArg2().length() >= 1 && !data.getArg2().toString().contains(".")) {
            addElement(".");
        }
    }

    private void setOperator(String str) {
        if (data.getArg1() != null) {
            data.setOperation(str);
            view.showInput(data.getArg1().toString() + " " + str);
        }
    }

    private void addElement(String str) {
        if (data.getArg1().length() == 0 || data.getOperation() == null) {
            data.getArg1().append(str);
            view.showInput(data.getArg1().toString());
        } else if (data.getOperation() != null && data.getArg1().length() != 0 && data.getResult() == null) {
            data.getArg2().append(str);
            view.showInput(data.getArg1().toString() + " " + data.getOperation() + " " + data.getArg2().toString());
        }
        if (data.getResult() != null) {
            clearCalculator();
            data.getArg1().append(str);
            view.showInput(data.getArg1().toString());
        }

    }

    private void showResult(Operation operation) {
        double num1 = Double.parseDouble(data.getArg1().toString());
        double num2 = Double.parseDouble(data.getArg2().toString());
        data.setResult(String.valueOf(model.binaryOperation(num1, num2, operation)));
        view.showResult(data.getResult());
    }

    private void clearCalculator() {
        data.getArg1().setLength(0);
        data.getArg2().setLength(0);
        data.setOperation(null);
        data.setResult(null);
        view.clearResultView();
    }

    public void sendData() {
        view.setData(data);
    }

    private void initData() {
        if (data.getOperation() == null && data.getResult() == null) {
            view.showInput(data.getArg1().toString());
        } else if (data.getOperation() != null && data.getArg1().length() != 0 && data.getResult() == null) {
            view.showInput(data.getArg1().toString() + " " + data.getOperation() + " " + data.getArg2().toString());
        }
        if (data.getResult() != null) {
            if (data.getOperation() != null) {
                view.showInput(data.getArg1().toString() + " " + data.getOperation() + " " + data.getArg2().toString());
            } else {
                view.showInput(data.getArg1().toString());
            }
            view.showResult(data.getResult());
        }
    }
}
