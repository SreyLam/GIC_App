package com.example.drawnavigation.network;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.example.drawnavigation.application.Applications;

/**
 * Created by USER on 6/29/2017.
 */

public class VolleySingleton {
    private static VolleySingleton volleyInstance=null;
    private ImageLoader mImageLoader;
    private RequestQueue mRequestQueue;
    private static Context ctx;


    private VolleySingleton(Context context)
    {
        mRequestQueue= Volley.newRequestQueue(Applications.getAppInstance());

        mImageLoader=new ImageLoader(mRequestQueue, new ImageLoader.ImageCache() {
            private LruCache<String, Bitmap>
                    cache=new LruCache<>((int)(Runtime.getRuntime().maxMemory()/1024)/8);
            @Override
            public Bitmap getBitmap(String url) {
                return cache.get(url);
            }

            @Override
            public void putBitmap(String url, Bitmap bitmap) {
                cache.put(url,bitmap);
            }
        });
    }

    public static VolleySingleton getInstance(Context ctx){
        if(volleyInstance==null)
        {
            volleyInstance=new VolleySingleton(ctx);
        }
        return volleyInstance;
    }
    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }

    public RequestQueue getRequestQueue()
    {
        return mRequestQueue;
    }
    public ImageLoader getImageLoader()
    {
        return mImageLoader;
    }


}


