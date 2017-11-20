package com.meredithbayne.earthquaketracker;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.meredithbayne.earthquaketracker.datamodel.Earthquake;
import com.meredithbayne.earthquaketracker.util.API;
import com.meredithbayne.earthquaketracker.util.EarthquakeJsonUtils;

import org.json.JSONException;

import java.net.URL;
import java.util.List;

/**
 * Created by meredithbayne on 10/21/17
 */

public class MainActivity extends AppCompatActivity {

    private RecyclerView mEarthquakeRecyclerView;
    private EarthquakeAdapter mEarthquakeAdapter;
    private TextView mErrorMessage;
    private ProgressBar mLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEarthquakeRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_earthquake);
        mErrorMessage = (TextView) findViewById(R.id.error_message);
        mLoading = (ProgressBar) findViewById(R.id.loading);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mEarthquakeRecyclerView.setLayoutManager(layoutManager);

        mEarthquakeRecyclerView.setHasFixedSize(true);

        mEarthquakeAdapter = new EarthquakeAdapter();
        mEarthquakeRecyclerView.setAdapter(mEarthquakeAdapter);

        loadEarthquakeData();
    }

    private void loadEarthquakeData() {
        showEarthquakeDataView();
        new EarthquakeTask().execute();
    }

    private void showEarthquakeDataView() {
        mEarthquakeRecyclerView.setVisibility(View.VISIBLE);
        mErrorMessage.setVisibility(View.INVISIBLE);
    }

    private void showErrorMessage() {
        mEarthquakeRecyclerView.setVisibility(View.INVISIBLE);
        mErrorMessage.setVisibility(View.VISIBLE);
    }

    public class EarthquakeTask extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mLoading.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... params) {
            URL earthquakeRequestUrl = API.buildURl();

            try {
                String jsonResponse = API.getResponseFromHttpUrl(earthquakeRequestUrl);
                return jsonResponse;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(String result) {
            mLoading.setVisibility(View.INVISIBLE);
            List<Earthquake> earthquakeData;

            try {
                showEarthquakeDataView();
                earthquakeData = EarthquakeJsonUtils.getEarthquakeStrings(result);
                mEarthquakeAdapter.setEarthquakeData(earthquakeData);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
