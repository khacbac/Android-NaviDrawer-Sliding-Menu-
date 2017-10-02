package thoxinhdep.kbbk.activity.main.fragment.tieudiem.model;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
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
//        Call<ResponseBody> getAllFeatureData = ApiUtils.getApiServer().getAllHomeInfo();
        Call<ResponseBody> getAllFeatureData = ApiUtils.getApiServer().getAllHomeData();
        getAllFeatureData.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                String body = null;
                final ArrayList<TieuDiemView> listTieuDiemDatas = new ArrayList<>();
                try {
                    body = response.body().string();
                    JSONArray jsonArray = new JSONArray(body);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject object = jsonArray.getJSONObject(i);
//                        Log.d(TAG, "onResponse: label = " + object.getString("label"));
//                        Log.d(TAG, "onResponse: link = " + object.getString("link"));
                        final String label = object.getString("label");
                        final String[] avatarUrl = new String[1];
                        final String link = object.getString("link");
                        final TieuDiemView view = new TieuDiemView(avatarUrl[0], label, link);

                        /*Start get all detail data*/
                        String linkSplit = link.replaceAll(Constants.URL_HOME, "");
                        Call<ResponseBody> getAllDetail = ApiUtils.getApiServer().getAllDetailData(linkSplit);
                        getAllDetail.enqueue(new Callback<ResponseBody>() {
                            @Override
                            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                                try {
                                    Document htmlDoc = Jsoup.parse(response.body().string());
                                    if (htmlDoc != null) {
                                        Elements rootElement = htmlDoc.getElementsByClass("truyen_info_left");
                                        for (Element element : rootElement) {
                                            Elements childElement = element.getElementsByTag("img");
                                            for (Element e : childElement) {
                                                avatarUrl[0] = e.attr("src");
                                                view.setAvatarUrl(avatarUrl[0]);
                                            }
                                            Log.d(TAG, "onResponse: avatar = " + avatarUrl[0]);
                                        }
                                    }
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onFailure(Call<ResponseBody> call, Throwable t) {
                                finisGetFeatureLink.onErrorGetTieuDiemData();
                            }
                        });
                        /*End get all detail data*/

                        Log.d(TAG, "onResponse: get avatar = " + view.getAvatarUrl());
                        listTieuDiemDatas.add(view);
                    }
                    finisGetFeatureLink.onSuccessGetTieuDiemData(listTieuDiemDatas);
                } catch (IOException | JSONException e) {
                    finisGetFeatureLink.onErrorGetTieuDiemData();
                }


//                ArrayList<TieuDiemView> listTieuDiemDatas = new ArrayList<>();
//                try {
//                    String htmlResponse = response.body().string();
//                    Document htmlDoc = Jsoup.parse(htmlResponse);
//                    if (htmlDoc != null) {
//                        Elements rootElements = htmlDoc.getElementsByClass(Constants.TAG_TIEUDIEM_CLASS);
//                        Elements childElements = rootElements.select("div.wrap-focus");
//                        if (childElements != null && childElements.size() > 0) {
//                            for (Element childWrapFocus : childElements) {
//                                Elements childTagA = childWrapFocus.getElementsByTag("a");
//                                if (childTagA != null) {
//                                    for (Element childA : childTagA) {
//                                        String linkPage = childA.attr("href");
//                                        String linkTitle = childA.attr("title");
//                                        // Get url avatar.
//                                        String linkAvatar = childA.select("img").first().attr("src");
//                                        // Get best url for img avatar.
//                                        String srcsetAvatar = childA.select("img").first().attr("srcset");
//                                        String[] srcSplit1 = srcsetAvatar.split(",");
//                                        String[] scrSplit2 = srcSplit1[srcSplit1.length-1].split(" ");
//                                        if (scrSplit2.length > 0) {
//                                            for (String srcSplit : scrSplit2) {
//                                                if (srcSplit.contains("http:")) {
//                                                    linkAvatar = srcSplit;
//                                                    break;
//                                                }
//                                            }
//                                        }
//                                        TieuDiemView view = new TieuDiemView(linkAvatar,
//                                                linkTitle, linkPage);
//                                        listTieuDiemDatas.add(view);
//                                    }
//                                }
//                            }
//                        }
//                    }
//                    finisGetFeatureLink.onSuccessGetTieuDiemData(listTieuDiemDatas);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                    finisGetFeatureLink.onErrorGetTieuDiemData();
//                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                finisGetFeatureLink.onErrorGetTieuDiemData();
            }
        });
    }
}
