package com.example.drawnavigation.fragment;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.example.drawnavigation.R;
import com.example.drawnavigation.adapters.SeminarAdapter;
import com.example.drawnavigation.extra.Keys;
import com.example.drawnavigation.extra.RequestHandler;
import com.example.drawnavigation.extra.RequestListener;
import com.example.drawnavigation.model.SeminarModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SeminarFragment extends Fragment {

    RecyclerView recyclerView;
    private View v ;
    private SeminarAdapter seminarAdapter;
    private ArrayList<SeminarModel> seminarList = new ArrayList<>();
//    public SeminarFragment() {
//        // Required empty public constructor
//    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        Log.d("kk=","dsfsf");
        v = inflater.inflate(R.layout.fragment_seminar, container, false);
        init();
        return v;
    }

    private void init() {

        TextView tx = v.findViewById((R.id.no_data_noticeboard));
        tx.setText("helloooo");
        recyclerView = v.findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        seminarAdapter = new SeminarAdapter(v.getContext());
        recyclerView.setAdapter(seminarAdapter);

        setRequestAPI();

    }
    private void setRequestAPI() {
        String url = "https://gic.itc.edu.kh/api/events";
        RequestHandler requestHandler = new RequestHandler(getContext());


        requestHandler.jsonRequest(url, Request.Method.POST, null, null);
        requestHandler.setResponseListener(new RequestListener() {


            @Override
            public void onResponseResult(boolean isSuccess, JSONObject data) {
                if (isSuccess) {
                    //progressBar.setVisibility(View.GONE);
                    SeminarModel seminarModel = null;
                    try {

                        JSONArray jsonArray = data.getJSONArray(Keys.KEY_DATA);

                        int size = jsonArray.length();
                        if (size == 0) {
                            //  no_data.setVisibility(View.VISIBLE);
                        }

                        for (int i = 0; i < size; i++) {

                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            seminarModel = new SeminarModel();
                            seminarModel.setName(jsonObject.getString(Keys.KEY_NAME));
                            seminarModel.setDatetime(jsonObject.getString(Keys.KEY_DATE));
                            seminarList.add(seminarModel);

                        }

                        seminarAdapter.setSeminarModelList(seminarList);
                        seminarAdapter.notifyDataSetChanged();

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

        });
    }
}
