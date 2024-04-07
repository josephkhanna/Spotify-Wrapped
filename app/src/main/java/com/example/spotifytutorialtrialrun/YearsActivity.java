package com.example.spotifytutorialtrialrun;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class YearsActivity extends AppCompatActivity {
    private TextView textView;
    private ImageButton imageButton2022;
    private ImageButton imageButton2021;
    private ImageButton imageButton2020;
    private ImageButton imageButton2019;
    private ImageButton imageButton2018;
    private ImageButton imageButton2017;
    private ImageButton imageButton2016;
    private ImageButton imageButton2023;
    private Button settingsBackButton; // Assuming you have a back button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wrapped_years);

        // Initialize views
        textView = findViewById(R.id.textView);
        imageButton2022 = findViewById(R.id.imageButton2022);
        imageButton2021 = findViewById(R.id.imageButton2021);
        imageButton2020 = findViewById(R.id.imageButton2020);
        imageButton2019 = findViewById(R.id.imageButton2019);
        imageButton2018 = findViewById(R.id.imageButton2018);
        imageButton2017 = findViewById(R.id.imageButton2017);
        imageButton2016 = findViewById(R.id.imageButton2016);
        imageButton2023 = findViewById(R.id.imageButton2023);
        settingsBackButton = findViewById(R.id.settingsbackbutton);

        // Add any additional logic or listeners here
    }
}
