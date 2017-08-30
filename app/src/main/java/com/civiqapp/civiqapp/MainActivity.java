package com.civiqapp.civiqapp;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.VisibleForTesting;
import android.support.v7.app.AppCompatActivity;

import android.view.Menu;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @VisibleForTesting

    public TextView something;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("hellomate", "Log");

        AsyncTaskRunner runner = new AsyncTaskRunner();

        runner.execute("h", "h", "h", "h");
        //something = (TextView) findViewById(R.id.textView);
        //something.setText("hoe");
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
    private class AsyncTaskRunner extends AsyncTask<String,String,ArrayList<ArrayList<String>>> {
        Element elem;
        public ArrayList<ArrayList<String>> doInBackground(String... queries)
        {
            ArrayList<ArrayList<String>> updates = new ArrayList<ArrayList<String>>();


            //for(String query : queries)
           // {
                //if(query.startsWith("https://news.google.com/news/search/section/q/gun%20control%20WA/gun%20control%20WA?hl=en&ned=us"); // ISSA HTML
               // {
                    String article = "article";
                    try
                    {

                        Document doc = Jsoup.connect("https://news.google.com/news/local/section/geo/Sammamish,%20WA%2098075,%20United%20States/Sammamish,%20Washington?ned=us&hl=en")
                                .data("query", "Java")
                                .userAgent("Chrome")
                                .cookie("auth", "token")
                                .timeout(3000)
                                .get();

                        String docs = doc.toString();
                        int length = docs.length();
                        Elements articles = doc.select("a.ME7ew.hzdq5d");
                        Elements images = doc.select("img.lmFAjc");
                        Elements imghref= doc.select("a.MWG8ab");
                        Elements dates = doc.select("span.d5kXP.YBZVLb");
                        //Log.d("tequila", elems.toString());

                        //for (Element elem : articles)
                        int imgcount = 0;

                        ArrayList<String> update = new ArrayList<String>();;
                        for (int i = 0; i <= images.size() - 1; i++)
                        {
                            update = new ArrayList<String>();
                            Element img = images.get(i);
                            elem = articles.get(imgcount);
                            Element date = dates.get(imgcount);
                            if (imghref.get(i).attr("href").equals(articles.get(i).attr("href"))) {
                               // Log.d("tequilas", String.valueOf(images.size()));
                               // Log.d("tequila", "matches");
                            }
                            else {
                                while (!(imghref.get(i).attr("href").equals(articles.get(imgcount).attr("href"))) ) {
                                    //Log.d("tequila", "don't matches");
                                    imgcount++;
                                }

                            }

                            update.add("article");
                            update.add(elem.attr("href"));
                            update.add(elem.text());
                            update.add(date.text());
                            update.add(img.attr("src"));
                            //Log.d("whiskey", Arrays.deepToString(update.toArray()));
                            updates.add(update);

//                            Log.d("tequila", elem.toString());
//                            Log.d("tequila",img.toString());
//                            Log.d("tequila", images.get(imgcount).toString());
//                            Log.d("tequila", date.toString());
                            // order is type of post, url, headline, date, image
                            imgcount ++;

                        }
                        for (ArrayList<String> i:updates) {
                            Log.d("whiskey", Arrays.deepToString(i.toArray()));

                        }

                        String updateArr[] = new String[update.size()];

                        updateArr = update.toArray(updateArr);
                        ArrayAdapter adapter = new ArrayAdapter<String>(MainActivity.this, R.layout.activity_main, updateArr);

                    }

                    catch (IOException e)
                    {
                        Log.d("hellomatee", e.toString());
                    }
                //}

           // }
//

            return updates;
        }
        protected void onPostExecute(String e) {

            //something.setText(elem.toString());
        }
    }
}
