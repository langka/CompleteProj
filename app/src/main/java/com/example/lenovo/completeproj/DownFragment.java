package com.example.lenovo.completeproj;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;


/**
 * Created by lenovo on 2016/7/25.
 */
public class DownFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.down_fragment,null);
        TextView view1 = (TextView)v.findViewById(R.id.down_frag_tv1);
        TextView view2 = (TextView)v.findViewById(R.id.down_frag_tv2);
        TextView view3 = (TextView) v.findViewById(R.id.down_frag_thread_test);
        view3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),HandlerTestActivity.class);
                startActivity(intent);
            }
        });
        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((MainActivity)getActivity()).booksFragment == null){
                    Log.d("testNull","null book");
                    (((MainActivity)getActivity()).booksFragment)=new BooksFragment();}

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.contentShowed,((MainActivity)getActivity()).booksFragment);
                ft.commit();
            }
        });
        view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((MainActivity)getActivity()).settingsFragment ==null) {
                    ((MainActivity) getActivity()).settingsFragment = new SettingsFragment();
                    Log.d("testNull","null settings");
                }
                Log.d("mylife","E");
                FragmentTransaction ft =getFragmentManager().beginTransaction();
                Log.d("mylife","F");
                ft.replace(R.id.contentShowed,((MainActivity)getActivity()).settingsFragment);
                Log.d("mylife","G");
                ft.commit();
                Log.d("mylife","H");
            }
        });
        return v;
    }
}
