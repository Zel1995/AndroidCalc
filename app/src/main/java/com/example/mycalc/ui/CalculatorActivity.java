package com.example.mycalc.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mycalc.R;
import com.example.mycalc.domain.CalculatorImpl;

public class CalculatorActivity extends AppCompatActivity implements CalculatorView, View.OnClickListener {
    private CalculatorPresenter presenter;
    private TextView userInputTv;
    private TextView resultTv;
    private CalculatorData data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data = new CalculatorData();
        initTextViews();
        initButtons();
        initSettingsButton();
        if (savedInstanceState == null) {
            presenter = new CalculatorPresenter(this, new CalculatorImpl());
        } else {
            data = (CalculatorData) savedInstanceState.getSerializable("data");
            presenter = new CalculatorPresenter(this, new CalculatorImpl(), data);
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        presenter.sendData();
        outState.putSerializable("data", data);
    }

    @Override
    public void showResult(String result) {
        resultTv.setText(result);

    }

    @Override
    public void clearResultView() {
        resultTv.setText(R.string._0);
        userInputTv.setText(R.string.input_text);
    }

    @Override
    public void showInput(String input) {
        userInputTv.setText(input);
    }

    @Override
    public void setData(CalculatorData data) {
        this.data = data;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_1: {
                presenter.on1Click();
                break;
            }
            case R.id.btn_2: {
                presenter.on2Click();
                break;
            }
            case R.id.btn_3: {
                presenter.on3Click();
                break;
            }
            case R.id.btn_4: {
                presenter.on4Click();
                break;
            }
            case R.id.btn_5: {
                presenter.on5Click();
                break;
            }
            case R.id.btn_6: {
                presenter.on6Click();
                break;
            }
            case R.id.btn_7: {
                presenter.on7Click();
                break;
            }
            case R.id.btn_8: {
                presenter.on8Click();
                break;
            }
            case R.id.btn_9: {
                presenter.on9Click();
                break;
            }
            case R.id.btn_0: {
                presenter.on0Click();
                break;
            }
            case R.id.btn_00: {
                presenter.on00Click();
                break;
            }
            case R.id.btn_clear: {
                presenter.onClearClick();
                break;
            }
            case R.id.btn_square: {
                presenter.onSquaredClick();
                break;
            }
            case R.id.btn_divide: {
                presenter.onDivClick();
                break;
            }
            case R.id.btn_multiply: {
                presenter.onMultClick();
                break;
            }
            case R.id.btn_minus: {
                presenter.onMinusClick();
                break;
            }
            case R.id.btn_plus: {
                presenter.onPlusClick();
                break;
            }
            case R.id.btn_equals: {
                presenter.onEqualClick();
                break;
            }
            case R.id.btn_dot: {
                presenter.onDotClick();
                break;
            }
        }
    }

    private void initButtons() {
        int[] buttons = new int []{R.id.btn_0,
                R.id.btn_00,
                R.id.btn_1,
                R.id.btn_2,
                R.id.btn_3,
                R.id.btn_4,
                R.id.btn_5,
                R.id.btn_6,
                R.id.btn_7,
                R.id.btn_8,
                R.id.btn_9,
                R.id.btn_divide,
                R.id.btn_multiply,
                R.id.btn_minus,
                R.id.btn_plus,
                R.id.btn_clear,
                R.id.btn_equals,
                R.id.btn_dot,
                R.id.btn_square};
        for (int button : buttons) {
            findViewById(button).setOnClickListener(this);
        }
    }

    private void initTextViews() {
        userInputTv = findViewById(R.id.tv_input);
        resultTv = findViewById(R.id.tv_result);
    }

    private void initSettingsButton() {
        findViewById(R.id.btn_settings).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CalculatorActivity.this,SettingsActivity.class);
                startActivity(intent);
            }
        });
    }
}