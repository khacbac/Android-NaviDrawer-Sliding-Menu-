package thoxinhdep.kbbk.activity.main.fragment.moidang.model;

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
import thoxinhdep.kbbk.activity.main.fragment.moidang.entity.MoiDangView;
import thoxinhdep.kbbk.helper.ApiUtils;

/**
 * Created by ThoXinhDep on 9/28/2017.
 */

public class MoiDangModel implements IeMoiDangModel {
    @Override
    public void getAllMoiDangData(final IeFinishGetMoiDangData finishGetMoiDangData) {
        Call<ResponseBody> getAllFeatureData = ApiUtils.getApiServer().getAllHomeInfo();
        getAllFeatureData.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                ArrayList<MoiDangView> listMoiDangDatas = new ArrayList<>();
                try {
                    String htmlResponse = response.body().string();
                    Document htmlDoc = Jsoup.parse(htmlResponse);
                    if (htmlDoc != null) {
                        Elements rootElements = htmlDoc.getElementsByClass(Constants.TAG_MOIDANG_CLASS);
//                        Elements childElements = rootElements.select("div.wrap-focus");
                        if (rootElements != null && rootElements.size() > 0) {
                            for (Element childWrapFocus : rootElements) {
                                Elements childTagA = childWrapFocus.getElementsByTag("a");
                                if (childTagA != null) {
                                    for (Element childA : childTagA) {
                                        String linkPage = childA.attr("href");
                                        String linkTitle = childA.attr("title");
                                        // Get url avatar.
                                        String linkAvatar = childA.select("img").first().attr("src");

                                        MoiDangView view = new MoiDangView(linkTitle,
                                                linkPage, linkAvatar);
                                        listMoiDangDatas.add(view);
                                    }
                                }
                            }
                        }
                    }
                    finishGetMoiDangData.onSuccessGetMoiDangData(listMoiDangDatas);
                } catch (IOException e) {
                    e.printStackTrace();
                    finishGetMoiDangData.onErrorGetMoiDangData();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                finishGetMoiDangData.onErrorGetMoiDangData();
            }
        });
    }
}
