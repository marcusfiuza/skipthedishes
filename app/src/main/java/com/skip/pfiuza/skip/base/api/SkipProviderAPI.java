package com.skip.pfiuza.skip.base.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.skip.pfiuza.skip.BuildConfig;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by PFiuza on 18/03/2018.
 */

public class SkipProviderAPI {

    private static Retrofit retrofit;

    public SkipProviderAPI() {
    }

    public static SkipService provideAndCreate() {
        return provide().create(SkipService.class);
    }

    public static Retrofit provide() {
        if (retrofit == null) {
            Gson gson = new GsonBuilder().setLenient().create();
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.addInterceptor(logging);

            retrofit = new Retrofit.Builder()
                    .baseUrl(BuildConfig.API_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(httpClient.build())
                    .build();
        }

        return retrofit;
    }


}
