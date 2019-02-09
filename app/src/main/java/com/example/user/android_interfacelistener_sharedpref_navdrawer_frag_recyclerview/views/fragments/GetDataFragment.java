package com.example.user.android_interfacelistener_sharedpref_navdrawer_frag_recyclerview.views.fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.android_interfacelistener_sharedpref_navdrawer_frag_recyclerview.R;
import com.example.user.android_interfacelistener_sharedpref_navdrawer_frag_recyclerview.model.GetQueryInfo;
import com.example.user.android_interfacelistener_sharedpref_navdrawer_frag_recyclerview.views.adapters.GetQueryAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class GetDataFragment extends Fragment {

    private GetQueryAdapter getQueryAdapter;
    private ArrayList<GetQueryInfo> getQueryInfoArrayList;
    private RecyclerView recyclerView;

    private SharedPreferences sharedPreferences;

    public GetDataFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_get_data, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        getQueryInfoArrayList =  new ArrayList<>();

        getQueryAdapter =  new GetQueryAdapter(getContext(),getQueryInfoArrayList);
        recyclerView.setAdapter(getQueryAdapter);

        getDataFromDialog();

        return view;
    }

    private void getDataFromDialog(){
        String uFName,uLName;
        sharedPreferences = getActivity().getSharedPreferences("SendDataActivity",Context.MODE_PRIVATE);
        uFName = sharedPreferences.getString("ValueFName","0");
        uLName = sharedPreferences.getString("ValueLName","0");

        getQueryInfoArrayList.add(new GetQueryInfo(uFName,uLName));
        getQueryAdapter.notifyItemInserted(getQueryInfoArrayList.size());
    }

    private void loadData(){
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("SharedPreferences",Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("task value",null);
        Type type = new TypeToken<ArrayList<GetQueryInfo>>(){}.getType();
        getQueryInfoArrayList = gson.fromJson(json,type);

        if(getQueryInfoArrayList == null){
            getQueryInfoArrayList = new ArrayList<>();
        }
    }
}
