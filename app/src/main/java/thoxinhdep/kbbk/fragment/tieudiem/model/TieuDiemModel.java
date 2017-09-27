package thoxinhdep.kbbk.fragment.tieudiem.model;

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
import thoxinhdep.kbbk.helper.ApiUtils;

/**
 * Created by VST on 9/27/2017.
 */

public class TieuDiemModel implements IeTieuDiemModel {
    @Override
    public void getAllFeatureTitle(final IeFinisGetFeatureLink finisGetFeatureLink) {
        Call<ResponseBody> getAllFeatureData = ApiUtils.getApiServer().getAllHomeInfo();
        getAllFeatureData.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Document titleDoc = null;
                ArrayList<String> allLinks = new ArrayList<String>();
                String strData = null;
                try {
                    strData = response.body().string();
                    titleDoc = Jsoup.parse(strData);
                    if (titleDoc != null) {
                        Elements homeSubjectElements = titleDoc.select("div.wrap-focus");
                        Elements titleElements = titleDoc.getElementsByClass("feature_title");
                        if (homeSubjectElements != null && homeSubjectElements.size() > 0) {
                            for (Element element : homeSubjectElements) {
                                Elements linkSubject = element.getElementsByTag("a");
                                if (linkSubject != null) {
                                    for (Element e : linkSubject) {
                                        String linkPage = e.attr("href");
                                        String linkTitle = e.attr("title");
                                        String linkAvatar = e.select("img").first().attr("src");
                                        allLinks.add(linkAvatar);
                                    }
                                }
                            }
                        }
                    }
                    finisGetFeatureLink.onSuccessGetFeatureTitle(allLinks);
                } catch (IOException e) {
                    e.printStackTrace();
                    finisGetFeatureLink.onErrorGetFeatureTitle();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                finisGetFeatureLink.onErrorGetFeatureTitle();
            }
        });
    }
}
