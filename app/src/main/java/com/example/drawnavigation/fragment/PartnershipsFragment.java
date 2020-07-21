package com.example.drawnavigation.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.drawnavigation.Detail_PartnershipActivity;
import com.example.drawnavigation.R;
import com.example.drawnavigation.adapters.PartnershipAdapter;
import com.example.drawnavigation.model.PartnershipModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PartnershipsFragment extends Fragment implements PartnershipAdapter.OnItemClickListener{
    public static final String EXTRA_URL = "website";
//    public static final String EXTRA_URL4 = "image";
//    public static final String EXTRA_URL1 = "detail";
//    public static final String EXTRA_URL2 = "start_date";
//    public static final String EXTRA_URL3 = "end_date";

    private TextView mTextViewEmpty;
    private ImageView mImageViewEmpty;
    private RecyclerView mRecyclerView;
    private PartnershipAdapter partnershipAdapter;
    private ArrayList<PartnershipModel> dataList;
    private RequestQueue mRequestQueue;
    public String urlbase = "https://gic.itc.edu.kh/";

    //public String lala = "https://gic.itc.edu.kh/storage/events/March2020/R9n6TrTMAnIV57xal0MJ.jpg";


    public PartnershipsFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view  = inflater.inflate(R.layout.fragment_partnerships, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);


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
        final String url = "https://gic.itc.edu.kh/api/v2/partners";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    class OnItemClickListener implements PartnershipAdapter.OnItemClickListener {
                        @Override
                        public void onItemClick(int position) {

                            Intent detailIntent = new Intent(getActivity(), Detail_PartnershipActivity.class);
                            PartnershipModel clickedItem = dataList.get(position);
                            detailIntent.putExtra(EXTRA_URL, clickedItem.getWebsite());
//                            detailIntent.putExtra(EXTRA_URL1, clickedItem.getDetail());
//                            detailIntent.putExtra(EXTRA_URL2, clickedItem.getStart_date());
//                            detailIntent.putExtra(EXTRA_URL3, clickedItem.getEnd_date());
//                            detailIntent.putExtra(EXTRA_URL4, clickedItem.getImageUrl());
//
                            startActivity(detailIntent);
                        }
                    }

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("data");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject hit = jsonArray.getJSONObject(i);

                                String name = hit.getString("name");

                                String logo = hit.getString("logo");
                                String website = hit.getString("website");
                                String imageUrl1 = urlbase + logo;

                                dataList.add(new PartnershipModel(name,imageUrl1,website));
                            }

                            partnershipAdapter = new PartnershipAdapter(getActivity(), dataList);
                            mRecyclerView.setAdapter(partnershipAdapter);
                            partnershipAdapter.setOnItemClickListener(new OnItemClickListener());


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
        Intent detailIntent = new Intent(getActivity(), Detail_PartnershipActivity.class);
        PartnershipModel clickedItem = dataList.get(position);
        startActivity(detailIntent);

    }

}
