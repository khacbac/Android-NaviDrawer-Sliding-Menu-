package thoxinhdep.kbbk.activity.doc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import thoxinhdep.kbbk.activity.doc.adapter.CustomDocAdapter;
import thoxinhdep.kbbk.activity.doc.entity.DocView;
import thoxinhdep.kbbk.base.BaseActivity;
import thoxinhdep.kbbk.constant.Constants;
import thoxinhdep.kbbk.helper.ApiUtils;
import thoxinhdep.navigationdrawer.R;

/**
 * Created by VST on 9/28/2017.
 */

public class DocActivity extends BaseActivity {

    private static final String TAG = DocActivity.class.getSimpleName();
    private String intentUrl;

    private ArrayList<DocView> listDocView = new ArrayList<>();
    private CustomDocAdapter layoutAdapter;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {
        setContentView(R.layout.activity_doc);
        ButterKnife.bind(this);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        intentUrl = getIntent().getStringExtra(Constants.TAG_DOCSCREEN);
        Log.d(TAG, "initView: url = " + intentUrl);

        layoutAdapter = new CustomDocAdapter(this);
        RecyclerView.LayoutManager mLayoutManager
                = new GridLayoutManager(this, 1, GridLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(layoutAdapter);
    }

    @Override
    public void initData() {
        String test = intentUrl.replaceAll(Constants.URL_HOME,"");
        Call<ResponseBody> getAllDataDetail = ApiUtils.getApiServer().getAllDetailData(test);
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
                            listDocView.add(docView);
                        }
                    }
                    layoutAdapter.setDocViewList(listDocView);
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    @Override
    public void listenerOnClickEvent() {

    }

    @Override
    public void onEnter() {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            // finish the activity
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
