package com.simplecalculator;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Ed Ssemuwemba on 2019-12-17.
 * esseme@gmail.com
 */
public class Number {
    @SerializedName("number")
    @Expose
    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
