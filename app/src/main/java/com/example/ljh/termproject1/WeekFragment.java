package com.example.ljh.termproject1;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;


public class WeekFragment extends Fragment {

    int mCurCheckPosition = -1;
    private static final String[] WEEKS={"1주","2주","3주","4주","5주","6주","7주","8주","9주","10주","11주",
            "12주","13주","14주","15주","16주","17주","18주","19주","20주","21주","22주","23주","24주",
            "25주","26주","27주","28주","29주","30주","31주","32주","33주","34주","35주","36주","37주",
            "38주","39주","40주","41주","42주","43주","44주","45주","46주","47주","48주","49주","50주","51주","52주"};

    public WeekFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_week, container, false);

        // GridView의 아이디를 가져온다.
        GridView gv = (GridView) view.findViewById(R.id.gridview1);


        gv.setAdapter(new ArrayAdapter<String>(getActivity().getApplicationContext(),
                R.layout.listview_edit, WEEKS));

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mCurCheckPosition = i;
                ((OnTitleSelectedListener)getActivity()).onTitleSelected(i, false);
            }
        });

        if (savedInstanceState != null) {
            mCurCheckPosition = savedInstanceState.getInt("curChoice", -1);
            if (mCurCheckPosition >= 0)
                ((MonthFragment.OnTitleSelectedListener)getActivity()).onTitleSelected(mCurCheckPosition, true);
        }

        gv.setSelection(mCurCheckPosition);
        gv.smoothScrollToPosition(mCurCheckPosition);

        // Inflate the layout for this fragment
        return view;
    }



    public interface OnTitleSelectedListener {
        public void onTitleSelected(int i, boolean restoreSaved);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("curChoice", mCurCheckPosition);
    }

}
