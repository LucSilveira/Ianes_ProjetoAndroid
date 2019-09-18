package ianes.br.com.senai.ianes.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import ianes.br.com.senai.ianes.utils.AppUtils;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 46923597811 on 14/06/2018.
 */

public class RetrofitConfig {

 private final Retrofit retrofit;

    Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();

    public RetrofitConfig(){
        //contruir um objeto retrofit
        this.retrofit = new Retrofit.Builder()
                //definindo a base url
                .baseUrl(AppUtils.baserUrl)
                //transformando a response do Json
                .addConverterFactory(GsonConverterFactory.create())
                //criando
                .build();
    }

    public RetrofitConfig(final String token) {
        final OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(new Interceptor() {

            @Override
            public okhttp3.Response intercept(Interceptor.Chain chain) throws IOException {
                Request.Builder b = chain.request().newBuilder();
                b.addHeader("Accept", "application/json");
                b.addHeader("Authorization", token);
                return chain.proceed(b.build());
            }
        }).build();
        //contruir um objeto retrofit
        this.retrofit = new Retrofit.Builder()
                //definindo a base url
                .baseUrl(AppUtils.baserUrl)

                .client(okHttpClient)
                //transformando a response do Json
                .addConverterFactory(GsonConverterFactory.create(gson))
                //criando
                .build();
    }

    public RestInterface getRestInterface(){

        return this.retrofit.create(RestInterface.class);
    }
}