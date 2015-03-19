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

import java.text.DecimalFormat;

/**
 * Created by kitten on 3/14/15.
 */
public class DetailFragment extends Fragment {
    TextView percentageTextView;
    Integer mPercentage;
    Integer mOriginalPrice;
    Integer mNewPrice;
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
                        calculatePrice();
                    }
                    else {
                        finalPriceTextView.setText(integerToCurrency(0));
                    }
                }

                @Override
                public void afterTextChanged(Editable editable) {
                }
            });
        }
        return rootView;
    }

    public void calculatePrice() {
        mOriginalPrice = currencyToInteger(editText.getText().toString());
        Double percentOff = Double.valueOf(mPercentage) / 100.0;
        Double discountDouble = Double.valueOf(mOriginalPrice) * percentOff;
        Integer discount = (discountDouble).intValue();
        mNewPrice = mOriginalPrice - discount;
        finalPriceTextView.setText(integerToCurrency(mNewPrice));
    }

    public Integer currencyToInteger(String currency) {
        Double d = Double.valueOf(currency);
        Double c = d * 100;
        int cents = (c).intValue();
        return cents;
    }

    public String integerToCurrency(Integer cents) {
        Double d = cents.doubleValue() / 100.0;
        DecimalFormat df = new DecimalFormat("$0.00");
        return df.format(d);
    }
}
