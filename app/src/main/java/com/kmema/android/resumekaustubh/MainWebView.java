package com.kmema.android.resumekaustubh;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Switch;

/**
 * Created by kmema on 12/15/2017.
 */

public class MainWebView extends Fragment {

    private WebView webViewMain;


    @SuppressLint("SetJavaScriptEnabled")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_main_web_view, container, false);
        webViewMain = view.findViewById(R.id.mainWebView);
        webViewMain.setWebViewClient(new WebViewClient());
        webViewMain.getSettings().setJavaScriptEnabled(true);
        webViewMain.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webViewMain.getSettings().setPluginState(WebSettings.PluginState.ON);
        webViewMain.getSettings().setMediaPlaybackRequiresUserGesture(false);
        webViewMain.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webViewMain.getSettings().setAppCachePath(getActivity()
                        .getApplicationContext()
                        .getCacheDir()
                        .getAbsolutePath());
        webViewMain.setWebChromeClient(new WebChromeClient());
        webViewMain.loadUrl(MainActivity.MAIN_URL);

        webViewMain.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if(keyEvent.getAction() == KeyEvent.ACTION_DOWN)
                {
                    WebView webView = (WebView) view;
                    switch(keyCode)
                    {
                        case KeyEvent.KEYCODE_BACK:

                            if(webView.canGoBack())
                            {
                                webView.goBack();
                                return true;
                            }
                            break;
                    }
                }
                return false;
            }
        });

        return view;
    }


}
