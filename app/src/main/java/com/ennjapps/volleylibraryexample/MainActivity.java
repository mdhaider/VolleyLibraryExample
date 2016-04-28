package com.ennjapps.volleylibraryexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private RequestQueue mRequestQueue;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String url = "https://reddit.com/r/all.json?limit=1";

        mRequestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest reqobj = new JsonObjectRequest(url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try{
                            String result=response.toString();
                            textView=(TextView)findViewById(R.id.textView);
                            textView.setText(result);

                        }catch (Exception e) {
                            e.printStackTrace();

                        }
                    }
                }, new ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,"error",Toast.LENGTH_LONG).show();

            }
        });
mRequestQueue.add(reqobj);
    }
}
