package com.example.kaksha.API.Models.Response;

import com.google.gson.annotations.SerializedName;

public class TestReponse {

    @SerializedName("social_anxiety")
    private String social_anxiety;

    public TestReponse(String social_anxiety) {
        this.social_anxiety = social_anxiety;
    }

    public void setSocial_anxiety(String social_anxiety) {
        this.social_anxiety = social_anxiety;
    }

    public String getSocial_anxiety() {
        return social_anxiety;
    }

}
