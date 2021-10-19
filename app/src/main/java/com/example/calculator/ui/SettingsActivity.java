package com.example.calculator.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.calculator.R;
import com.example.calculator.domain.Theme;
import com.example.calculator.storage.ThemeStorage;

public class SettingsActivity extends AppCompatActivity {

    public static final String ARG_THEME = "ARG_THEME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ThemeStorage storage = new ThemeStorage(this);

        setTheme(storage.getTheme().getTheme());

        setContentView(R.layout.activity_settings);

        Intent launchIntent = getIntent();

        Theme launchTheme = (Theme) launchIntent.getSerializableExtra(ARG_THEME);

        LinearLayout container = findViewById(R.id.theme_container);

        for (Theme theme : Theme.values()) {
            View itemView = getLayoutInflater().inflate(R.layout.item_theme, container, false);

            ImageView img = itemView.findViewById(R.id.img);
            ImageView check = itemView.findViewById(R.id.check);
            TextView txt = itemView.findViewById(R.id.txt);

            img.setImageResource(theme.getImg());

            String txtValue = getString(theme.getTitle());
            txt.setText(txtValue);

            int visibility = View.GONE;

            if (theme.equals(launchTheme)) {
                visibility = View.VISIBLE;
            }

            check.setVisibility(visibility);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent data = new Intent();
                    data.putExtra(ARG_THEME, theme);

                    setResult(Activity.RESULT_OK, data);

                    finish();
                }
            });

            container.addView(itemView);
        }

        findViewById(R.id.btn_terms_conditions).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri termsConditions = Uri.parse("https://yandex.ru/");
                Intent intent = new Intent(Intent.ACTION_VIEW, termsConditions);

                startActivity(Intent.createChooser(intent, ""));
            }
        });
    }
}