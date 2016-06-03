package com.homemade.barista.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


import com.homemade.barista.Coffee;
import com.homemade.barista.CoffeeDetailsActivity;
import com.homemade.barista.CoffeeListViewAdapter;
import com.homemade.barista.DbHelper;
import com.homemade.barista.R;

import java.util.List;


public class FragmentHome extends Fragment {

    public FragmentHome() {
        // Required empty public constructor
    }

    private CoffeeListViewAdapter adapter = null;
    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this layouts.fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        listView = (ListView) view.findViewById(R.id.coffee_list);

        //FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        //fab.hide();

        DbHelper cashflowDbHelper = new DbHelper(getActivity());
        List<Coffee> baseItems = cashflowDbHelper.getCoffees();

        CoffeeListViewAdapter adapter = new CoffeeListViewAdapter(getContext(), android.R.layout.simple_list_item_1, baseItems);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Coffee coffee = (Coffee) adapterView.getItemAtPosition(i);
                Intent intent = new Intent(view.getContext(), CoffeeDetailsActivity.class);
                intent.putExtra("coffee", coffee);
                startActivity(intent);
            }
        });

        setHasOptionsMenu(true);

        return view;
    }
}
