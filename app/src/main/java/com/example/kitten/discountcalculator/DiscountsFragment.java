package com.example.kitten.discountcalculator;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class DiscountsFragment extends Fragment {

    private ListView listView;
    private Discount[] discounts = {
        new Discount(30, R.drawable.green_touch_selector),
        new Discount(40, R.drawable.purple_touch_selector),
        new Discount(50, R.drawable.red_touch_selector),
        new Discount(70, R.drawable.blue_touch_selector)
    };
    private DiscountAdapter mDiscountAdapter;

    public DiscountsFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_discounts, container, false);
        listView = (ListView) rootView.findViewById(R.id.listView_discounts);
        mDiscountAdapter = new DiscountAdapter(
                getActivity(),
                R.layout.list_item_discount,
                discounts
        );
        listView.setAdapter(mDiscountAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Integer percentage = (Integer) mDiscountAdapter.getItem(i).mPercentage;
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra(Intent.EXTRA_TEXT, percentage);
                startActivity(intent);
            }

        });
        return rootView;
    }


    public class DiscountAdapter extends ArrayAdapter<Discount> {

        Context context;
        int layoutResourceId;
        Discount data[] = null;

        public DiscountAdapter(Context context, int layoutResourceId, Discount[] data) {
            super(context, layoutResourceId, data);
            this.layoutResourceId = layoutResourceId;
            this.context = context;
            this.data = data;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;
            TextView percentageTv;

            if(row == null)
            {
                LayoutInflater inflater = ((Activity)context).getLayoutInflater();
                row = inflater.inflate(layoutResourceId, parent, false);

                percentageTv = (TextView) row.findViewById(R.id.discount_percentage);

                Discount discount = data[position];
                percentageTv.setText(Integer.toString(discount.mPercentage) + "%");
                row.setBackgroundResource(discount.mBackgroundResource);
            }

            return row;
        }
    }

    public class Discount {
        int mPercentage;
        int mBackgroundResource;

        public Discount(int percentage, int backgroundResource) {
            mPercentage = percentage;
            mBackgroundResource = backgroundResource;
        }
    }

}
