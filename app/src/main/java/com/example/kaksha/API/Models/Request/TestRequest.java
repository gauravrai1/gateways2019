package com.example.kaksha.API.Models.Request;

import com.google.gson.annotations.SerializedName;

public class TestRequest {

    @SerializedName("query")
    private String query;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public TestRequest(String query) {
        this.query = query;
    }

}
