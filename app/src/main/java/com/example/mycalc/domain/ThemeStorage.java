package com.example.mycalc.domain;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.mycalc.R;

public class ThemeStorage {
    private Context context;
    private static final String KEY_THEME= "KEY_THEME";
    private static final String THEME_PREFERENCE ="ThemePreference";
    private SharedPreferences sharedPreferences;
    public ThemeStorage(Context context) {
        this.context = context;

        sharedPreferences = context.getSharedPreferences(THEME_PREFERENCE,Context.MODE_PRIVATE);
    }
    public void setCurrentTheme(Theme theme){
        sharedPreferences.edit().putString(KEY_THEME,theme.getKey()).apply();
    }
    public Theme getCurrentTheme(){
        String key = sharedPreferences.getString(KEY_THEME,Theme.OPTION_1.getKey());
        for(Theme theme: Theme.values()){
            if(theme.getKey().equals(key)){
                return theme;
            }
        }
        throw new RuntimeException();
    }
}
