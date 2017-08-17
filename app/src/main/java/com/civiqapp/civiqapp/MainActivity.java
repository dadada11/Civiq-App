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

        public ArrayList<ArrayList<String>> doInBackground(String... queries)
        {
            ArrayList<Arraylist<String>> updates = new ArrayList<Arraylist<String>>();

            for(String query : queries)
            {
                if(query.startsWith("https://news.google.com/news/local") // ISSA HTML
                {
                    String article = "article";
                    try
                    {
                        Document doc = Jsoup.connect(query)
                                .data("query", "Java")
                                .userAgent("Chrome")
                                .cookie("auth", "token")
                                .timeout(3000)
                                .get();

                        String docs = doc.toString();
                        int length = docs.length();
                        Elements articles = doc.select("a.ME7ew.hzdq5d");
                        Elements images = doc.select("img.lmFAjc");
                        Elements dates = doc.select("span.d5kXP.YBZVLb");
                        //Log.d("tequila", elems.toString());
                        Arraylist<String> update = new Arraylist<String>(); // order is type of post, url, headline, date, image
                        for (Element elem : articles)
                        {
                            update.add(article);
                            update.add(elem.attr("href").toString());
                            update.add(elem.text().toString());
                            update.add()
                            Log.d("tequila", href.toString());
                            Log.d("tequila", header.toString());
                            Log.d("tequila", images.toString());
                        }
                    }

                    catch (IOException e)
                    {
                        Log.d("hellomatee", e.toString());
                    }
                }

            }


            return ?;
        }
        protected void onPostExecute(String e) {

        }
    }
}
