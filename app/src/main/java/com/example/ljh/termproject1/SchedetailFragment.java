package com.example.ljh.termproject1;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class SchedetailFragment extends Fragment {


    public SchedetailFragment() {
        // Required empty public constructor
    }

    public static SchedetailFragment newInstance(int index) {
        SchedetailFragment f = new SchedetailFragment();

        Bundle args = new Bundle();
        args.putInt("index", index);
        f.setArguments(args);

        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_schedetail, container, false);
    }
}
