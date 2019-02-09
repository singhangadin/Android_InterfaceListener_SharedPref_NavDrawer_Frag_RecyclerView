package com.example.user.android_interfacelistener_sharedpref_navdrawer_frag_recyclerview.views.fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.android_interfacelistener_sharedpref_navdrawer_frag_recyclerview.R;
import com.example.user.android_interfacelistener_sharedpref_navdrawer_frag_recyclerview.model.GetQueryInfo;
import com.example.user.android_interfacelistener_sharedpref_navdrawer_frag_recyclerview.utils.Constants;
import com.example.user.android_interfacelistener_sharedpref_navdrawer_frag_recyclerview.views.adapters.GetQueryAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;


/**
 * A simple {@link Fragment} subclass.
 */
public class GetDataFragment extends Fragment implements SharedPreferences.OnSharedPreferenceChangeListener {

    private GetQueryAdapter getQueryAdapter;
    private ArrayList<GetQueryInfo> getQueryInfoArrayList;
    private RecyclerView recyclerView;

    private SharedPreferences sharedPreferences;

    public GetDataFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         View view =  inflater.inflate(R.layout.fragment_get_data, container, false);
        sharedPreferences = getActivity().getSharedPreferences(Constants.PREFS_KEY, Context.MODE_PRIVATE);
        sharedPreferences.registerOnSharedPreferenceChangeListener(this);

        recyclerView = view.findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        getQueryInfoArrayList = new ArrayList<>();

        getQueryAdapter =  new GetQueryAdapter(getContext(), getQueryInfoArrayList);
        recyclerView.setAdapter(getQueryAdapter);


        loadData();
        return view;
    }

    @Override
    public void onDestroyView() {
        sharedPreferences.unregisterOnSharedPreferenceChangeListener(this);
        super.onDestroyView();
    }

    private void getDataFromDialog() {
        String name = sharedPreferences.getString(Constants.KEY_NAME, "John Does");

        getQueryInfoArrayList.add(new GetQueryInfo(name.split(" ")[0], name.split(" ")[1]));
        getQueryAdapter.notifyItemInserted(getQueryInfoArrayList.size());

        Set<String> names = sharedPreferences.getStringSet(Constants.KEY_NAME_LIST, new LinkedHashSet<String>());
        names.add(name);

        sharedPreferences.edit().putStringSet(Constants.KEY_NAME_LIST, names).apply();
    }

    private void loadData() {
        Set<String> names = sharedPreferences.getStringSet(Constants.KEY_NAME_LIST, new LinkedHashSet<String>());
        int start = getQueryInfoArrayList.size();
        for (String name: names) {
            getQueryInfoArrayList.add(new GetQueryInfo(name.split(" ")[0], name.split(" ")[1]));
        }
        getQueryAdapter.notifyItemRangeInserted(start, getQueryInfoArrayList.size());
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        switch (key) {
            case Constants.KEY_NAME: {
                getDataFromDialog();
            }
        }
    }
}
