package com.example.footballapps;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class jadwal extends AppCompatActivity {
    private String TAG = jadwal.class.getSimpleName();

    private ProgressDialog pDialog;
    private ListView lv;
    private static String url = "https://www.thesportsdb.com/api/v1/json/1/eventspastleague.php?id=4328";

    ArrayList<HashMap<String, String>> contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tayang);

        contactList = new ArrayList<>();

        lv = (ListView) findViewById(R.id.list);

        new GetContacts().execute();
    }


    private class GetContacts extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(jadwal.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();
            String jsonStr = sh.makeServiceCall(url);

            Log.e(TAG, "Response from url: " + jsonStr);

            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);


                    JSONArray events = jsonObj.getJSONArray("events");

                    for (int i = 0; i < events.length(); i++) {
                        JSONObject c = events.getJSONObject(i);

                        String strEvent = c.getString("strEvent");
                        String strFilename = c.getString("strFilename");
                        String strTime = c.getString("strTime");
                        String strVenue = c.getString("strVenue");
                        String strSeason = c.getString("strSeason");

                        HashMap<String, String> schedule = new HashMap<>();


                        schedule.put("strEvent", strEvent);
                        schedule.put("strFilename", strFilename);
                        schedule.put("strTime", strTime);
                        schedule.put("strVenue", strVenue);
                        schedule.put("strSeason", strSeason);

                        contactList.add(schedule);
                    }
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG)
                                    .show();
                        }
                    });

                }
            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });

            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            if (pDialog.isShowing())
                pDialog.dismiss();

            ListAdapter adapter = new SimpleAdapter(
                    jadwal.this, contactList,
                    R.layout.jadwal_item, new String[]{"strEvent","strFilename", "strTime",
                    "strVenue", "strSeason"}, new int[]{R.id.strEvent,R.id.strFilename, R.id.strTime,
                     R.id.strVenue,  R.id.strSeason});

            lv.setAdapter(adapter);
        }

    }
}

