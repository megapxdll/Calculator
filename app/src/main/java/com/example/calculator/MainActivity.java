package com.example.calculator;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements CalculatorView {


    private TextView result_window;

    private CalculatorPresenter presenter;

    String var = "0";

    private final static String result_var = "result";

    private final static String textview_text = "text";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        presenter = new CalculatorPresenter(this, new CalculatorImp());

        result_window = findViewById(R.id.result_window);

        Map<Integer, Integer> digits = new HashMap<>();
        digits.put(R.id.button_0, 0);
        digits.put(R.id.button_1, 1);
        digits.put(R.id.button_2, 2);
        digits.put(R.id.button_3, 3);
        digits.put(R.id.button_4, 4);
        digits.put(R.id.button_5, 5);
        digits.put(R.id.button_6, 6);
        digits.put(R.id.button_7, 7);
        digits.put(R.id.button_8, 8);
        digits.put(R.id.button_9, 9);

        View.OnClickListener digitClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onDigitPressed(digits.get(v.getId()));
            }
        };

        findViewById(R.id.button_1).setOnClickListener(digitClickListener);
        findViewById(R.id.button_2).setOnClickListener(digitClickListener);
        findViewById(R.id.button_3).setOnClickListener(digitClickListener);
        findViewById(R.id.button_4).setOnClickListener(digitClickListener);
        findViewById(R.id.button_5).setOnClickListener(digitClickListener);
        findViewById(R.id.button_6).setOnClickListener(digitClickListener);
        findViewById(R.id.button_7).setOnClickListener(digitClickListener);
        findViewById(R.id.button_8).setOnClickListener(digitClickListener);
        findViewById(R.id.button_9).setOnClickListener(digitClickListener);
        findViewById(R.id.button_0).setOnClickListener(digitClickListener);

        Map<Integer, Operation> operators = new HashMap<>();
        operators.put(R.id.button_plus, Operation.ADD);
        operators.put(R.id.button_minus, Operation.SUB);
        operators.put(R.id.button_multiply, Operation.MULT);
        operators.put(R.id.button_divide, Operation.DIV);

        View.OnClickListener operationClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onOperationPressed(operators.get(v.getId()));
            }
        };

        findViewById(R.id.button_plus).setOnClickListener(operationClickListener);
        findViewById(R.id.button_minus).setOnClickListener(operationClickListener);
        findViewById(R.id.button_multiply).setOnClickListener(operationClickListener);
        findViewById(R.id.button_divide).setOnClickListener(operationClickListener);

        findViewById(R.id.button_point).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onDotPressed();
            }
        });
    }

    @Override
    public void showResult(String result) {
        result_window.setText(result);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString(result_var, " ");
        TextView text = (TextView) result_window;
        outState.putString(textview_text, result_window.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        var = savedInstanceState.getString(result_var);
        String textview = savedInstanceState.getString(textview_text);
        TextView result_view = (TextView) result_window;
        result_view.setText(textview_text);
    }
}