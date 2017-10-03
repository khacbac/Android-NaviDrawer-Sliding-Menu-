package thoxinhdep.kbbk.activity.tieudiem.fragment.chapter.model;

import android.os.AsyncTask;
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
import thoxinhdep.kbbk.activity.tieudiem.fragment.chapter.entity.ChapterView;
import thoxinhdep.kbbk.constant.Constants;
import thoxinhdep.kbbk.helper.ApiUtils;

/**
 * Created by ThoXinhDep on 9/28/2017.
 */

public class ChapterModel implements IeChapterModel {

    private static final String TAG = ChapterModel.class.getSimpleName();
    private ArrayList<ChapterView> listChapter = new ArrayList<>();

    @Override
    public void loadAllChapter(String urlGet, final IeOnFisnishLoadAllChapter loadAllChapter) {
        String data = urlGet.replaceAll(Constants.URL_HOME,"");
        Call<ResponseBody> getAllDataDetail = ApiUtils.getApiServer().getAllDetailData(data);
        getAllDataDetail.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String html = response.body().string();
                    Log.d(TAG, "onResponse: html = " + html);

                    Document document = Jsoup.parse(html);
                    Elements rootElements = document.getElementsByClass("chapter-list");
                    Elements rowElements = rootElements.select("div.row");
                    for (Element element : rowElements) {
                        Elements urlTagA = element.getElementsByTag("a");
                        // Get ngay dang .
                        String[] textContainNgayDang = element.text().split(" ");
                        String ngayDang = textContainNgayDang[textContainNgayDang.length - 1];
                        for (Element child : urlTagA) {
                            String chapTitle = child.attr("title");
                            String chapLink = child.attr("href");
                            ChapterView view = new ChapterView(chapTitle, ngayDang, chapLink);
                            listChapter.add(view);
                        }
                    }
                    loadAllChapter.onSuccessLoadAllChapter(listChapter);
                } catch (IOException e) {
                    e.printStackTrace();
                    loadAllChapter.onErrorLoadALlChapter();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                loadAllChapter.onErrorLoadALlChapter();
            }
        });
    }
}
