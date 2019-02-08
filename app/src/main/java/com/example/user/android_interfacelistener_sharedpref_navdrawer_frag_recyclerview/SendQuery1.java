package com.example.user.android_interfacelistener_sharedpref_navdrawer_frag_recyclerview;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SendQuery1 extends Fragment {


    private TextView firstName;
    private TextView lastName;
    OnQueryListener onQueryListener;

    public  interface OnQueryListener{
        void query(String firstName, String lastName);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            if(context instanceof OnQueryListener){
                onQueryListener = (OnQueryListener) context;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public SendQuery1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_send_query1, container, false);

        firstName = (TextView) view.findViewById(R.id.fName);
        lastName = (TextView) view.findViewById(R.id.lName);

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
