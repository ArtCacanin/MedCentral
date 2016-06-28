package com.a3live.cacanindin.artemio.medcentral;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.app.ListFragment;
import android.os.Build;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.util.ArrayList;

public class MedsFragment extends ListFragment {

    ArrayList<String> listItems = new ArrayList<>();

    //DEFINING A STRING ADAPTER WHICH WILL HANDLE THE DATA OF THE LISTVIEW
    ArrayAdapter<String> adapter;

    @TargetApi(Build.VERSION_CODES.M)
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        adapter = new ArrayAdapter<String>(this.getContext(), android.R.layout.simple_list_item_1, listItems);
        setListAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.meds_layout, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        Button addBtn;
        addBtn = (Button) getView().findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addItems(view);
            }
        });
    }

    @Override
    public void onPause() {
        System.out.println("Medication Paused");
        super.onPause();
    }

    @Override
    public void onResume() {
        System.out.println("Medication Resumed");
        super.onResume();
    }

    @Override
    public void onDestroy() {
        System.out.println("Medication Destroyed");
        super.onDestroy();
    }

    public void addItems(View v) {
        listItems.add("Bradley");
        adapter.notifyDataSetChanged();
    }
}