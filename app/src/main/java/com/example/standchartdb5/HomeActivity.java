package com.example.standchartdb5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    TextView wTextview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        wTextview = findViewById(R.id.tvWelcome);
        //getintent -- inntent which started this activity
        String dataName = getIntent().getStringExtra("nkey");
        wTextview.setText(dataName);
    }
}