package com.codepath.michellebau.simpletodo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EditActivity extends AppCompatActivity {

    EditText updItem;
    Button btnSave;

    // priority buttons: high => text becomes red, med => text becomes orange, low => text becomes blue
    Button btnHigh;
    Button btnMed;
    Button btnLow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        updItem = findViewById(R.id.updItem);
        btnSave = findViewById(R.id.btnSave);

        // priority buttons
        btnHigh = findViewById(R.id.btnHigh);
        btnMed = findViewById(R.id.btnMed);
        btnLow = findViewById(R.id.btnLow);

        getSupportActionBar().setTitle("Edit item");

        updItem.setText(getIntent().getStringExtra(MainActivity.KEY_ITEM_TEXT));

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();

                intent.putExtra(MainActivity.KEY_ITEM_TEXT, updItem.getText().toString());
                intent.putExtra(MainActivity.KEY_ITEM_POSITION, getIntent().getExtras().getInt(MainActivity.KEY_ITEM_POSITION));

                setResult(RESULT_OK, intent);
                finish();
            }
        });

        btnHigh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updItem.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.red));
            }
        });

        btnMed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updItem.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.orange));
            }
        });

        btnLow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updItem.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.blue));
            }
        });
    }
}
