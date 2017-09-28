package thoxinhdep.kbbk.activity.main.fragment.tieudiem.presenter;

import java.util.ArrayList;

import thoxinhdep.kbbk.activity.main.fragment.tieudiem.entity.TieuDiemView;
import thoxinhdep.kbbk.activity.main.fragment.tieudiem.model.IeTieuDiemModel;
import thoxinhdep.kbbk.activity.main.fragment.tieudiem.model.TieuDiemModel;
import thoxinhdep.kbbk.activity.main.fragment.tieudiem.view.IeTieuDiemFragment;

/**
 * Created by VST on 9/27/2017.
 */

public class TieuDiemPresenter implements IeTieuDiemPresenter, IeTieuDiemModel.IeFinishGetTieuDiemData {

    private IeTieuDiemFragment ieTieuDiemFragment;
    private IeTieuDiemModel ieTieuDiemModel;

    public TieuDiemPresenter(IeTieuDiemFragment ieTieuDiemFragment) {
        this.ieTieuDiemFragment = ieTieuDiemFragment;
        ieTieuDiemModel = new TieuDiemModel();
    }

    @Override
    public void getAllDataForTieuDiem() {
        ieTieuDiemModel.getAllFeatureTitle(this);
    }

    @Override
    public void onSuccessGetTieuDiemData(ArrayList<TieuDiemView> listTieuDiem) {
        ieTieuDiemFragment.onSuccessGetTieuDiemData(listTieuDiem);
    }

    @Override
    public void onErrorGetTieuDiemData() {
        ieTieuDiemFragment.onErrorGetTieuDiemData();
    }
}
