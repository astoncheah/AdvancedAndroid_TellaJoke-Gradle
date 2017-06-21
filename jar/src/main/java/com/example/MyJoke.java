package com.example;

public class MyJoke{
    public static final String JOKE_FREE_WITH_ADS = "JOKE_FREE_WITH_ADS";
    public static final String JOKE_FREE_WITHOUT_ADS = "JOKE_FREE_WITHOUT_ADS";
    public static final String JOKE_PAID = "JOKE_PAID";

    public static String getJoke(String val){
        switch(val){
            case JOKE_FREE_WITH_ADS:
                return getFreeJokeWithAds();
            case JOKE_FREE_WITHOUT_ADS:
                return getFreeJokeWithoutAds();
            case JOKE_PAID:
                return getPaidJoke();
        }
        return "no jokes found";
    }
    private static String getFreeJokeWithAds(){
        return "this is my free joke with ads";
    }
    private static String getFreeJokeWithoutAds(){
        return "this is my free joke without ads";
    }
    private static String getPaidJoke(){
        return "this is my paid joke";
    }
}
