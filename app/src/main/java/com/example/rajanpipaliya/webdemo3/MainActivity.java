package com.example.rajanpipaliya.webdemo3;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<data> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.list1);
         arrayList =new ArrayList<>();
        AsyncHttpClient client=new AsyncHttpClient();
        client.addHeader("Accept","application/json");
        client.addHeader("Content-Type","application/json");
        client.get(MainActivity.this,"http://www.jinalshah.brainoorja.com/Country_table_webservice.asmx/get_all_geography_country",new JsonHttpResponseHandler(){
            ProgressDialog dia;
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);

                try {
                    JSONArray array=response.getJSONArray("d");
                    JSONObject object=null;
                    for(int i=0;i<array.length();i++){
                        object=array.getJSONObject(i);
                        arrayList.add(new data(object.getInt("pk_country_id"),object.getString("country_name"),object.getString("region_name"),object.getString("country_flag")));
                    }
                    listView.setAdapter(new custom_adapter(MainActivity.this,arrayList));
                } catch (JSONException e) {
                    e.printStackTrace();

                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                Toast.makeText(MainActivity.this, "INTERNET PROBLEM", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onStart() {
                super.onStart();
                dia=ProgressDialog.show(MainActivity.this,"Loading","Please wait.....");
            }

            @Override
            public void onFinish() {
                super.onFinish();
                dia.dismiss();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
