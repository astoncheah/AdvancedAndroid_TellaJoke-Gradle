package com.example.android.myandroidlibrary;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class AndroidTest{
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);
    @Test
    public void test1(){
        final MainActivity activity = mActivityRule.getActivity();
        try{
            mActivityRule.runOnUiThread(new Runnable(){
                @Override
                public void run(){
                    activity.tellJoke(null);
                }
            });
        }catch(Throwable throwable){
            throwable.printStackTrace();
        }
    }
}
