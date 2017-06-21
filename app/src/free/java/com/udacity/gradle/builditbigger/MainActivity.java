package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.MyJoke;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class MainActivity extends AppCompatActivity {
    public InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prepareAds();
        //Button btn = (Button) findViewById(R.id.btn_click);
        //btn.performClick();
        Log.e("MainActivity","onCreate free version");
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
    private void prepareAds(){
        AdRequest adRequest = new AdRequest.Builder()
            .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
            .build();

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdClosed(){
                new EndpointsAsyncTask(MainActivity.this,MyJoke.JOKE_FREE_WITH_ADS).execute();
            }
            @Override
            public void onAdLoaded(){
            }
        });
        mInterstitialAd.loadAd(adRequest);
    }
    public void tellJoke(View view) {
        if(mInterstitialAd!=null && mInterstitialAd.isLoaded()){
            mInterstitialAd.show();
        }else{
            new EndpointsAsyncTask(MainActivity.this,MyJoke.JOKE_FREE_WITHOUT_ADS).execute();
        }
    }
}
