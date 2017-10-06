package thoxinhdep.kbbk.activity.main.fragment.tieudiem.entity;

import android.app.Activity;
import android.databinding.BindingAdapter;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

import thoxinhdep.kbbk.activity.main.fragment.tieudiem.adapter.CustomTieuDiemAdapter;
import thoxinhdep.kbbk.constant.Constants;
import thoxinhdep.kbbk.customviews.TieuDiemLayoutView;
import thoxinhdep.kbbk.untils.NavigateActivityUtils;

/**
 * Created by doanLV4 on 10/3/2017.
 */

public class TieuDiemViewBinder {
    @BindingAdapter("bind:image")
    public static void bindImage(ImageView imageView, String url) {
        // Loading profile image
        Glide.with(imageView.getContext()).load(url)
                .crossFade()
                .thumbnail(0.5f)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
    }

    @BindingAdapter("bind:onClick")
    public static void bindOnClick(final ImageView imageView, final TieuDiemView view) {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyen huong sang man hinh hien thi thong tin va danh sach chapter.
                NavigateActivityUtils.handleSwitchToAboutScreen(
                        (Activity) imageView.getContext(),
                        Constants.URL_SHORTLINK + view.getTxtUrlId(), view.getTxtUrlId());
            }
        });
    }

    @BindingAdapter("bind:adapter")
    public static void bindItemList(RecyclerView recycler, CustomTieuDiemAdapter adapter) {
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(recycler.getContext(), 3);
        recycler.setLayoutManager(mLayoutManager);
        recycler.setItemAnimator(new DefaultItemAnimator());
        recycler.setAdapter(adapter);
    }

    @BindingAdapter("bind:tieudiemview")
    public static void bindView(TieuDiemLayoutView layout, TieuDiemView view) {
        layout.bindDingTieuDiemView(view);
    }

}
