/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/
package com.example.cheah.myapplication.backend;

import com.example.MyJoke;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

/**
 * An endpoint class we are exposing
 */
@Api(
    name = "myApi",
    version = "v1",
    namespace = @ApiNamespace(
        ownerDomain = "backend.myapplication.cheah.example.com",
        ownerName = "backend.myapplication.cheah.example.com",
        packagePath = ""))
public class MyEndpoint{
    @ApiMethod(name = "setJoke")
    public MyJokeUtil setJoke(@Named("name") String jokeType){
        MyJokeUtil response = new MyJokeUtil();
        response.setJoke(MyJoke.getJoke(jokeType));
        return response;
    }
}
