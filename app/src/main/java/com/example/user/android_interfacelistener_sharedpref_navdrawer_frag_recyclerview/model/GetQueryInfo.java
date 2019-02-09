package com.example.user.android_interfacelistener_sharedpref_navdrawer_frag_recyclerview.model;

import android.support.annotation.NonNull;

public class GetQueryInfo {

    private String firstName;
    private String lastName;

    public GetQueryInfo(@NonNull String firstName, @NonNull String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
