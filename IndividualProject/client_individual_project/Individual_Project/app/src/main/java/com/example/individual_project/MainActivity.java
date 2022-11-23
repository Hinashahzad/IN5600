package com.example.individual_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {
    private Button get_button, post_button;
    private TextView send_data;
    private TextView receive_data;
    private RequestQueue requestQueue,requestQueue2;
    private Cache cache, cache1;
    private Network network, post_network;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Extract Data from the Buttons and Text views
        get_button = (Button) findViewById(R.id.getbutton);
        post_button=(Button)findViewById(R.id.postbutton);
        receive_data = (TextView) findViewById(R.id.textView);
        send_data=(TextView) findViewById(R.id.textView2);
    }
    // Get Method Button Listener
    public void getMethodTesting(View view){
        send_data.setText("Server Response");
        // Instantiate the cache
        cache = new DiskBasedCache(getCacheDir(), 1024 * 1024); // 1MB cap
        network = new BasicNetwork(new HurlStack());
        requestQueue= new RequestQueue(cache, network);
        requestQueue.start();
        StringRequest getRequest = new StringRequest(Request.Method.GET, "http://10.0.2.2:8080/getMethodTesting", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                receive_data.setText(response);
                Toast.makeText(MainActivity.this, "Get Method has been invoked Successfully from the server side and Server Response is "+response,Toast.LENGTH_SHORT).show();
                requestQueue.stop();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                receive_data.setText("That didn't work");
                error.printStackTrace();
            }
        });
        requestQueue.add(getRequest);

    }
    // Post Method Button Listener:
    public void postMethodTesting(View view){
        receive_data.setText("Server Response");
        post_network =new BasicNetwork(new HurlStack());
        cache1=new DiskBasedCache(getCacheDir(), 1024 * 1024);
        requestQueue2= new RequestQueue(cache1,post_network);
        requestQueue2.start();

        StringRequest postRequest = new StringRequest(Request.Method.POST, "http://10.0.2.2:8080/postMethodTesting", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                send_data.setText(response);
                Toast.makeText(MainActivity.this, "Post Method has been invoked Successfully from the server side and Server Response is "+response,Toast.LENGTH_SHORT).show();
                requestQueue2.stop();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                send_data.setText("That didn't work");
                error.printStackTrace();
            }
        });
        requestQueue2.add(postRequest);
    }
}

