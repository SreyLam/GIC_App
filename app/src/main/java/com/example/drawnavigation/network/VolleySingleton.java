package com.example.drawnavigation.network;

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


    private VolleySingleton()
    {
        mRequestQueue= Volley.newRequestQueue(Applications.getAppInstance());


//        mImageLoader=new ImageLoader(mRequestQueue, new ImageLoader.ImageCache() {
//            private LruCache<String, Bitmap>
//                    cache=new LruCache<>((int)(Runtime.getRuntime().maxMemory()/1024)/8);
//            @Override
//            public Bitmap getBitmap(String url) {
//                return cache.get(url);
//            }
//
//            @Override
//            public void putBitmap(String url, Bitmap bitmap) {
//                cache.put(url,bitmap);
//            }
//        });
    }
    public static VolleySingleton getInstance(){
        if(volleyInstance==null)
        {
            volleyInstance=new VolleySingleton();
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


