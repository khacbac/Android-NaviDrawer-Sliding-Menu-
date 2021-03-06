package thoxinhdep.kbbk.activity.tieudiem.fragment.chapter.binder;

import android.app.Activity;
import android.databinding.BindingAdapter;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import thoxinhdep.kbbk.activity.tieudiem.fragment.adapter.CustomChapterAdapter;
import thoxinhdep.kbbk.activity.tieudiem.fragment.chapter.entity.ChapterView;
import thoxinhdep.kbbk.activity.tieudiem.fragment.customview.ChapterLayout;
import thoxinhdep.kbbk.common.EndlessScrollListener;
import thoxinhdep.kbbk.common.listener.OnLoadMoreListener;
import thoxinhdep.kbbk.common.listener.RecyclerViewLoadMoreScroll;
import thoxinhdep.kbbk.database.TruyenTranhDBHelper;
import thoxinhdep.kbbk.untils.NavigateActivityUtils;
import thoxinhdep.navigationdrawer.R;

/**
 * Created by doanLV4 on 10/3/2017.
 */

public class ChapterBinder {

    private static final String TAG = ChapterBinder.class.getSimpleName();
    private static TruyenTranhDBHelper dbHelper;

    @BindingAdapter("bind:adapter")
    public static void bindAdapter(RecyclerView recycler, CustomChapterAdapter adapter) {
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(recycler.getContext());
        recycler.setLayoutManager(mLayoutManager);
        recycler.setItemAnimator(new DefaultItemAnimator());
        recycler.setAdapter(adapter);

        RecyclerViewLoadMoreScroll scroll = new RecyclerViewLoadMoreScroll(mLayoutManager);
        scroll.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                Log.d(TAG, "onLoadMore: load next item");
            }
        });
        recycler.addOnScrollListener(scroll);
    }

    @BindingAdapter("bind:chapter")
    public static void bindChapter(ChapterLayout layout, ChapterView view) {
        layout.bindChapterView(view);
    }

    @BindingAdapter("bind:onItemClick")
    public static void bindEventClick(final ChapterLayout layout, final ChapterView view) {
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setHadClick(true);
                layout.updateItemClick();
//                layout.setBackground(drawable);
//                layout.setAlpha(view.isHadClick() ? 1f : 0.5f);
                dbHelper = new TruyenTranhDBHelper(layout.getContext());
                // Them danh sach cac chap da xem tuy theo moi id cua truyen tuong ung.
                dbHelper.updateDataWithColumn(view.getUrlID(),view.getChapterTitle());
                NavigateActivityUtils.handleSwitchToDocScreen((Activity) layout.getContext(), view.getLink());
                Log.d(TAG, "onClick: url = " + view.getLink());
            }
        });
    }

    @BindingAdapter("bind:textColor")
    public static void bindTextColor(TextView textView, int color) {
        textView.setTextColor(color);
    }
}
