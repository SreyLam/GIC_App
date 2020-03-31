package com.example.drawnavigation.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.drawnavigation.DataNote;
import com.example.drawnavigation.R;
import com.example.drawnavigation.adapters.ListAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScholarshipFragment extends Fragment {

    private TextView mTextViewEmpty;
    private ProgressBar mProgressBarLoading;
    private ImageView mImageViewEmpty;
    private RecyclerView mRecyclerView;
    private ListAdapter mListadapter;
    private ArrayList<DataNote> dataNote;
    private RequestQueue mRequestQueue;


    public ScholarshipFragment(){}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view  = inflater.inflate(R.layout.fragment_scholarship, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);


        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

        dataNote = new ArrayList<>();

        mRequestQueue = Volley.newRequestQueue(getActivity());

        sendGetRequest();

        return view;
    }


    private void sendGetRequest() {

        mRequestQueue = Volley.newRequestQueue(getActivity());
        final String url = "https://gic.itc.edu.kh/api/events";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("data");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject hit = jsonArray.getJSONObject(i);

                                String text = hit.getString("name");
                                String start_date = hit.getString("start_date");
                                String end_date = hit.getString("end_date");
                                String imageUrl = hit.getString("image");
                                dataNote.add(new DataNote(text,start_date,end_date, imageUrl));
                            }

                            mListadapter = new ListAdapter(getActivity(), dataNote);
                            mRecyclerView.setAdapter(mListadapter);

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

}