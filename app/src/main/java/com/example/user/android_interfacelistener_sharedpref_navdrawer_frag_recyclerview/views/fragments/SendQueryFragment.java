package com.example.user.android_interfacelistener_sharedpref_navdrawer_frag_recyclerview.views.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.android_interfacelistener_sharedpref_navdrawer_frag_recyclerview.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class SendQueryFragment extends Fragment {

    private TextView firstName;
    private TextView lastName;
    private OnQueryListener onQueryListener;

    public  interface OnQueryListener{
        void query(String firstName, String lastName);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            if(context instanceof OnQueryListener) {
                onQueryListener = (OnQueryListener) context;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public SendQueryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_send_query, container, false);

        firstName = view.findViewById(R.id.fName);
        lastName = view.findViewById(R.id.lName);

        firstName.addTextChangedListener(textWatcher);
        lastName.addTextChangedListener(textWatcher);
        return view;
    }

    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String uFName = firstName.getText().toString();
            String uLName = lastName.getText().toString();

            onQueryListener.query(uFName,uLName);
        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    };
}
