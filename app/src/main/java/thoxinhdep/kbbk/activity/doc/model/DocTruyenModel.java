package thoxinhdep.kbbk.activity.doc.model;

import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import thoxinhdep.kbbk.activity.doc.entity.DocView;
import thoxinhdep.kbbk.helper.ApiUtils;

/**
 * Created by ThoXinhDep on 9/29/2017.
 */

public class DocTruyenModel implements IeDocTruyenModel {
    private static final String TAG = DocTruyenModel.class.getSimpleName();

    @Override
    public void loadAllTruyenContent(String url, final IeFinishLoadTruyenContent finish) {
        Call<ResponseBody> getAllDataDetail = ApiUtils.getApiServer().getAllDetailData(url);
        getAllDataDetail.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                ArrayList<DocView> listDocView = new ArrayList<DocView>();
                String html = null;
                try {
                    html = response.body().string();
                    Document document = Jsoup.parse(html);
                    Elements rootElements = document.getElementsByClass("vung_doc");
                    for (Element element : rootElements) {
                        Elements imgElements = element.select("img");
                        for (Element eImg : imgElements) {
                            String link = eImg.attr("src");
                            DocView docView = new DocView(link);
                            Log.d(TAG, "onResponse: link view = " + link);
                            listDocView.add(docView);
                        }
                    }
                    finish.onSuccessLoadContnet(listDocView);
                } catch (IOException e) {
                    e.printStackTrace();
                    finish.onErrorLoadContent();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                finish.onErrorLoadContent();
            }
        });
    }
}
