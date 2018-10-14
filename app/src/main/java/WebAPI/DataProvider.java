package WebAPI;

import WebAPI.RetroApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class DataProvider {
    private static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl("https://sicef-brava.herokuapp.com") //bice neki novi url
            .addConverterFactory(GsonConverterFactory.create());
    private static Retrofit retrofit = builder.build();
    public static RetroApi apiService = retrofit.create(RetroApi.class);

}