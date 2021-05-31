package com.learning.agecalculatoranalysis;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AgeAnalysis extends AppCompatActivity {
    TextView textViewResult, textViewYears, textViewMonths, textViewDays, textViewHours, textViewMin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age_analysis);

        textViewResult = findViewById(R.id.txtSelected);
        textViewYears = findViewById(R.id.textView);
        textViewMonths = findViewById(R.id.textView8);
        textViewDays = findViewById(R.id.textView11);
        textViewHours = findViewById(R.id.textView13);
        textViewMin = findViewById(R.id.textView15);


        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        String date = bundle.getString("selectedDate");
        String date1 = bundle.getString("selectedAge");
        textViewYears.setText("" + date);
        textViewMin.setText("" + date1);


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(AgeAnalysis.this, MainActivity.class);
        startActivity(intent);
        finish();
        super.onBackPressed();
    }
}