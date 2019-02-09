package com.example.user.android_interfacelistener_sharedpref_navdrawer_frag_recyclerview.views.dialogs;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.android_interfacelistener_sharedpref_navdrawer_frag_recyclerview.R;
import com.example.user.android_interfacelistener_sharedpref_navdrawer_frag_recyclerview.utils.Constants;

public class SendQueryToDialog extends DialogFragment implements View.OnClickListener {
    private TextView firstName;
    private TextView lastName;

    private String uFName, uLName;
    private SharedPreferences sharedPreferences;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.dialog_send_query_to,container,false);
        getDialog().setTitle("Send Data");

        sharedPreferences = getContext().getSharedPreferences(Constants.PREFS_KEY, Context.MODE_PRIVATE);
        firstName = view.findViewById(R.id.firstName_textView);
        lastName = view.findViewById(R.id.lastName_textView);

        getQueryFromSendData();
        view.findViewById(R.id.cancelQuery_button).setOnClickListener(this);
        view.findViewById(R.id.sendQuery_button).setOnClickListener(this);
        return view;
    }

    private void getQueryFromSendData() {
        Bundle bundle = getArguments();
        uFName = bundle.getString("fName");
        firstName.setText(uFName);

        uLName = bundle.getString("lName");
        lastName.setText(uLName);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sendQuery_button: {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(Constants.KEY_NAME, uFName + " " + uLName);
                editor.apply();
                getDialog().dismiss();
                Toast.makeText(getContext(),"Full Name :" + uFName + " " + uLName, Toast.LENGTH_SHORT).show();
                break;
            }

            case R.id.cancelQuery_button: {
                getDialog().dismiss();
                break;
            }
        }
    }
}
