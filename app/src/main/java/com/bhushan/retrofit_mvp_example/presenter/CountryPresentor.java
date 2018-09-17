package com.bhushan.retrofit_mvp_example.presenter;

import com.bhushan.retrofit_mvp_example.model.Country;
import com.bhushan.retrofit_mvp_example.model.Data;
import com.bhushan.retrofit_mvp_example.service.CountryService;
import com.bhushan.retrofit_mvp_example.view.CountryView;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountryPresentor {

    private CountryView countryView;
    private CountryService countryService;

    public CountryPresentor(CountryView countryView){
        this.countryView=countryView;

        if(this.countryService == null){
            this.countryService = new CountryService();
        }
    }

    public void getCountries(){
        countryService
                .getAPI()
                .getResults()
                .enqueue(new Callback<Data>() {
                    @Override
                    public void onResponse(Call<Data> call, Response<Data> response) {
                        Data data = response.body();

                        if(data != null && data.getRestResponse() != null){
                            List<Country> result = data.getRestResponse().getResult();
                            countryView.countriesReady(result);
                        }
                    }

                    @Override
                    public void onFailure(Call<Data> call, Throwable t) {
                        try {
                            throw new InterruptedException("Something went wrong !!");
                        }catch (InterruptedException e){
                           e.printStackTrace();
                        }
                    }
                });
    }
}
