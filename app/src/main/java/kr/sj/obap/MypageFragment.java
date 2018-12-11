package kr.sj.obap;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ListView;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.ButterKnife;

import static kr.sj.obap.R.id.webView;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.theartofdev.edmodo.cropper.CropImage;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
//import java.util.Date;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

public class MypageFragment extends Fragment {

    private WebView mWebView;

    @SuppressLint("ClickableViewAccessibility")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view =  inflater.inflate(R.layout.fragment_mypage,container,false);
        String myUrl = "http://52.78.67.243:8000";

        //websetting은 캐시, 자바스크립트 등의 기능 설정
//        WebSettings webSettings =  mWebView.getSettings();
//        webSettings.setAppCacheEnabled(false);
        //ButterKnife.bind(this);

        // 웹뷰 셋
        mWebView = (WebView)view.findViewById(webView);
        mWebView.setNetworkAvailable(true);
        //mWebView.loadUrl("http://www.pois.co.kr/mobile/login.do");

        mWebView.loadUrl(myUrl + "/obap/"); // 접속 URL
        mWebView.setWebChromeClient(new WebChromeClient());
        mWebView.setWebViewClient(new WebViewClientClass());

        //// Sets whether the DOM storage API is enabled.
        mWebView.getSettings().setDomStorageEnabled(true);
        mWebView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);

        //캐시 지우는 용
        mWebView.clearCache(true);
        mWebView.clearHistory();
        mWebView.clearFormData();

        mWebView.getSettings().setJavaScriptEnabled(true);

        WebSettings ws = mWebView.getSettings();

        ws.setJavaScriptEnabled(true);

        //웹에서 선호도조사하러가가기 버튼 누르면 이 함수 작동
        mWebView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface           // For API 17+
            public void performClick(String strl)
            {

                //프래그먼트 생성 (선호도조사)
                Fragment fragment;
                //fragment = new FoodLikeFragement();

                fragment= FoodLikeFragement.newInstance();
                setChildFragment(fragment);

            }
        }, "ok");

        return view;
    }

    //webview------------------------

    private class WebViewClientClass extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Log.d("check URL",url);
            view.loadUrl(url);
            return true;
        }
    }

    private void setChildFragment(Fragment child) {
        FragmentTransaction childFt = getChildFragmentManager().beginTransaction();

        if (!child.isAdded()) {
            childFt.replace(R.id.child_fragment_container, child);
            childFt.addToBackStack(null);
            childFt.commit();
        }
    }
/*

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {
            mWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }*/
    //------------------------------------------------------


}
