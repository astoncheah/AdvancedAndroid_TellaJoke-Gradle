package com.udacity.gradle.builditbigger;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.example.android.myandroidlibrary.JokeActivity;
import com.example.cheah.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by cheah on 28/2/17.
 */
public class EndpointsAsyncTask extends AsyncTask<Void, Void, String>{
    private static MyApi myApiService = null;
    private Context context;
    private ProgressDialog progress;
    private String jokeType;

    public EndpointsAsyncTask(Context context, String jokeType){
        this.context = context;
        this.jokeType = jokeType;
    }
    @Override
    protected void onPreExecute(){
        super.onPreExecute();
        progress = new ProgressDialog(context);
        progress.setMessage("loading joke...");
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.show();
    }
    @Override
    protected String doInBackground(Void... params) {
        try{
            Thread.sleep(2000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                new AndroidJsonFactory(), null)
                // options for running against local devappserver
                // - 10.0.2.2 is localhost's IP address in Android emulator
                // - turn off compression when running against local devappserver
                .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                    @Override
                    public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                        abstractGoogleClientRequest.setDisableGZipContent(true);
                    }
                });
            // end options for devappserver

            myApiService = builder.build();
        }

        try {
            return myApiService.setJoke(jokeType).execute().getJoke();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        Log.e("onPostExecute",result);
        progress.dismiss();
        Intent i = new Intent(context,JokeActivity.class);
        i.putExtra(JokeActivity.GET_JOKE,result);
        context.startActivity(i);
    }
    @Override
    protected void onCancelled(){
        progress.dismiss();
        super.onCancelled();
    }
}
