package com.example.standchartdb5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.standchartdb5.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {
    TextView wTextview;
    ActivityHomeBinding homeBinding;
    String[]  countries = {"india","usa","uk","australia",
            "india","usa","uk","australia",
            "india","usa","uk","australia",
            "india","usa","uk","australia"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        homeBinding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(homeBinding.getRoot());
       /* setContentView(R.layout.activity_home);
        wTextview = findViewById(R.id.tvWelcome);*/
        //RecyclerView recyclerView = findViewById(R.id.recyclerView);
        CountriesAdapter adapter = new CountriesAdapter(countries);
        homeBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        homeBinding.recyclerView.setAdapter(adapter);

        //getintent -- inntent which started this activity
       /* String dataName = getIntent().getStringExtra("nkey");
        wTextview.setText(dataName);*/
    }
}