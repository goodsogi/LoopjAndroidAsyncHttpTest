package com.plusapp.loopjandroidasynchttptest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends Activity {

    final String TMAP_APP_KEY = "7d24f284-f63a-3967-b7e2-96ae83161793"; // 티맵 앱 key

    public void getDataFromServer(View view) {


        EditText keywordInput = (EditText) findViewById(R.id.keyword);
        String keyword = keywordInput.getText().toString();

        String url = "https://apis.skplanetx.com/tmap/pois?version=1&appKey=" + TMAP_APP_KEY
                + "&reqCoordType=WGS84GEO&resCoordType=WGS84GEO" + "&searchKeyword=" + keyword;

        AsyncHttpClient client = new AsyncHttpClient();
//        client.get(url, new AsyncHttpResponseHandler() {
//
//            @Override
//            public void onStart() {
//                // called before request is started
//                Log.d("tmapapi", "onStart");
//            }
//
//            @Override
//            public void onSuccess(int statusCode, Header[] headers, byte[] response) {
//                // called when response HTTP status is "200 OK"
//                Log.d("tmapapi", "onSuccess: " +response.toString() );
//            }
//
//            @Override
//            public void onFailure(int statusCode, Header[] headers, byte[] errorResponse, Throwable e) {
//                // called when response HTTP status is "4XX" (eg. 401, 403, 404)
//                Log.d("tmapapi", "onFailure");
//            }
//
//            @Override
//            public void onRetry(int retryNo) {
//                // called when request is retried
//                Log.d("tmapapi", "onRetry");
//            }
//        });

        client.get(url,null, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                // If the response is JSONObject instead of expected JSONArray
                Log.d("tmapapi", "onSuccess: " +response.toString() );
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                // Pull out the first event on the public timeline
                Log.d("tmapapi", "onSuccess: " +response.toString() );
//                JSONObject firstEvent = null;
//                try {
//                    firstEvent = (JSONObject) timeline.get(0);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//                String tweetText = null;
//                try {
//                    tweetText = firstEvent.getString("text");
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
//                // Do something with the response
//                System.out.println(tweetText);
            }
        });
    }






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
