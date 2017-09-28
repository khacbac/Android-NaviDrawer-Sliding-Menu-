package thoxinhdep.kbbk.activity.tieudiem.fragment.chapter.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import thoxinhdep.kbbk.base.BaseFragment;
import thoxinhdep.kbbk.base.BaseTieuDiemFragment;
import thoxinhdep.kbbk.constant.Constants;
import thoxinhdep.kbbk.helper.ApiUtils;
import thoxinhdep.navigationdrawer.R;

/**
 * Created by ThoXinhDep on 9/28/2017.
 */

// In this case, the fragment displays simple text based on the page
public class ChapterFragment extends BaseTieuDiemFragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    private static final String TAG = ChapterFragment.class.getSimpleName();
    @BindView(R.id.tvTitle)
    TextView txtTitle;

    private int mPage;

    public static ChapterFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        ChapterFragment fragment = new ChapterFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        mPage = getArguments().getInt(ARG_PAGE);
        Log.d(TAG, "onCreate: called");
    }

    // Inflate the fragment layout we defined above for this fragment
    // Set the associated text for the title
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chapter, container, false);
        ButterKnife.bind(this,view);
        super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }

    @Override
    public void initAllView() {

    }

    @Override
    public void initAllData() {
        txtTitle.setText("Fragment Chapter");
    }

    @Override
    public void listenerOnEventClick() {

    }

    @Override
    public void onLoadListChapter(String url) {
        super.onLoadListChapter(url);
        Log.d(TAG, "onLoadListChapter: url = " + url);
        String test = url.replaceAll(Constants.URL_HOME,"");
        Log.d(TAG, "initAllData: test = " + test);

        Call<ResponseBody> getAllDataDetail = ApiUtils.getApiServer().getAllDetailData(test);
        getAllDataDetail.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String html = response.body().string();
                    Log.d(TAG, "onResponse: html = " + html);
                    txtTitle.setText(html);
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.d(TAG, "onFailure: get error");
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d(TAG, "onFailure: get error");
            }
        });
    }
}