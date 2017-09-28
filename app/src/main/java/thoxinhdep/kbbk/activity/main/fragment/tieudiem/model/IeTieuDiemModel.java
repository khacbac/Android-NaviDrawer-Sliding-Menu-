package thoxinhdep.kbbk.activity.main.fragment.tieudiem.model;

import java.util.ArrayList;

import thoxinhdep.kbbk.activity.main.fragment.tieudiem.entity.TieuDiemView;

/**
 * Created by VST on 9/27/2017.
 */

public interface IeTieuDiemModel {

    interface IeFinishGetTieuDiemData {
        void onSuccessGetTieuDiemData(ArrayList<TieuDiemView> listTieuDiem);
        void onErrorGetTieuDiemData();
    }

    void getAllFeatureTitle(IeFinishGetTieuDiemData finishGetTieuDiemData);
}
