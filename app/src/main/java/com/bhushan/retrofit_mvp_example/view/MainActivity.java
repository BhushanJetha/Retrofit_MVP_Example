package com.bhushan.retrofit_mvp_example.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.bhushan.retrofit_mvp_example.R;
import com.bhushan.retrofit_mvp_example.model.Country;
import com.bhushan.retrofit_mvp_example.presenter.CountryPresentor;

import java.util.List;

public class MainActivity extends AppCompatActivity implements  CountryView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CountryPresentor countryPresentor = new CountryPresentor(this);
        countryPresentor.getCountries();
    }

    @Override
    public void countriesReady(List<Country> countries) {
        for (Country country : countries) {
            Log.i("RETROFIT", country.getName() + "\n"
                    + " - Alpha2:  " + country.getAlphaCode2() + " \n"
                    + " - Alpha3: " + country.getAlphaCode3());
        }
    }
}
