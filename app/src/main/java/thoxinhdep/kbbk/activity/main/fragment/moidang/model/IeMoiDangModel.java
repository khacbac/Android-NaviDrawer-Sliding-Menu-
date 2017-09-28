package thoxinhdep.kbbk.activity.main.fragment.moidang.model;

import java.util.ArrayList;

import thoxinhdep.kbbk.activity.main.fragment.moidang.entity.MoiDangView;

/**
 * Created by ThoXinhDep on 9/28/2017.
 */

public interface IeMoiDangModel {
    interface IeFinishGetMoiDangData {
        void onSuccessGetMoiDangData(ArrayList<MoiDangView> listMoiDang);
        void onErrorGetMoiDangData();
    }

    void getAllMoiDangData(IeFinishGetMoiDangData finishGetMoiDangData);
}
