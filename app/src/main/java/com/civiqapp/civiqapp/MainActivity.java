package com.civiqapp.civiqapp;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.VisibleForTesting;
import android.support.v7.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.support.annotation.VisibleForTesting;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @VisibleForTesting

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            Document doc = Jsoup.connect("http://example.com")
                    .data("query", "Java")
                    .userAgent("Mozilla")
                    .cookie("auth", "token")
                    .timeout(3000)
                    .post();
            String title = doc.title();
            Log.d("damnitworksdamn", title);
        }
        catch (IOException e) {
            Log.d("ripdoesntwork", "yoooo rippppp");
        }
    }
    public ProgressDialog mProgressDialog;

    public void showProgressDialog() {
        Log.d("theanswer", "worked nice");
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
           // mProgressDialog.setMessage(getString(R.string.loading));
            mProgressDialog.setIndeterminate(true);
        }



        mProgressDialog.show();
    }

    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        hideProgressDialog();
    }

}
