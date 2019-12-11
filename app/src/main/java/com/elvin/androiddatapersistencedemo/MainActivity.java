package com.elvin.androiddatapersistencedemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnAdd, btnDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.btnAdd = findViewById(R.id.btnAdd);
        this.btnAdd.setOnClickListener(this);

        this.btnDisplay = findViewById(R.id.btnDisplay);
        this.btnDisplay.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAdd:
                startActivity(new Intent(MainActivity.this, AddActivity.class));
                break;
            case R.id.btnDisplay:
                startActivity(new Intent(MainActivity.this, DisplayActivity.class));
                break;
        }
    }
}
