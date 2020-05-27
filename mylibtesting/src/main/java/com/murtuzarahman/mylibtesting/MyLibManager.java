package com.murtuzarahman.mylibtesting;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;

/**
 * Created by Murtuza Rahman on 5/27/20.
 */
public class MyLibManager {
    @SuppressLint("StaticFieldLeak")
    private static MyLibManager instance = null;
    private Context mContext;
    private MyLibCallback myLibCallback;
    private boolean isSessionLive;

    public static MyLibManager getInstance() {
        if (instance == null) {
            synchronized (MyLibManager.class) {
                if (instance == null) {
                    instance = new MyLibManager ();
                }
            }
        }
        return instance;
    }

    public void initializeMyLib(Context context, MyLibCallback myLibCallback){
        this.mContext = context;
        this.myLibCallback = myLibCallback;
        gettingInfo ();
    }

    private void gettingInfo(){
        if (!isSessionLive) {
            Handler mainHandler = new Handler (Looper.getMainLooper ());
            Runnable myRunnable;
            myRunnable = () -> {
                String msg = "ptt already connected";
                myLibCallback.onConnectionStatus (1, msg);
                isSessionLive = false;
            };
            mainHandler.postDelayed (myRunnable, 5000);
            isSessionLive = true;
        }
    }
}
