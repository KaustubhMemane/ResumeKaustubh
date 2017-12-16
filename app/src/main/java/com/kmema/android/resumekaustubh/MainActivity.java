package com.kmema.android.resumekaustubh;

import android.app.FragmentManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebViewFragment;

public class MainActivity extends AppCompatActivity {

    Bundle bundle;
    MainWebView mainWebView ;
    FragmentManager fragmentManager;
    public static String TAG_LINK ="param";
    public static final String MAIN_URL = "http://www.kaustubhmemane.com";
    public static final String LINKEDIN_URL = "https://www.linkedin.com/in/kaustubhmemane/";
    public static final String GITHUB_URL = "https://github.com/KaustubhMemane";
    public static final String YOUTUBE_URL = "https://www.youtube.com/channel/UCvgNLr33VVf0ZCUiYphJjBQ";
    public static final String INSTAGRAM_URL = "https://www.instagram.com/kaustubh_memane/";

    BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {


            switch (item.getItemId())
            {
                case R.id.navPersonalWebsite:
                    bundle = new Bundle();
                    bundle.putString(TAG_LINK,MAIN_URL);
                    mainWebView.setArguments(bundle);
                    fragmentManager.popBackStack();
                    fragmentManager.beginTransaction().replace(R.id.fragment_container,mainWebView).commit();
                    return true;

                case R.id.navGitHub:
                    bundle = new Bundle();
                    bundle.putString(TAG_LINK,GITHUB_URL);
                    mainWebView.setArguments(bundle);
                    fragmentManager.popBackStack();
                    fragmentManager.beginTransaction().replace(R.id.fragment_container,mainWebView).commit();

                    return true;

                case R.id.navInstagram:
                    bundle = new Bundle();
                    bundle.putString(TAG_LINK,INSTAGRAM_URL);
                    mainWebView.setArguments(bundle);
                    fragmentManager.beginTransaction().replace(R.id.fragment_container,mainWebView).commit();
                    return true;

                case R.id.navLinkedIn:
                    bundle = new Bundle();
                    bundle.putString(TAG_LINK,LINKEDIN_URL);
                    mainWebView.setArguments(bundle);
                    fragmentManager.popBackStack();
                    fragmentManager.beginTransaction().replace(R.id.fragment_container,mainWebView).commit();
                    return true;

                case R.id.navYouTube:
                    bundle = new Bundle();
                    bundle.putString(TAG_LINK,YOUTUBE_URL);
                    mainWebView.setArguments(bundle);
                    fragmentManager.beginTransaction().replace(R.id.fragment_container,mainWebView).commit();
                    return true;
            }
            return false;
        }
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = findViewById(R.id.navBottom);
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        loadMainWebPage();
    }



    public void loadMainWebPage()
    {
        fragmentManager = getFragmentManager();
        mainWebView = new MainWebView();
        bundle = new Bundle();
        bundle.putString(TAG_LINK,MAIN_URL);
        mainWebView.setArguments(bundle);
        fragmentManager.beginTransaction().add(R.id.fragment_container,mainWebView).commit();
    }
}
