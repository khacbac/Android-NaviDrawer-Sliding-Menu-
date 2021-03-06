package thoxinhdep.kbbk.helper;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Url;
import thoxinhdep.kbbk.constant.Constants;

/**
 * Created by VST on 9/16/2017.
 */

public interface ApiServer {
    @GET("/")
    Call<ResponseBody> getAllHomeInfo();

    @GET("wp-content/themes/manga/list-manga-front.js?nocache=1506538619")
    Call<ResponseBody> getAllHomeData();

    @GET("wp-content/themes/manga/list-manga-home.js?nocache=1507009962")
    Call<ResponseBody> getAllHomeEntity();

    @GET
    Call<ResponseBody> getAllDetailData(@Url String url);

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Constants.URL_HOME)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

}
