package com.example.drawnavigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.drawnavigation.adapters.SeminarAdapter;
import com.example.drawnavigation.model.SeminarModel;

import java.util.ArrayList;

public class SeminarActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private SeminarAdapter seminarAdapter;
    private ArrayList<SeminarModel> seminarList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seminar);
//        init();
    }
    private void init() {

        TextView tx = findViewById((R.id.no_data_noticeboard));
        tx.setText("helloooo");
        recyclerView = findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
//        seminarAdapter = new SeminarAdapter(this);
        recyclerView.setAdapter(seminarAdapter);
        //   setRequestAPI();

    }
}
