package com.example.drawnavigation;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.drawnavigation.adapters.ScholarshipAdapter;
import com.example.drawnavigation.model.ScholarshipModel;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static com.example.drawnavigation.fragment.ScholarshipFragment.EXTRA_URL;

import static com.example.drawnavigation.fragment.ScholarshipFragment.EXTRA_URL2;
import static com.example.drawnavigation.fragment.ScholarshipFragment.EXTRA_URL4;
import static com.example.drawnavigation.fragment.ScholarshipFragment.EXTRA_URL_ID;



public class Detail_ScholarshipActivity extends AppCompatActivity {

    private RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail_scholarship);
        Intent intent = getIntent();
        String creatorTitle = intent.getStringExtra(EXTRA_URL);
//        String creatorShort_description = intent.getStringExtra(EXTRA_URL1);
        String creatorDate = intent.getStringExtra(EXTRA_URL2);
        String flag= intent.getStringExtra(EXTRA_URL4);

        TextView textViewCreator = findViewById(R.id.title);
        textViewCreator.setText(creatorTitle);

//        TextView textViewShort_description = findViewById(R.id.short_description);
//        textViewShort_description.setText(creatorShort_description);

        TextView textViewDate = findViewById(R.id.date);
        textViewDate.setText(creatorDate);
        ImageView imageView = findViewById(R.id.flag);
//        Picasso.with(this).load(imageUrl).fit.centerInside().into(imageView);
        Picasso.get().load(flag).fit().centerInside().into(imageView);

        mRequestQueue = Volley.newRequestQueue(this);

        getRequest();
    }

    private void getRequest() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        Intent intent = getIntent();
        String id = intent.getStringExtra(EXTRA_URL_ID);

        final TextView textView = (TextView) findViewById(R.id.textView);

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        //final String url = "https://gic.itc.edu.kh/api/v2/scholarships";
        final String url = String.format("https://gic.itc.edu.kh/api/v2/scholarships/"+ id);


        final WebView webview = (WebView)this.findViewById(R.id.webview);
        webview.getSettings().setJavaScriptEnabled(true);


        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
//                    textView.setText("Response is: "+ response.getString("id"));
                    webview.loadDataWithBaseURL("", response.getString("description"), "text/html", "UTF-8", "");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText("That didn't work!");
            }
        });

        requestQueue.add(jsonObjReq);



    }





}
