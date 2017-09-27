package thoxinhdep.kbbk.activity.main.presenter;

import java.util.ArrayList;

import thoxinhdep.kbbk.activity.main.model.IeMainModel;
import thoxinhdep.kbbk.activity.main.model.MainModel;
import thoxinhdep.kbbk.activity.main.view.IeMainActivity;
import thoxinhdep.kbbk.constant.Constants;

/**
 * Created by ThoXinhDep on 9/27/2017.
 *
 */

public class MainPresenter implements IeMainPresenter, IeMainModel.IeFinishSwitchScreen{

    private IeMainActivity ieMainActivity;
    private IeMainModel ieMainModel;

    public MainPresenter(IeMainActivity ieMainActivity) {
        this.ieMainActivity = ieMainActivity;
        ieMainModel = new MainModel();
    }

    @Override
    public void showFragmentOrActivityById(int itemId) {
        ieMainModel.showFragmentOrActivityById(itemId,this);
    }


    @Override
    public void finishShowFragmentByTag(String fragmentTag) {
        ieMainActivity.hideToggleButton();
        switch (fragmentTag) {
            case Constants.TAG_TIEUDIEM:
                ieMainActivity.showTieuDiemFragment(fragmentTag);
                ieMainActivity.showToggleButton();
                break;
            case Constants.TAG_NOTIFICATION:
                ieMainActivity.showNgauNhienFragment(fragmentTag);
                break;
            case Constants.TAG_NGAUNHIEN:
                ieMainActivity.showMoiDangFragment(fragmentTag);
                break;
            case Constants.TAG_DOCNHIEUNHAT:
                ieMainActivity.showNhieuNhatFragment(fragmentTag);
                break;
            case Constants.TAG_MOIDANG:
                ieMainActivity.showNotificationsFragment(fragmentTag);
                break;
            case Constants.TAG_THELOAITRUYEN:
                ieMainActivity.showTheLoaiFragment(fragmentTag);
                break;
            default:
                ieMainActivity.showTieuDiemFragment(fragmentTag);
                break;
        }
        ieMainActivity.closeDrawerLayout();
    }

    @Override
    public void finishSwitchToAboutActivity() {
        ieMainActivity.closeDrawerLayout();
        ieMainActivity.switchToAboutActivity();
    }

    @Override
    public void finishSwitchToPrivacyActivity() {
        ieMainActivity.closeDrawerLayout();
        ieMainActivity.switchToPrivacyActivity();
    }

}
