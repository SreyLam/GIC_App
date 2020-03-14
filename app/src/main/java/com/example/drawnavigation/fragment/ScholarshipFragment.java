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

    private static String[] spacecrafts={"Pioneer","Voyager","Casini","Spirit","Challenger"};
    public ScholarshipFragment(){}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view  = inflater.inflate(R.layout.fragment_scholarship, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);


        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

        ArrayList data = new ArrayList<DataNote>();


        for (int i = 0; i < DataNoteImformation.id.length; i++)
        {
            data.add(
                    new DataNote
                            (
                                    DataNoteImformation.id[i],
                                    DataNoteImformation.textArray[i],
                                    DataNoteImformation.dateArray[i]
                            ));
        }


        mListadapter = new ListAdapter(data);
        mRecyclerView.setAdapter(mListadapter);





        get_response_text=view.findViewById(R.id.get_respone_data);

        sendGetRequest();

//        get_request_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sendGetRequest();
//            }
//        });




        return view;
    }
    private TextView get_response_text,post_response_text;
    private void sendGetRequest() {
//        //get working now
//        //let's try post and send some data to server
        RequestQueue queue= Volley.newRequestQueue(getActivity());
//        String url="https://reactnative.dev/movies.json";
//        StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                get_response_text.setText("Data : "+ response);
//                try {
//                    JSONObject jsonObject = new JSONObject(response);
//                    get_response_text.setText("Data 1 :"+jsonObject.getString("data_1")+"\n");
//                    get_response_text.append("Data 2 :"+jsonObject.getString("data_2")+"\n");
//                    get_response_text.append("Data 3 :"+jsonObject.getString("data_3")+"\n");
//                }
//                catch (Exception e){
//                    e.printStackTrace();
//                    get_response_text.setText("Failed to Parse Json");
//                }
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                get_response_text.setText("Data : Response Failed");
//            }
//        });
//
//        queue.add(stringRequest);

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
