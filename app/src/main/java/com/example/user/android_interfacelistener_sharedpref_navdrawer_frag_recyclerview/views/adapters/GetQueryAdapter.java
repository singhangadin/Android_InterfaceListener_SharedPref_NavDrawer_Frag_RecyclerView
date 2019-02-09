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

    public GetQueryAdapter(Context context, @NonNull ArrayList<GetQueryInfo> getQueryInfoArrayList) {
        this.context = context;
        this.getQueryInfoArrayList = getQueryInfoArrayList;
    }

    @NonNull
    @Override
    public MyCardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_query,viewGroup,false);
        return new MyCardViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyCardViewHolder myCardViewHolder, int position) {
        GetQueryInfo getQueryInfo = getQueryInfoArrayList.get(position);
        myCardViewHolder.userFirstName.setText(getQueryInfo.getFirstName());
        myCardViewHolder.userLastName.setText(getQueryInfo.getFirstName());
    }

    @Override
    public int getItemCount() {
        return getQueryInfoArrayList.size();
    }

    class MyCardViewHolder extends RecyclerView.ViewHolder{
        TextView userFirstName;
        TextView userLastName;

        MyCardViewHolder(@NonNull View itemView) {
            super(itemView);
            userFirstName = itemView.findViewById(R.id.firstName_textView);
            userLastName = itemView.findViewById(R.id.lastName_textView);
        }
    }
}
