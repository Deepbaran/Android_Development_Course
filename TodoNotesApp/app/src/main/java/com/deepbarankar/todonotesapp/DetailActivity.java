package com.deepbarankar.todonotesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    TextView textViewTitle, textViewDescription;
    String title, description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        bindViews();
        setupIntentData();

        textViewTitle.setText(title);
        textViewDescription.setText(description);
    }

    private void setupIntentData() {
        Intent intent = getIntent();
        title = intent.getStringExtra(AppConstant.TITLE);
        description = intent.getStringExtra(AppConstant.DESCRIPTION);
    }

    private void bindViews() {
        textViewTitle = findViewById(R.id.textViewTitle);
        textViewDescription = findViewById(R.id.textViewDescription);
    }
}