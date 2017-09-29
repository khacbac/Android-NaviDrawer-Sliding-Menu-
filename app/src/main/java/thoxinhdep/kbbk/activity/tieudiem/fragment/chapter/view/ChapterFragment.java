package thoxinhdep.kbbk.activity.tieudiem.fragment.chapter.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.wang.avi.AVLoadingIndicatorView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import thoxinhdep.kbbk.activity.main.fragment.tieudiem.adapter.CustomTieuDiemAdapter;
import thoxinhdep.kbbk.activity.tieudiem.fragment.adapter.CustomChapterAdapter;
import thoxinhdep.kbbk.activity.tieudiem.fragment.chapter.entity.ChapterView;
import thoxinhdep.kbbk.activity.tieudiem.fragment.chapter.presenter.ChapterPresenter;
import thoxinhdep.kbbk.activity.tieudiem.fragment.chapter.presenter.IeChapterPresenter;
import thoxinhdep.kbbk.base.BaseFragment;
import thoxinhdep.kbbk.base.BaseTieuDiemFragment;
import thoxinhdep.kbbk.constant.Constants;
import thoxinhdep.kbbk.helper.ApiUtils;
import thoxinhdep.navigationdrawer.R;

/**
 * Created by ThoXinhDep on 9/28/2017.
 */

// In this case, the fragment displays simple text based on the page
public class ChapterFragment extends BaseTieuDiemFragment implements IeChapterFragment{
    public static final String ARG_PAGE = "ARG_PAGE";
    private static final String TAG = ChapterFragment.class.getSimpleName();

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.aviIndicateView)
    AVLoadingIndicatorView aviIndicateView;

    private IeChapterPresenter ieChapterPresenter;
    private ArrayList<ChapterView> listTieuDiem = new ArrayList<>();
    private CustomChapterAdapter layoutAdapter;


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
        ieChapterPresenter = new ChapterPresenter(this);
        layoutAdapter = new CustomChapterAdapter(getActivity());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(layoutAdapter);
//        setHasOptionsMenu(true);
    }

    @Override
    public void initAllData() {
    }

    @Override
    public void listenerOnEventClick() {

    }

    @Override
    public void onLoadListChapter(String url) {
        super.onLoadListChapter(url);
        aviIndicateView.show();
        ieChapterPresenter.loadAllChapter(url);
    }

    @Override
    public void onSuccessLoadAllChapter(ArrayList<ChapterView> listChapter) {
        layoutAdapter.setChapterList(listChapter);
        aviIndicateView.hide();
    }

    @Override
    public void onErrorLoadAllChapter() {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_tangdan:
                Log.d(TAG, "onOptionsItemSelected: sap xep tang dan");
                layoutAdapter.sortTangDan();
                break;
            case R.id.action_giamdan:
                Log.d(TAG, "onOptionsItemSelected: sap xep giam dan");
                layoutAdapter.sortGiamDan();
                break;
            default:
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}