package com.example.user.android_interfacelistener_sharedpref_navdrawer_frag_recyclerview.views.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.android_interfacelistener_sharedpref_navdrawer_frag_recyclerview.model.GetQueryInfo;
import com.example.user.android_interfacelistener_sharedpref_navdrawer_frag_recyclerview.R;

import java.util.ArrayList;

public class GetQueryAdapter extends RecyclerView.Adapter<GetQueryAdapter.MyCardViewHolder> {
    private Context context;
    private ArrayList<GetQueryInfo> getQueryInfoArrayList;

    public GetQueryAdapter(Context context,ArrayList<GetQueryInfo> getQueryInfoArrayList){
        this.context = context;
        this.getQueryInfoArrayList = getQueryInfoArrayList;
    }

    @NonNull
    @Override
    public MyCardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.getquery_adapter_cardview,viewGroup,false);
        return new MyCardViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyCardViewHolder myCardViewHolder, int i) {
        GetQueryInfo getQueryInfo = getQueryInfoArrayList.get(i);
        myCardViewHolder.userFirstName.setText(getQueryInfo.getFirstName());
        myCardViewHolder.userLastName.setText(getQueryInfo.getFirstName());
    }

    @Override
    public int getItemCount() {
        return getQueryInfoArrayList.size();
    }

    public class MyCardViewHolder extends RecyclerView.ViewHolder{
        TextView userFirstName;
        TextView userLastName;

        public MyCardViewHolder(@NonNull View itemView) {
            super(itemView);
            userFirstName = (TextView) itemView.findViewById(R.id.firstName_textView);
            userLastName = (TextView) itemView.findViewById(R.id.lastName_textView);
        }
    }
}
