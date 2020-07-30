package com.example.drawnavigation;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import static com.example.drawnavigation.fragment.ScholarshipFragment.EXTRA_URL;
import static com.example.drawnavigation.fragment.ScholarshipFragment.EXTRA_URL1;
import static com.example.drawnavigation.fragment.ScholarshipFragment.EXTRA_URL2;
import static com.example.drawnavigation.fragment.ScholarshipFragment.EXTRA_URL4;





public class Detail_ScholarshipActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail_scholarship);
        Intent intent = getIntent();
        String creatorTitle = intent.getStringExtra(EXTRA_URL);
        String creatorShort_description = intent.getStringExtra(EXTRA_URL1);
        String creatorDate = intent.getStringExtra(EXTRA_URL2);
        String flag= intent.getStringExtra(EXTRA_URL4);

        TextView textViewCreator = findViewById(R.id.title);
        textViewCreator.setText(creatorTitle);

        TextView textViewShort_description = findViewById(R.id.short_description);
        textViewShort_description.setText(creatorShort_description);

        TextView textViewDate = findViewById(R.id.date);
        textViewDate.setText(creatorDate);
        ImageView imageView = findViewById(R.id.flag);
//        Picasso.with(this).load(imageUrl).fit.centerInside().into(imageView);
        Picasso.get().load(flag).fit().centerInside().into(imageView);




    }
}
