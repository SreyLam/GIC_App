package com.example.drawnavigation;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.drawnavigation.fragment.ScholarshipFragment.EXTRA_URL;
import static com.example.drawnavigation.fragment.ScholarshipFragment.EXTRA_URL1;
import static com.example.drawnavigation.fragment.ScholarshipFragment.EXTRA_URL2;


public class Detail_ScholarshipActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail_scholarship);
        Intent intent = getIntent();
        String creatorTitle = intent.getStringExtra(EXTRA_URL);
        String creatorShort_description = intent.getStringExtra(EXTRA_URL1);
        String creatorDate = intent.getStringExtra(EXTRA_URL2);

        TextView textViewCreator = findViewById(R.id.title);
        textViewCreator.setText(creatorTitle);

        TextView textViewShort_description = findViewById(R.id.short_description);
        textViewShort_description.setText(creatorShort_description);

        TextView textViewDate = findViewById(R.id.date);
        textViewDate.setText(creatorDate);




    }
}
