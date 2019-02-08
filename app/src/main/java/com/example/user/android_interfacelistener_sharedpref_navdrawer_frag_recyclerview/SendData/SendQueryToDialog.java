package com.example.user.android_interfacelistener_sharedpref_navdrawer_frag_recyclerview.SendData;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.android_interfacelistener_sharedpref_navdrawer_frag_recyclerview.R;

public class SendQueryToDialog extends DialogFragment {

    private TextView firstName;
    private TextView lastName;
    private Button cancel;
    private Button sendQuery;

    String uFName,uLName;
    SharedPreferences sharedPreferences;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.sendquery_to_dialog,container,false);

        getDialog().setTitle("Send Data");
        firstName = (TextView) view.findViewById(R.id.firstName_textView);
        lastName = (TextView) view.findViewById(R.id.lastName_textView);

        cancel = (Button) view.findViewById(R.id.cancelQuery_button);
        sendQuery = (Button) view.findViewById(R.id.sendQuery_button);

        getQueryFromSendData();
        cancelQuery();
        sendQuery();
        return view;
    }

    private void cancelQuery(){
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });
    }

    private void sendQuery(){
        sendQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences = getActivity().getSharedPreferences("SendData",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("ValueFName",uFName);
                editor.putString("ValueLName",uLName);
                editor.apply();
                getDialog().dismiss();
                Toast.makeText(getContext(),"Full Name :"+uFName+" "+uLName,Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getQueryFromSendData(){
        Bundle bundle = getArguments();

        uFName = bundle.getString("fName");
        firstName.setText(uFName);

        uLName = bundle.getString("lName");
        lastName.setText(uLName);
    }
}
