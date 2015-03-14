package com.example.kitten.discountcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by kitten on 3/14/15.
 */
public class DetailFragment extends Fragment {
    TextView percentageTextView;
    Integer mPercentage;

    public DetailFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        percentageTextView = (TextView) rootView.findViewById(R.id.selected_discount);

        Intent intent = getActivity().getIntent();
        if(intent != null && intent.hasExtra(Intent.EXTRA_TEXT)) {
            mPercentage = (Integer) intent.getIntExtra(Intent.EXTRA_TEXT, 0);
            percentageTextView.setText(Integer.toString(mPercentage));
        }
        return rootView;
    }
}
