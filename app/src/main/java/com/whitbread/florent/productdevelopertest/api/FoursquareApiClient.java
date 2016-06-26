package com.whitbread.florent.productdevelopertest.api;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FoursquareApiClient {

    public static final String API_BASE_URL = "https://api.foursquare.com/v2/";

    private final OkHttpClient httpClient = new OkHttpClient.Builder()
                                            .build();

    private final Retrofit retrofit;

    public FoursquareApiClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public <S> S api(Class<S> api) {
        return retrofit.create(api);
    }
}
