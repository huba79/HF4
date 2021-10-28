package com.example.hf4_orszaglista;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView currencyList = findViewById(R.id.currencyList);
        /*
        ArrayAdapter<String> egyszeruAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,
                nameArray); */
        ArrayList<Currency> currencies = new ArrayList<>();

        int drawableResourceId;


        currencies.add(new Currency(R.drawable.belgium,"Euro", "EUR", 4.9999,4.9000));
        currencies.add(new Currency(R.drawable.croatia,"Kuna", "HRK", 3.2,3.0));
        currencies.add(new Currency(R.drawable.hungary,"Forint", "HUF", 0.068,0.067));
        currencies.add(new Currency(R.drawable.srilanka,"Picula", "PIC", 0.028,0.267));
        currencies.add(new Currency(R.drawable.sudan,"Mutembe", "MTB", 0.008,0.0067));
        currencies.add(new Currency(R.drawable.moldova,"Moldavian LEU", "MDL", 0.26,0.25));
        currencies.add(new Currency(R.drawable.europe,"Euro", "EUR", 4.9999,4.9000));
        currencies.add(new Currency(R.drawable.togo,"Mittomen", "MTM", 0.008,0.0067));

        Log.d("status:","currencies\n"+currencies.toString());

        CustomListViewAdapter listaAdapter = new CustomListViewAdapter(this, currencies);
        currencyList.setAdapter(listaAdapter);
        Log.d("status:","listView custom adapter set");

        currencyList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                view.findViewById(R.id.buyPriceLabel).setVisibility(View.VISIBLE);
                view.findViewById(R.id.sellPriceLabel).setVisibility(View.VISIBLE);

                TextView eladArMezo = view.findViewById(R.id.sellPriceView);

                eladArMezo.setVisibility(View.VISIBLE);
                eladArMezo.setText( leftPad(String.valueOf(currencies.get(i).getSellRate()),8," " )+" RON" );

                TextView vasarolArMezo =view.findViewById(R.id.buyPriceView);
                vasarolArMezo.setVisibility(View.VISIBLE);

                vasarolArMezo.setText( leftPad(String.valueOf(currencies.get(i).getBuyRate()),8," " )+" RON" );

                Toast.makeText(MainActivity.this,currencies.get(i).getCurrencyName(), Toast.LENGTH_SHORT).show();
                Log.d("Pozicio",String.valueOf(i));
            }
        });

    }
    String leftPad(String szoveg, int hosszra,String mivel){
        int i=0;
        while(i+szoveg.length()<hosszra) {
            szoveg = mivel+szoveg;
        }
        return szoveg;
    }
}