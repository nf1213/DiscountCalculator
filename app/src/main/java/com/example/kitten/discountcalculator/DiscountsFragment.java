package com.example.kitten.discountcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class DiscountsFragment extends Fragment {

    private ListView listView;
    private Integer[] percentages = {
        30,
        40,
        50,
        70
    };
    private ArrayAdapter mDiscountAdapter;

    public DiscountsFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_discounts, container, false);
        listView = (ListView) rootView.findViewById(R.id.listView_discounts);
        List<Integer> percentageList = new ArrayList<Integer>(Arrays.asList(percentages));
        mDiscountAdapter = new ArrayAdapter(
                getActivity(),
                R.layout.list_item_discount,
                R.id.discount_percentage,
                percentageList
        );
        listView.setAdapter(mDiscountAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Integer percentage = (Integer) mDiscountAdapter.getItem(i);
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra(Intent.EXTRA_TEXT, percentage);
                startActivity(intent);
            }

        });
        return rootView;
    }

}
