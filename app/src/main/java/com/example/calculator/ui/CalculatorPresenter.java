package com.example.calculator.ui;

import com.example.calculator.domain.Calculator;
import com.example.calculator.domain.Operation;

public class CalculatorPresenter {
    private static final int BASE = 10;

    private final CalculatorView view;
    private final Calculator calculator;

    private Double argOne = 0.0;
    private Double argTwo = null;

    private Operation previousOperation;

    private boolean isDotPressed;

    private int divider;

    public CalculatorPresenter(CalculatorView view, Calculator calculator) {
        this.view = view;
        this.calculator = calculator;
    }

    public void onDigitPressed(int digit) {

        if (argTwo == null) {

            if (isDotPressed) {
                argOne = argOne + digit / (double) divider;
                divider *= BASE;
            } else {
                argOne = argOne * BASE + digit;
            }

            displayResult(argOne);
        } else {
            if (isDotPressed) {
                argTwo = argTwo + digit / (double) divider;
                divider *= BASE;
            } else {
                argTwo = argTwo * BASE + digit;
            }
            displayResult(argTwo);
        }
    }

    public void onOperationPressed(Operation operation) {
        if (previousOperation != null) {
            double result = calculator.performOperation(argOne, argTwo, previousOperation);

            displayResult(result);

            argOne = result;
        }

        previousOperation = operation;

        argTwo = 0.0;

        isDotPressed = false;
    }

    public void onDotPressed() {
        if (!isDotPressed) {
            isDotPressed = true;
            divider = BASE;
        }
    }

    private void displayResult(double arg) {

        long longValue = (long) arg;

        if (longValue == arg) {
            view.showResult(String.valueOf(longValue));
        } else {
            view.showResult(String.valueOf(arg));
        }
    }
}
