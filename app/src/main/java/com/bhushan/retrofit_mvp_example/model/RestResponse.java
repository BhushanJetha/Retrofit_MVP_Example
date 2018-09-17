package com.bhushan.retrofit_mvp_example.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class RestResponse {

    @SerializedName("message")
    private List<String> message;

    @SerializedName("result")
    private List<Country> result;

    public List<String> getMessage() {
        return message;
    }

    public List<Country> getResult() {
        return result;
    }
}
