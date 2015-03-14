package com.example.kitten.discountcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by kitten on 3/14/15.
 */
public class DetailFragment extends Fragment {
    TextView percentageTextView;
    Integer mPercentage;
    Double mOriginalPrice;
    Double mNewPrice;
    TextView finalPriceTextView;
    EditText editText;

    public DetailFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        percentageTextView = (TextView) rootView.findViewById(R.id.selected_discount);
        finalPriceTextView = (TextView) rootView.findViewById(R.id.final_price);
        editText = (EditText) rootView.findViewById(R.id.discount_editText);

        Intent intent = getActivity().getIntent();
        if(intent != null && intent.hasExtra(Intent.EXTRA_TEXT)) {
            mPercentage = (Integer) intent.getIntExtra(Intent.EXTRA_TEXT, 0);
            percentageTextView.setText(Integer.toString(mPercentage) + "%");
            editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if(!(editText.getText().toString().equals(""))) {
                        mOriginalPrice = Double.valueOf(editText.getText().toString());
                        calculatePrice();
                    }
                    else {
                        finalPriceTextView.setText(Double.toString(0.0));
                    }
                }

                @Override
                public void afterTextChanged(Editable editable) {
                    finalPriceTextView.setText("$" + finalPriceTextView.getText().toString());
                }
            });
        }
        return rootView;
    }

    public void calculatePrice() {
        Double discount = mOriginalPrice * (Double.valueOf(mPercentage) / 100.00);
        mNewPrice = mOriginalPrice - discount;
        finalPriceTextView.setText(Double.toString(mNewPrice));
    }
}
