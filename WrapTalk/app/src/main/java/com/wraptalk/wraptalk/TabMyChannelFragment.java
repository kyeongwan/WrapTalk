package com.wraptalk.wraptalk;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TabMyChannelFragment extends android.support.v4.app.Fragment {

    View view;
    ArrayList<MyChannelData> source;
    MyChannelAdapter customAdapter = null;
    ListView listView_result = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_tab_my_channel, container, false);

        //((MainActivity) getActivity()).getSupportActionBar().setTitle("c");

        initModel();
        initController();
        initView();

        listView_result.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), ChattingActivity.class);
                startActivity(intent);
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    private void initModel() {
        source = new ArrayList<>();
        listView_result = (ListView) view.findViewById(R.id.listView_myChannel);
    }

    private void initView() {
        MyChannelData data = new MyChannelData();

        data.myChannelTitle = "title";
        data.myNickname = "nickname";
        data.countUnreadMessage = 85;
        source.add(data);

        customAdapter.notifyDataSetChanged();
    }

    private void initController() {
        customAdapter = new MyChannelAdapter(getActivity().getApplicationContext(), source);
        listView_result.setAdapter(customAdapter);
    }

    public TabMyChannelFragment() {
        // Required empty public constructor
    }


}
