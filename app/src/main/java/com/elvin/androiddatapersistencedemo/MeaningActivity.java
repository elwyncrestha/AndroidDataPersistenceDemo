package com.elvin.androiddatapersistencedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MeaningActivity extends AppCompatActivity {

    private TextView tvMeaning;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meaning);

        this.tvMeaning = findViewById(R.id.tvMeaning);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            this.tvMeaning.setText(bundle.getString("meaning"));
        } else {
            Toast.makeText(getApplicationContext(), "No message!!!", Toast.LENGTH_SHORT).show();
        }
    }
}
