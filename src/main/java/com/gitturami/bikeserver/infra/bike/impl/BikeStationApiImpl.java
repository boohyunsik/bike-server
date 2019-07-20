package com.gitturami.bikeserver.infra.bike.impl;

import com.gitturami.bikeserver.infra.bike.BikeStationApi;
import com.gitturami.bikeserver.infra.bike.repository.BikeStationResponse;
import com.gitturami.bikeserver.infra.bike.retrofit.BikeRetrofit;
import com.gitturami.bikeserver.infra.logger.ApiLogger;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class BikeStationApiImpl implements BikeStationApi {

    private static final String TAG = "BikeStationApiImpl";
    private Retrofit retrofit;
    private BikeRetrofit bikeRetrofit;

    public BikeStationApiImpl() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://openapi.seoul.go.kr:8088/4b64546d6862687339384d4b625366/json/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        bikeRetrofit = retrofit.create(BikeRetrofit.class);
    }

    @Override
    public String getEnableBike(String stationId) {
        // Call<List<BikeStationRepo>> list = bikeRetrofit.listStation(startPage, endPage);

        return null;
    }

    @Override
    public String getTotalBike() {
        return null;
    }

    @Override
    public String getStationInfo() {
        return null;
    }

    @Override
    public BikeStationResponse getStationList(int startPage, int endPage) {
        Call<BikeStationResponse> call = bikeRetrofit.listStation(startPage, endPage);
        try {
            Response<BikeStationResponse> response = call.execute();
            BikeStationResponse body = response.body();
            return body;
        } catch (IOException e) {
            ApiLogger.i(TAG, e.getMessage());
        }
        return null;
    }
}
