package com.example.mycalc.ui;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mycalc.R;
import com.example.mycalc.domain.Theme;
import com.example.mycalc.domain.ThemeStorage;
import com.google.android.material.button.MaterialButton;

public class SettingsActivity extends AppCompatActivity {
    private ThemeStorage storage;
    private MaterialButton btnDefaultTheme;
    private MaterialButton btnDarkTheme;
    private MaterialButton btnAccept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        storage = new ThemeStorage(this);
        setTheme(storage.getCurrentTheme().getRes());
        setContentView(R.layout.activity_settings);
        initButtons();
        initListeners();
    }

    private void initListeners() {//это выносить в презентр ?
        View.OnClickListener themeClicks = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == btnDefaultTheme.getId()) {
                    storage.setCurrentTheme(Theme.OPTION_1);
                } else if (v.getId() == btnDarkTheme.getId()) {
                    storage.setCurrentTheme(Theme.OPTION_2);
                } else if (v.getId() == btnAccept.getId()) {
                    finish();
                    return;
                }
                recreate();
            }
        };
        btnDefaultTheme.setOnClickListener(themeClicks);
        btnDarkTheme.setOnClickListener(themeClicks);
        btnAccept.setOnClickListener(themeClicks);

    }

    private void initButtons() {
        btnDefaultTheme = findViewById(R.id.btn_myCalc);
        btnDarkTheme = findViewById(R.id.btn_myCalc2);
        btnAccept = findViewById(R.id.btn_accept);
    }
}