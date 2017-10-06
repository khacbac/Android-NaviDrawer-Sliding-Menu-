package thoxinhdep.kbbk.activity.tieudiem.fragment.chapter.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import java.util.ArrayList;
import thoxinhdep.kbbk.activity.tieudiem.fragment.adapter.CustomChapterAdapter;
import thoxinhdep.kbbk.activity.tieudiem.fragment.chapter.entity.ChapterView;
import thoxinhdep.kbbk.activity.tieudiem.fragment.chapter.presenter.ChapterPresenter;
import thoxinhdep.kbbk.activity.tieudiem.fragment.chapter.presenter.IeChapterPresenter;
import thoxinhdep.kbbk.base.BaseTieuDiemFragment;
import thoxinhdep.kbbk.common.EndlessScrollListener;
import thoxinhdep.kbbk.database.TruyenEntity;
import thoxinhdep.kbbk.database.TruyenTranhDBHelper;
import thoxinhdep.navigationdrawer.R;
import thoxinhdep.navigationdrawer.databinding.FragmentChapterBinding;

/**
 * Created by ThoXinhDep on 9/28/2017.
 */

// In this case, the fragment displays simple text based on the page
public class ChapterFragment extends BaseTieuDiemFragment implements IeChapterFragment{
    private static final String TAG = ChapterFragment.class.getSimpleName();
    private IeChapterPresenter ieChapterPresenter;
    private CustomChapterAdapter layoutAdapter;
    private FragmentChapterBinding binding;

    private TruyenTranhDBHelper dbHelper;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return binding.getRoot();
    }

    @Override
    public void bindingLayout(LayoutInflater inflater, ViewGroup container) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_chapter, container, false);
    }


    @Override
    public void initAllView() {
        ieChapterPresenter = new ChapterPresenter(this);
        layoutAdapter = new CustomChapterAdapter();
        binding.setAdapter(layoutAdapter);
        dbHelper = new TruyenTranhDBHelper(getActivity());

//        binding.recyclerView.addOnScrollListener(new EndlessScrollListener() {
//            @Override
//            public boolean onLoadMore(int page, int totalItemsCount) {
//                // Triggered only when new data needs to be appended to the list
//                // Add whatever code is needed to append new items to your AdapterView
//                loadNextDataFromApi(page);
//                // or loadNextDataFromApi(totalItemsCount);
//                return true; // ONLY if more data is actually being loaded; false otherwise.
//            }
//        });
//        setHasOptionsMenu(true);
    }

    @Override
    public void initAllData() {

    }

    @Override
    public void listenerOnEventClick() {

    }

    @Override
    public void onLoadListChapter(String intentUrl, String urlId) {
        super.onLoadListChapter(intentUrl, urlId);
        binding.aviIndicateView.show();
        ieChapterPresenter.loadAllChapter(intentUrl, urlId);
    }

    @Override
    public void onSuccessLoadAllChapter(ArrayList<ChapterView> listChapter) {
        if (listChapter.isEmpty()) {
            return;
        }
        layoutAdapter.setChapterList(listChapter);
        binding.aviIndicateView.hide();

        Log.d(TAG, "onSuccessLoadAllChapter: size = " + listChapter.size());
        TruyenEntity entity = dbHelper.getTruyenTranhByTruyenId(listChapter.get(0).getUrlID());
        ArrayList<String> listTitleClick = entity.getListCLicked();
        for (String title : listTitleClick) {
            Log.d(TAG, "onSuccessLoadAllChapter: item has click = " + title);
        }
        layoutAdapter.setBackGroundForChapterHasClick(listTitleClick);
        dbHelper.close();

    }

    @Override
    public void onErrorLoadAllChapter() {
        Toast.makeText(getActivity(), getString(R.string.str_error_load_data),Toast.LENGTH_SHORT).show();
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