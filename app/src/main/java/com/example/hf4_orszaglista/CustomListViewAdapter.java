package com.example.hf4_orszaglista;


import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomListViewAdapter extends ArrayAdapter<Currency> {
    //to reference the Activity
    private final Activity context;
    private ArrayList<Currency> currencies;

    public CustomListViewAdapter(Activity context, ArrayList<Currency> pValutak){
        super(context, 0,pValutak);
        this.context=context;
        this.currencies= pValutak;
        Log.d("status","CustomListViewAdapter created");
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View rowView = convertView;
        if(rowView == null)
            rowView = LayoutInflater.from(context).inflate(R.layout.currency_layout,parent,false);

        Currency currency = currencies.get(position);

        ImageView image = rowView.findViewById(R.id.flagView);
        image.setImageResource(currency.getFlag());

        ImageView zaszloIkonMezo = rowView.findViewById(R.id.flagView);
        TextView valutakodMezo =  rowView.findViewById(R.id.shortCodeLabel);
        TextView valutaNevMezo = rowView.findViewById(R.id.currencyNameLabel);

        TextView eladArCimke = rowView.findViewById(R.id.sellPriceLabel);
        TextView vasarolArCimke = rowView.findViewById(R.id.buyPriceLabel);

        TextView eladasiArMezo = rowView.findViewById(R.id.sellPriceView);
        TextView vasarlasiArMezo = rowView.findViewById(R.id.buyPriceView);

        valutakodMezo.setText(currencies.get(position).getCurrencyCode());
        valutaNevMezo.setText(currencies.get(position).getCurrencyName());
        eladArCimke.setText(R.string.sellLabel);
        vasarolArCimke.setText(R.string.buyLabel);
        zaszloIkonMezo.setImageResource(currencies.get(position).getFlag());
        eladasiArMezo.setText(currencies.get(position).getSellRate()+"\tRON");
        vasarlasiArMezo.setText(currencies.get(position).getBuyRate()+"\tRON");

        return rowView;
    }
}
