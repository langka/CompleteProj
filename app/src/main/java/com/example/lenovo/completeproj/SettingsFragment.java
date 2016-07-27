package com.example.lenovo.completeproj;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

/**
 * Created by lenovo on 2016/7/25.
 */
public class SettingsFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("mylife","on create view");
        View v = inflater.inflate(R.layout.settings,null);
        Log.d("tyty","A");
        ListView listView = (ListView)v.findViewById(R.id.settingslistview);
        Log.d("tyty","B");
        String[] functions = {"账号管理","系统设置","我的收藏"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,functions);
        Log.d("tyty","C");
        listView.setAdapter(adapter);
        Log.d("tyty","D");
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("mylife","activty created");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("mylife","attach to activity");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("mylife","on create");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("mylife","on destroy");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("mylife","on des view");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("mylife","on resume");
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("mylife","on stop");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("mylife","on pause");
    }

}
