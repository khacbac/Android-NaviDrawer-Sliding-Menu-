package thoxinhdep.kbbk.activity.main.fragment.tieudiem.model;

        import android.util.Log;

        import com.google.gson.Gson;
        import com.google.gson.GsonBuilder;
        import com.google.gson.reflect.TypeToken;

        import org.jsoup.Jsoup;
        import org.jsoup.nodes.Document;
        import org.jsoup.nodes.Element;
        import org.jsoup.select.Elements;

        import java.io.IOException;
        import java.lang.reflect.Type;
        import java.util.ArrayList;
        import java.util.Collection;
        import java.util.List;

        import okhttp3.ResponseBody;
        import retrofit2.Call;
        import retrofit2.Callback;
        import retrofit2.Response;
        import thoxinhdep.kbbk.activity.main.fragment.tieudiem.entity.TieuDiemView;
        import thoxinhdep.kbbk.helper.ApiUtils;
        import thoxinhdep.kbbk.entity.TruyenTranh;

/**
 * Created by VST on 9/27/2017.
 */

public class TieuDiemModel implements IeTieuDiemModel {
    private static final String TAG = TieuDiemModel.class.getSimpleName();

    @Override
    public void getAllFeatureTitle(final IeFinishGetTieuDiemData finisGetFeatureLink) {
//        Call<ResponseBody> getAllFeatureData = ApiUtils.getApiServer().getAllHomeInfo();
//        Call<ResponseBody> getAllFeatureData = ApiUtils.getApiServer().getAllHomeData();
        Call<ResponseBody> getAllFeatureData = ApiUtils.getApiServer().getAllHomeEntity();
        getAllFeatureData.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                GsonBuilder builder = new GsonBuilder();
                Gson gson = builder.create();

                final ArrayList<TieuDiemView> listTieuDiemDatas = new ArrayList<>();
                try {
                    String body = response.body().string();
                    if (!body.isEmpty()) {
                        Type colectType = new TypeToken<Collection<TruyenTranh>>(){}.getType();
                        List<TruyenTranh> list = gson.fromJson(body, colectType);
                        Log.d(TAG, "onResponse: size = " + list.size());
                        for (TruyenTranh truyenTranh : list) {
                            TieuDiemView view = new TieuDiemView();
                            view.setTxtTitle(truyenTranh.getTitle());
                            view.setTxtUrlId(truyenTranh.getId());

                            String link = truyenTranh.getImg();
                            Document htmlDoc = Jsoup.parse(link);
                            Elements root = htmlDoc.getAllElements();
                            for (Element e : root) {
                                Elements element = e.getElementsByTag("img");
                                for (Element eLink : element) {
                                    Log.d(TAG, "onResponse: link = " + eLink.attr("src"));
                                    view.setAvatarUrl("" + eLink.attr("src"));
                                }
                            }
                            listTieuDiemDatas.add(view);
                        }
                        finisGetFeatureLink.onSuccessGetTieuDiemData(listTieuDiemDatas);
                    } else {
                        finisGetFeatureLink.onErrorGetTieuDiemData();
                    }
                } catch (IOException /*| JSONException */e) {
                    finisGetFeatureLink.onErrorGetTieuDiemData();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                finisGetFeatureLink.onErrorGetTieuDiemData();
            }
        });
    }
}
