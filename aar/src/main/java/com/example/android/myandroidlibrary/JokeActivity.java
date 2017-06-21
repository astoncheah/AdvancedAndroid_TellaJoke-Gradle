package com.example.android.myandroidlibrary;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by cheah on 28/2/17.
 */
public class JokeActivity extends AppCompatActivity{
    public static final String GET_JOKE = "GET_JOKE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        String newString;
        if(extras == null) {
            newString = "there is no joke..";
        } else {
            newString = extras.getString(GET_JOKE);
        }
        //tellJoke(newString);

        TextView textView = new TextView(this);
        textView.setText(newString);
        textView.setGravity(Gravity.CENTER);
        if (Build.VERSION.SDK_INT < 23) {
            textView.setTextAppearance(this, android.R.style.TextAppearance_DeviceDefault_Large);
        } else {
            textView.setTextAppearance(android.R.style.TextAppearance_DeviceDefault_Large);
        }
        this.addContentView(textView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
    }
}
