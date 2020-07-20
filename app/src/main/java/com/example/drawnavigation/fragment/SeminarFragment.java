package com.example.drawnavigation.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
import com.example.drawnavigation.Detail_SeminarActivity;
import com.example.drawnavigation.R;
import com.example.drawnavigation.adapters.SeminarAdapter;
import com.example.drawnavigation.model.SeminarModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 */
public class SeminarFragment extends Fragment implements SeminarAdapter.OnItemClickListener {
    public static final String EXTRA_URL = "name";
    public static final String EXTRA_URL4 = "image";
    public static final String EXTRA_URL1 = "detail";
    public static final String EXTRA_URL2 = "start_date";
    public static final String EXTRA_URL3 = "end_date";

    private TextView mTextViewEmpty;
    private ImageView mImageViewEmpty;
    private RecyclerView mRecyclerView;
    private SeminarAdapter seminarAdapter;
    private ArrayList<SeminarModel> dataList;
    private RequestQueue mRequestQueue;
    public String urlbase = "https://gic.itc.edu.kh/storage/";

    //public String lala = "https://gic.itc.edu.kh/storage/events/March2020/R9n6TrTMAnIV57xal0MJ.jpg";


    public SeminarFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view  = inflater.inflate(R.layout.fragment_seminar, container, false);

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
        final String url = "https://gic.itc.edu.kh/api/events";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    class OnItemClickListener implements SeminarAdapter.OnItemClickListener {
                        @Override
                        public void onItemClick(int position) {

                            Intent detailIntent = new Intent(getActivity(), Detail_SeminarActivity.class);
                            SeminarModel clickedItem = dataList.get(position);
                            detailIntent.putExtra(EXTRA_URL, clickedItem.getName());
                            detailIntent.putExtra(EXTRA_URL1, clickedItem.getDetail());
                            detailIntent.putExtra(EXTRA_URL2, clickedItem.getStart_date());
                            detailIntent.putExtra(EXTRA_URL3, clickedItem.getEnd_date());
                            detailIntent.putExtra(EXTRA_URL4, clickedItem.getImageUrl());
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
                                String start_date = hit.getString("start_date");
                                String end_date = hit.getString("end_date");
                                String detail = hit.getString("detail");
                                String imageUrl = hit.getString("image");
                                String imageUrl1 = urlbase + imageUrl;

//                                SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                                Date date = dateFormat.parse(start_date, );

                                dataList.add(new SeminarModel(name,start_date,end_date, imageUrl1, detail));
                            }

                            seminarAdapter = new SeminarAdapter(getActivity(), dataList);
                            mRecyclerView.setAdapter(seminarAdapter);
                            seminarAdapter.setOnItemClickListener(new OnItemClickListener());


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
        Intent detailIntent = new Intent(getActivity(), Detail_SeminarActivity.class);
        SeminarModel clickedItem = dataList.get(position);
        startActivity(detailIntent);

    }

//    private RecyclerView recyclerView;
//    private View v ;
//    private SeminarAdapter seminarAdapter;
//    private ArrayList<SeminarModel> seminarList = new ArrayList<>();
//    public SeminarFragment() {
//        // Required empty public constructor
//    }


//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
////        Log.d("kk=","dsfsf");
//        v = inflater.inflate(R.layout.fragment_seminar, container, false);
//        setRequestAPI();
//
//        return v;
//    }
//
////    private void init() {
////
////        TextView tx = v.findViewById((R.id.no_data_noticeboard));
////        tx.setText("helloooo");
////        recyclerView = v.findViewById(R.id.recycler_view);
////        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
////        recyclerView.setLayoutManager(layoutManager);
////        seminarAdapter = new SeminarAdapter(v.getContext());
////        recyclerView.setAdapter(seminarAdapter);
////
////        setRequestAPI();
////
////
////    }
//
//    private static final String TAG = "MyActivity";
//
//    private void setRequestAPI() {
//        String url = "https://gic.itc.edu.kh/api/events";
//        RequestHandler requestHandler = new RequestHandler(getContext());
//
//
//        requestHandler.jsonRequest(url, Request.Method.GET, null, null);
//        requestHandler.setResponseListener(new RequestListener() {
//
//
//            @Override
//            public void onResponseResult(boolean isSuccess, JSONObject data) {
//                if (isSuccess) {
//                    //progressBar.setVisibility(View.GONE);
//                    SeminarModel seminarModel = null;
//                    try {
//
//                        JSONArray jsonArray = data.getJSONArray(Keys.KEY_DATA);
//                        Log.v(TAG, "index=");
//                        int size = jsonArray.length();
//                        if (size == 0) {
//                            //  no_data.setVisibility(View.VISIBLE);
//                        }
//
//                        for (int i = 0; i < size; i++) {
//
//                            JSONObject jsonObject = jsonArray.getJSONObject(i);
//                            seminarModel = new SeminarModel();
//                            seminarModel.setName(jsonObject.getString(Keys.KEY_NAME));
//                            seminarModel.setDatetime(jsonObject.getString(Keys.KEY_DATE));
//                            seminarList.add(seminarModel);
//
//                        }
//
//                        seminarAdapter.setSeminarModelList(seminarList);
//                        seminarAdapter.notifyDataSetChanged();
//
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//
//        });
//    }
}
