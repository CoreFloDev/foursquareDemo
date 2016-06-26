package com.whitbread.florent.productdevelopertest.api;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface FoursquareApi {

    @GET("venues/{VENUE_ID}/photos")
    Observable<?> getPhotoVenues(@Path("VENUE_ID") String venueId);

    @GET("venues/search")
    Observable<?> search(@Query("near") String location, @Query("query") String query);
}
