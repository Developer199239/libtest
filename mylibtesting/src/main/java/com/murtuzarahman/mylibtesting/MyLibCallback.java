package com.murtuzarahman.mylibtesting;

/**
 * Created by Murtuza Rahman on 5/27/20.
 */
public interface MyLibCallback {
    void onConnectionStatus(int connectionStatus, String message);
    void onPTTStatus(int event, String msg);
    void loadSuccess(String msg);
}
