package thoxinhdep.kbbk.activity.main.fragment.moidang.presenter;

import java.util.ArrayList;

import thoxinhdep.kbbk.activity.main.fragment.moidang.entity.MoiDangView;
import thoxinhdep.kbbk.activity.main.fragment.moidang.model.IeMoiDangModel;
import thoxinhdep.kbbk.activity.main.fragment.moidang.model.MoiDangModel;
import thoxinhdep.kbbk.activity.main.fragment.moidang.view.IeMoiDangFragment;

/**
 * Created by ThoXinhDep on 9/28/2017.
 */

public class MoiDangPresenter implements IeMoiDangPresenter, IeMoiDangModel.IeFinishGetMoiDangData {

    private IeMoiDangFragment ieMoiDangFragment;
    private IeMoiDangModel ieMoiDangModel;

    public MoiDangPresenter(IeMoiDangFragment ieMoiDangFragment) {
        this.ieMoiDangFragment = ieMoiDangFragment;
        ieMoiDangModel = new MoiDangModel();
    }

    @Override
    public void getAllDataForMoiDangMenu() {
        ieMoiDangModel.getAllMoiDangData(this);
    }

    @Override
    public void onSuccessGetMoiDangData(ArrayList<MoiDangView> listMoiDang) {
        ieMoiDangFragment.onSuccessGetMoiDangMenu(listMoiDang);
    }

    @Override
    public void onErrorGetMoiDangData() {
        ieMoiDangFragment.onErrorGetMoiDangMenu();
    }
}
