package thoxinhdep.kbbk.fragment.tieudiem.presenter;

import java.util.ArrayList;

import thoxinhdep.kbbk.fragment.tieudiem.model.IeTieuDiemModel;
import thoxinhdep.kbbk.fragment.tieudiem.model.TieuDiemModel;
import thoxinhdep.kbbk.fragment.tieudiem.view.IeTieuDiemFragment;

/**
 * Created by VST on 9/27/2017.
 */

public class TieuDiemPresenter implements IeTieuDiemPresenter, IeTieuDiemModel.IeFinisGetFeatureLink {

    private IeTieuDiemFragment ieTieuDiemFragment;
    private IeTieuDiemModel ieTieuDiemModel;

    public TieuDiemPresenter(IeTieuDiemFragment ieTieuDiemFragment) {
        this.ieTieuDiemFragment = ieTieuDiemFragment;
        ieTieuDiemModel = new TieuDiemModel();
    }

    @Override
    public void getAllFeatureTitle() {
        ieTieuDiemModel.getAllFeatureTitle(this);
    }

    @Override
    public void onSuccessGetFeatureTitle(ArrayList<String> titles) {
        ieTieuDiemFragment.onSuccessGetFeatureTitle(titles);
    }

    @Override
    public void onErrorGetFeatureTitle() {
        ieTieuDiemFragment.onErrorGetFeatureTitle();
    }
}
