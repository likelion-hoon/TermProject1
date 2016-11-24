package com.example.ljh.termproject1;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class WeekFragment extends Fragment {

    private ListView lvweek;
    private String[] weeks;

    public WeekFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_week, container, false);

        weeks = getActivity().getResources().getStringArray(R.array.weeks);

        // listview의 아이디를 가져온다.
        lvweek = (ListView) view.findViewById(R.id.listview);

        lvweek.setAdapter(new ArrayAdapter<String>(getActivity().getApplicationContext(),
                android.R.layout.simple_list_item_1, weeks));

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_week, container, false);
    }



}
