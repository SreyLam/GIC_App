package com.example.drawnavigation.extra;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.drawnavigation.network.VolleySingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class RequestHandler
{
    private Context ctx;
    public RequestHandler(Context ctx) {
        this.ctx = ctx;
    }

    private RequestListener requestListener;

    public void setResponseListener(RequestListener requestListener) {
        this.requestListener = requestListener;
    }

    public void jsonRequest(String url, final int method, final JSONObject header, final JSONObject body) {

        try {
            if (method == Request.Method.GET && null != body && body.length() > 0) {
                JSONArray keys = body.names();
                url = url.concat("?");
                for (int i = 0; i < keys.length(); i++) {
                    url = url.concat(keys.getString(i)).concat("=").concat(body.getString(keys.getString(i))).concat("&");
                }
                url = url.substring(0, url.length() - 1);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(method, url, body, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                requestListener.onResponseResult(true, response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                try {
                    VolleyError errors = new VolleyError(new String(error.networkResponse.data));

                    JSONObject err = new JSONObject();
                    err.put("status_code", error.networkResponse.statusCode);
                    err.put("message", errors.getMessage());
                    requestListener.onResponseResult(false, err);

                } catch (Exception e) {
                    requestListener.onResponseResult(false, new JSONObject());
                    e.printStackTrace();
                }
            }
        })
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError
            {
                Map<String, String> params = new HashMap<>();

              //params.put("Content-Type", "application/json; charset=utf-8");// params.put("Accept", "application/json");
//                params.put(Keys.KEY_ACCESS_KEY, Keys.KEY_ACCESS_KEY_VALUE);
                if (header == null) return params;
                try {
                    JSONArray headerKeys = new JSONArray();
                    if (header.names() != null) headerKeys = header.names();
                    for (int i = 0; i < headerKeys.length(); i++) {
                        params.put(headerKeys.getString(i), header.getString(headerKeys.getString(i)));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return params;
            }
        };

        try
        {
            RequestQueue mRequestQueue= VolleySingleton.getInstance(ctx).getRequestQueue();
            mRequestQueue.add(jsonObjectRequest);
        }
        catch (NullPointerException npe)
        {
            npe.printStackTrace();
        }
    }
}
