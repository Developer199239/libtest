package com.example.librarymaking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.murtuzarahman.mylibtesting.MyLibCallback;
import com.murtuzarahman.mylibtesting.MyLibManager;

public class MainActivity extends AppCompatActivity implements MyLibCallback {
    private MyLibManager myLibManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        myLibManager = MyLibManager.getInstance ();

        Button button = findViewById (R.id.button);
        button.setOnClickListener (v -> {
            myLibManager.initializeMyLib (this,this);
        });
    }

    @Override
    public void onConnectionStatus(int connectionStatus, String message) {
        Toast.makeText (this, message, Toast.LENGTH_LONG).show ();
    }

    @Override
    public void onPTTStatus(int event, String msg) {
        Toast.makeText (this, msg, Toast.LENGTH_LONG).show ();
    }

    @Override
    public void loadSuccess(String msg) {
        Toast.makeText (this, msg, Toast.LENGTH_LONG).show ();
    }
}
