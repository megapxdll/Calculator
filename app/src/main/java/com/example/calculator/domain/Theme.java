package com.example.calculator.domain;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;

import com.example.calculator.R;

public enum Theme {
    THEME_ONE(R.string.theme_one, R.drawable.baseline_face_black_24dp, R.style.Theme_Calculator_Version2, "one"),
    THEME_TWO(R.string.theme_two, R.drawable.baseline_fingerprint_black_24dp, R.style.Theme_Calculator_Version3, "two"),
    THEME_THREE(R.string.theme_three, R.drawable.baseline_flutter_dash_black_24dp, R.style.Theme_Calculator_Version4, "three"),
    THEME_FOUR(R.string.theme_four, R.drawable.baseline_pets_black_24dp, R.style.Theme_Calculator, "four");

    @StringRes
    private final int title;
    @DrawableRes
    private final int img;
    @StyleRes
    private final int theme;

    private final String key;

    Theme(int title, int img, int theme, String key) {
        this.title = title;
        this.img = img;
        this.theme = theme;
        this.key = key;
    }

    public int getTitle() {
        return title;
    }

    public int getImg() {
        return img;
    }

    public int getTheme() {
        return theme;
    }

    public String getKey() {
        return key;
    }
}
