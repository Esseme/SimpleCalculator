package com.simplecalculator;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ed Ssemuwemba on 2019-12-17.
 * esseme@gmail.com
 */
public class RetrofitInstance {
    private static Retrofit retrofit;
    private static final String BASE_URL = "http://api.mathjs.org/v4/";

    public static Retrofit getRetrofitInstance(){
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }

        return retrofit;
    }

}
