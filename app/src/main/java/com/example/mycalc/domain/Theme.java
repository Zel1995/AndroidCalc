package com.example.mycalc.domain;

import com.example.mycalc.R;

public enum Theme {


    OPTION_1("option_1",R.style.Theme_MyCalc),
    OPTION_2("option_2",R.style.Theme_MyCalc2);

    private String key;

    private int res;
    Theme(String key, int res) {
        this.key = key;
        this.res = res;
    }


    public String getKey() {
        return key;
    }

    public int getRes() {
        return res;
    }
}
