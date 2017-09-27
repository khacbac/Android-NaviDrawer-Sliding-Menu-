package thoxinhdep.kbbk.helper;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import thoxinhdep.kbbk.constant.Constants;

/**
 * Created by VST on 9/16/2017.
 */

public interface ApiServer {
    @GET("/")
    Call<ResponseBody> getAllHomeInfo();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Constants.URL_HOME)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
