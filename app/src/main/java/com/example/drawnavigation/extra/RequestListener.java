package com.example.drawnavigation.extra;

import org.json.JSONObject;

public interface RequestListener {
    void onResponseResult(boolean isSuccess, JSONObject data);

}

