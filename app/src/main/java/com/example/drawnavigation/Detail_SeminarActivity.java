package com.example.drawnavigation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import static com.example.drawnavigation.fragment.SeminarFragment.EXTRA_URL;
import static com.example.drawnavigation.fragment.SeminarFragment.EXTRA_URL1;
import static com.example.drawnavigation.fragment.SeminarFragment.EXTRA_URL2;
import static com.example.drawnavigation.fragment.SeminarFragment.EXTRA_URL3;
import static com.example.drawnavigation.fragment.SeminarFragment.EXTRA_URL4;

public class Detail_SeminarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail_seminar);
        Intent intent = getIntent();
        String creatorName = intent.getStringExtra(EXTRA_URL);
        String creatorDetail = intent.getStringExtra(EXTRA_URL1);
        String creatorStart_date = intent.getStringExtra(EXTRA_URL2);
        String creatorEnd_date = intent.getStringExtra(EXTRA_URL3);
        String imageUrl= intent.getStringExtra(EXTRA_URL4);


        TextView textViewCreator = findViewById(R.id.name);
        textViewCreator.setText(creatorName);

//        TextView textViewDetail = findViewById(R.id.detail);
//        textViewDetail.setText(creatorDetail);

        TextView textViewStart_date = findViewById(R.id.start_date);
        textViewStart_date.setText(creatorStart_date);

        TextView textViewEnd_date = findViewById(R.id.end_date);
        textViewEnd_date.setText(creatorEnd_date);

        ImageView imageView = findViewById(R.id.image);
//        Picasso.with(this).load(imageUrl).fit.centerInside().into(imageView);
        Picasso.get().load(imageUrl).fit().centerInside().into(imageView);

        final WebView webview = (WebView)this.findViewById(R.id.detail);
        webview.getSettings().setJavaScriptEnabled(true);


//        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
//                url, null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                try {
//                    textView.setText("Response is: "+ response.getString("id"));
                    webview.loadDataWithBaseURL("",creatorDetail, "text/html", "UTF-8", "");
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//
//        }, new Response.ErrorListener() {
//
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                textView.setText("That didn't work!");
//            }
//        });
//
//        requestQueue.add(jsonObjReq);



    }
}
