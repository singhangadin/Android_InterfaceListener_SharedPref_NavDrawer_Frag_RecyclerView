package com.example.user.android_interfacelistener_sharedpref_navdrawer_frag_recyclerview.model;

import android.support.annotation.NonNull;

public class GetQueryInfo {
    private String firstName;
    private String lastName;

    public GetQueryInfo(@NonNull String firstName, @NonNull String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @NonNull
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NonNull String firstName) {
        this.firstName = firstName;
    }

    @NonNull
    public String getLastName() {
        return lastName;
    }

    public void setLastName(@NonNull String lastName) {
        this.lastName = lastName;
    }
}
