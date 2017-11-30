package babs.slackteam.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import babs.slackteam.Helpers.Constants;
import babs.slackteam.model.UserListModel;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.POST;

/**
 * Created by babusr on 11/26/17.
 */

public interface RetrofitService {
    String BASE_URL = "https://slack.com/api/";

    Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();


    OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .addNetworkInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request request = chain.request().newBuilder()
                            .addHeader("content-type", "application/json")
                            .addHeader("Authorization", Constants.API_TOKEN)
                            .build();
                    return chain.proceed(request);
                }
            })
            .addInterceptor(httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY))
            .build();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build();



    /**
     *  Fetch List of users
     */
    @POST("users.list")
    Call<UserListModel> getUsers();

}
