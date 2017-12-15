package com.kmema.android.resumekaustubh;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebViewFragment;

public class MainActivity extends AppCompatActivity {

    public static final String MAIN_URL = "http://www.kaustubhmemane.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadMainWebPage();
    }



    public void loadMainWebPage()
    {
        MainWebView mainWebView = new MainWebView();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().add(R.id.fragment_container,mainWebView).commit();

    }
}
