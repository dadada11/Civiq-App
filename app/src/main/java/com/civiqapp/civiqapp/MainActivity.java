package com.civiqapp.civiqapp;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.VisibleForTesting;
import android.support.v7.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.support.annotation.VisibleForTesting;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @VisibleForTesting

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("hellomate", "Log");
        AsyncTaskRunner runner = new AsyncTaskRunner();

        runner.execute("h", "h", "h", "h");

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

    //private class AsyncTaskRunner extends AsyncTask<ArrayList<ArrayList<String>>,String, String> {
    private class AsyncTaskRunner extends AsyncTask<String,String,String> {

        public String doInBackground(String... queries) {

            try {
                Document doc = Jsoup.connect("https://news.google.com/news/local/section/geo/Sammamish,%20WA%2098075,%20United%20States/Sammamish,%20Washington?ned=us&hl=en")
                        .data("query", "Java")
                        .userAgent("Chrome")
                        // .referrer("http://www.google.com")
                        .cookie("auth", "token")
                        .timeout(3000)
                        .get();

                String docs = doc.toString();
                int length = docs.length();

                    Elements articles = doc.select("a.ME7ew.hzdq5d");
                    Elements images = doc.select("img.lmFAjc");
                    //Log.d("tequila", elems.toString());
                    for (Element elem : articles) {
                    String href = elem.attr("href");
                    String header = elem.text();
                    Log.d("tequila", href.toString());
                    Log.d("tequila", header.toString());
                Log.d("tequila", images.toString());
                }

                for(int i=0; i<length; i+=1024)
                {
                    if(i+1024<length)
                        Log.d("hellomate", docs.substring(i, i+1024));
                    else
                        Log.d("hellomate", docs.substring(i, length));
                }

                //Log.d("hellomate", doc.toString());
            }
            catch (IOException e) {
                Log.d("hellomatee", e.toString());
            }


            return "error";
        }
        protected void onPostExecute(String e) {

        }
    }
}
