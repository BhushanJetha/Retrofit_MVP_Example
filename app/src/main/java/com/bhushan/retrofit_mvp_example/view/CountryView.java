package com.bhushan.retrofit_mvp_example.view;

import com.bhushan.retrofit_mvp_example.model.Country;
import java.util.List;

public interface CountryView {

    void countriesReady(List<Country> countries);
}
