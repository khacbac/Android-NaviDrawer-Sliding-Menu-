package thoxinhdep.kbbk.activity.main.fragment.moidang.view;

import java.util.ArrayList;

import thoxinhdep.kbbk.activity.main.fragment.moidang.entity.MoiDangView;

/**
 * Created by ThoXinhDep on 9/28/2017.
 */

public interface IeMoiDangFragment {
    void onSuccessGetMoiDangMenu(ArrayList<MoiDangView> listMoiDang);
    void onErrorGetMoiDangMenu();
}
