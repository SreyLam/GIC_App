package com.example.drawnavigation.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.drawnavigation.R;
import com.example.drawnavigation.adapters.PartnershipAdapter;
import com.example.drawnavigation.model.SeminarModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PartnershipFragment extends Fragment {
    private RecyclerView recyclerView;
    private TextView mTextViewEmpty;
    private View view;
    private ImageView mImageViewEmpty;
    private PartnershipAdapter partnershipAdapter;
    private ArrayList<SeminarModel> partnershipList = new ArrayList<>();

    public PartnershipFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  = inflater.inflate(R.layout.fragment_scholarship, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);


        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        get_response_text=view.findViewById(R.id.get_respone_data);

        sendGetRequest();
        return view;

    }

//    }
    private TextView get_response_text,post_response_text;
    private void sendGetRequest() {

//    private static final String TAG = "MyActivity";
//        //let's try post and send some data to server
        RequestQueue queue= Volley.newRequestQueue(getActivity());

//        String url="https://reactnative.dev/movies.json";

        final String url = "https://gic.itc.edu.kh/api/events";

// prepare the Request
        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response) {
                        // display response
                        Log.d("Response", response.toString());
                        get_response_text.setText("Data : "+ response);
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );

// add it to the RequestQueue
        queue.add(getRequest);
    }
}
