package thoxinhdep.kbbk.activity.main.fragment.tieudiem.model;

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
import thoxinhdep.kbbk.constant.Constants;
import thoxinhdep.kbbk.activity.main.fragment.tieudiem.entity.TieuDiemView;
import thoxinhdep.kbbk.helper.ApiUtils;

/**
 * Created by VST on 9/27/2017.
 */

public class TieuDiemModel implements IeTieuDiemModel {
    private static final String TAG = TieuDiemModel.class.getSimpleName();

    @Override
    public void getAllFeatureTitle(final IeFinishGetTieuDiemData finisGetFeatureLink) {
        Call<ResponseBody> getAllFeatureData = ApiUtils.getApiServer().getAllHomeInfo();
        getAllFeatureData.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                ArrayList<TieuDiemView> listTieuDiemDatas = new ArrayList<>();
                try {
                    String htmlResponse = response.body().string();
                    Document htmlDoc = Jsoup.parse(htmlResponse);
                    if (htmlDoc != null) {
                        Elements rootElements = htmlDoc.getElementsByClass(Constants.TAG_TIEUDIEM_CLASS);
                        Elements childElements = rootElements.select("div.wrap-focus");
                        if (childElements != null && childElements.size() > 0) {
                            for (Element childWrapFocus : childElements) {
                                Elements childTagA = childWrapFocus.getElementsByTag("a");
                                if (childTagA != null) {
                                    for (Element childA : childTagA) {
                                        String linkPage = childA.attr("href");
                                        String linkTitle = childA.attr("title");
                                        // Get url avatar.
                                        String linkAvatar = childA.select("img").first().attr("src");
                                        // Get best url for img avatar.
                                        String srcsetAvatar = childA.select("img").first().attr("srcset");
                                        String[] srcSplit1 = srcsetAvatar.split(",");
                                        String[] scrSplit2 = srcSplit1[srcSplit1.length-1].split(" ");
                                        if (scrSplit2.length > 0) {
                                            for (String srcSplit : scrSplit2) {
                                                if (srcSplit.contains("http:")) {
                                                    linkAvatar = srcSplit;
                                                    break;
                                                }
                                            }
                                        }
                                        TieuDiemView view = new TieuDiemView(linkAvatar,
                                                linkTitle, linkPage);
                                        listTieuDiemDatas.add(view);
                                    }
                                }
                            }
                        }
                    }
                    finisGetFeatureLink.onSuccessGetTieuDiemData(listTieuDiemDatas);
                } catch (IOException e) {
                    e.printStackTrace();
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
