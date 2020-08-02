package com.example.drawnavigation.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.drawnavigation.Detail_ScholarshipActivity;
import com.example.drawnavigation.R;
import com.example.drawnavigation.adapters.ScholarshipAdapter;
import com.example.drawnavigation.model.ScholarshipModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScholarshipFragment extends Fragment implements ScholarshipAdapter.OnItemClickListener {
    public static final String EXTRA_URL = "title";
    //    public static final String EXTRA_URL3 = "description";
//    public static final String EXTRA_URL1 = "short_description";
    public static final String EXTRA_URL2 = "date";
    public static final String EXTRA_URL4 = "flag";
    public static final String EXTRA_URL_ID = "id";

    private RecyclerView mRecyclerView;
    private ScholarshipAdapter scholarshipadapter;
    private ArrayList<ScholarshipModel> dataList;
    private RequestQueue mRequestQueue;
    public String urlbase = "https://gic.itc.edu.kh/";


    public ScholarshipFragment(){}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view  = inflater.inflate(R.layout.fragment_scholarship, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview1);


        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

        dataList = new ArrayList<>();

        mRequestQueue = Volley.newRequestQueue(getActivity());



        sendGetRequest();

        return view;
    }


    private void sendGetRequest() {

        mRequestQueue = Volley.newRequestQueue(getActivity());
        final String url = "https://gic.itc.edu.kh/api/v2/scholarships";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    class OnItemClickListener implements ScholarshipAdapter.OnItemClickListener {
                        @Override
                        public void onItemClick(int position) {

                            Intent detailIntent = new Intent(getActivity(), Detail_ScholarshipActivity.class);
                            ScholarshipModel clickedItem = dataList.get(position);

                            detailIntent.putExtra(EXTRA_URL, clickedItem.getTitle());
//                            detailIntent.putExtra(EXTRA_URL1, clickedItem.getDescription());
                            detailIntent.putExtra(EXTRA_URL_ID, clickedItem.getId());
//                            detailIntent.putExtra(EXTRA_URL1, clickedItem.getShort_description());
                            detailIntent.putExtra(EXTRA_URL2, clickedItem.getDate());
                            detailIntent.putExtra(EXTRA_URL4, clickedItem.getFlag());

                            startActivity(detailIntent);
                        }
                    }
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("data");
//
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject hit = jsonArray.getJSONObject(i);
                                String id = hit.getString("id");
                                String title = hit.getString("title");
                                String date = hit.getString("date");
                                String short_description = hit.getString("short_description");
//                                String description = hit.getString("description");
                                String flag = hit.getString("flag");
                                String flag1 = urlbase + flag;
                                dataList.add(new ScholarshipModel(id,title,date,short_description, flag1));
                            }

                            scholarshipadapter = new ScholarshipAdapter(getActivity(), dataList);
                            mRecyclerView.setAdapter(scholarshipadapter);
                            scholarshipadapter.setOnItemClickListener(new OnItemClickListener());
//
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mRequestQueue.add(request);
    }

    @Override
    public void onItemClick(int position) {
        Intent detailIntent = new Intent(getActivity(), Detail_ScholarshipActivity.class);
        ScholarshipModel clickedItem = dataList.get(position);
        startActivity(detailIntent);

    }
}