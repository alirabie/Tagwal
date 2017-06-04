package ConstantClasss;

import android.app.ProgressDialog;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by asmaa.mostafa on 13/03/2017.
 */
public class Constanturl {
    //Web service URL
    ProgressDialog mProgressDialog;
    private static final String API_URL = "http://mostafaadel12-001-site1.dtempurl.com/Service.asmx/";

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(API_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    public static <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = builder.client(httpClient.build()).build();
        return retrofit.create(serviceClass);
    }

}
