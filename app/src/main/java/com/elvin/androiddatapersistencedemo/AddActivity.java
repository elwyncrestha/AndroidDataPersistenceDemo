package com.elvin.androiddatapersistencedemo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class AddActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etWord, etMeaning;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        this.bindControls();
    }

    private void bindControls() {
        this.etWord = findViewById(R.id.etWord);
        this.etMeaning = findViewById(R.id.etMeaning);
        this.btnSave = findViewById(R.id.btnSave);

        this.btnSave.setOnClickListener(this);
    }

    private void saveIntoFile() {
        try {
            PrintStream printStream = new PrintStream(openFileOutput("words.txt", MODE_PRIVATE | MODE_APPEND));
            printStream.println(String.format("%s=%s", etWord.getText().toString(), etMeaning.getText().toString()));
            Toast.makeText(this, "Saved to " + getFilesDir(), Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            Log.d("Dictionary App", "Error: " + e.toString());
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        this.saveIntoFile();
    }
}
