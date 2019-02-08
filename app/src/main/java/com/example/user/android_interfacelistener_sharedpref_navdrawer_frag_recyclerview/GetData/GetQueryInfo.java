package com.example.user.android_interfacelistener_sharedpref_navdrawer_frag_recyclerview.GetData;

public class GetQueryInfo {

    String firstName,lastName;

    GetQueryInfo(String firstName,String lastName){
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
