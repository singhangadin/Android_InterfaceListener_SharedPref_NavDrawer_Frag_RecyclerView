package com.example.user.android_interfacelistener_sharedpref_navdrawer_frag_recyclerview.views;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.user.android_interfacelistener_sharedpref_navdrawer_frag_recyclerview.R;
import com.example.user.android_interfacelistener_sharedpref_navdrawer_frag_recyclerview.views.dialogs.SendQueryToDialog;
import com.example.user.android_interfacelistener_sharedpref_navdrawer_frag_recyclerview.views.fragments.SendQueryFragment;

public class SendDataActivity extends AppCompatActivity implements SendQueryFragment.OnQueryListener {

    private Toolbar toolbar;
    private Button nextButton;
    private FragmentManager fragmentManager;
    String userFirstName,userLastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_data);

        toolbar =(Toolbar) findViewById(R.id.toolbar_SendQuery);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nextButton = (Button) findViewById(R.id.next_Button);

        fragmentManager =  getSupportFragmentManager();


        sendQueryOne();
    }

    //Toolbar working.
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(SendDataActivity.this,MainActivity.class);
        startActivity(intent);
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void sendQueryOne(){
        SendQueryFragment sendQueryFragment = new SendQueryFragment();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frameContainer, sendQueryFragment,"addSendQuery1");
        fragmentTransaction.commit();
    }

    @Override
    public void query(String firstName, String lastName) {
        userFirstName = firstName;
        userLastName = lastName;

        if(!userFirstName.isEmpty() && !userLastName.isEmpty()){
            nextButton.setEnabled(true);
            nextButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sendQueryToDialog();
                }
            });
        }
        else{
            nextButton.setEnabled(false);
        }

    }

    private void sendQueryToDialog(){
        Bundle bundle = new Bundle();
        bundle.putString("fName",userFirstName);
        bundle.putString("lName",userLastName);

        SendQueryToDialog sendQueryToDialog = new SendQueryToDialog();
        sendQueryToDialog.setArguments(bundle);
        sendQueryToDialog.show(fragmentManager,"SendToDialog");
        sendQueryToDialog.setCancelable(false);
    }
}
