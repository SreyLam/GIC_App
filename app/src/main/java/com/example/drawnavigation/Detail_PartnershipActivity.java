package com.example.drawnavigation;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.drawnavigation.fragment.PartnershipsFragment.EXTRA_URL;



public class Detail_PartnershipActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail_partnership);
        Intent intent = getIntent();
        String creatorWebsite = intent.getStringExtra(EXTRA_URL);


        TextView textViewCreator = findViewById(R.id.website);
        textViewCreator.setText(creatorWebsite);





    }
}
