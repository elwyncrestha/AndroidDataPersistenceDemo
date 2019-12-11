package com.elvin.androiddatapersistencedemo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DisplayActivity extends AppCompatActivity {

    ListView lvWords;
    private Map<String, String> dictionary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        this.lvWords = findViewById(R.id.lvWords);
        this.dictionary = new HashMap<>();
        readFromFile();

        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<>(this.dictionary.keySet()));
        this.lvWords.setAdapter(adapter);
        this.lvWords.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String key = parent.getItemAtPosition(position).toString();
                String meaning = dictionary.get(key);
                Intent intent = new Intent(DisplayActivity.this, MeaningActivity.class);
                intent.putExtra("meaning", meaning);
                startActivity(intent);
            }
        });
    }

    private void readFromFile() {
        try {
            FileInputStream fileInputStream = openFileInput("words.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split("=");
                dictionary.put(parts[0], parts[1]);
            }
        } catch (IOException e) {
            Log.d("Dictionary App", "Error: " + e.toString());
            e.printStackTrace();
        }
    }
}
