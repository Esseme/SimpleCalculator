package com.simplecalculator;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Ed Ssemuwemba on 2019-12-17.
 * esseme@gmail.com
 */
public interface CalculatorApiInterface {

    @POST()
    Call<Number> postNumber(@Body Number number);
}
