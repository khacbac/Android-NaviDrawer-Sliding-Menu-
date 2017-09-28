package thoxinhdep.kbbk.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import thoxinhdep.kbbk.activity.tieudiem.listener.IeTieuDiemListener;
import thoxinhdep.kbbk.activity.tieudiem.view.TieuDiemActivity;

/**
 * Created by ThoXinhDep on 9/28/2017.
 */

public abstract class BaseTieuDiemFragment extends BaseFragment implements IeTieuDiemListener{

    private static final String TAG = BaseTieuDiemFragment.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        // start listener event from activity.
        ((TieuDiemActivity)getActivity()).setOnTieuDiemListener(this);
        return null;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void initAllData() {

    }

    @Override
    public void onLoadAllListChapter(String url) {
        onLoadListChapter(url);
        onLoadInfomation(url);
        onLoadComment(url);
    }

    public void onLoadListChapter(String url) {

    }
    public void onLoadInfomation(String url) {

    }
    public void onLoadComment(String url) {

    }
}
