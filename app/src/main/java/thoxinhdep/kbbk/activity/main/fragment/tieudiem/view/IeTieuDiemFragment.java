package thoxinhdep.kbbk.activity.main.fragment.tieudiem.view;

import java.util.ArrayList;

import thoxinhdep.kbbk.activity.main.fragment.tieudiem.entity.TieuDiemView;

/**
 * Created by VST on 9/27/2017.
 */

public interface IeTieuDiemFragment {
    void onSuccessGetTieuDiemData(ArrayList<TieuDiemView> listTieuDiem);
    void onErrorGetTieuDiemData();
}
