package thoxinhdep.kbbk.activity.main.presenter;

import thoxinhdep.kbbk.activity.main.model.IeMainModel;
import thoxinhdep.kbbk.activity.main.model.MainModel;
import thoxinhdep.kbbk.activity.main.view.IeMainActivity;
import thoxinhdep.kbbk.constant.Constants;

/**
 * Created by doanLV4 on 9/27/2017.
 */

public class MainPresenter implements IeMainPresenter, IeMainModel.IeFinishSwitchScreen {

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
            case Constants.TAG_HOME:
                ieMainActivity.showHomeFragment(fragmentTag);
                ieMainActivity.showToggleButton();
                break;
            case Constants.TAG_PHOTOS:
                ieMainActivity.showPhotosFragment(fragmentTag);
                break;
            case Constants.TAG_MOVIES:
                ieMainActivity.showMoviesFragment(fragmentTag);
                break;
            case Constants.TAG_NOTIFICATIONS:
                ieMainActivity.showNotificationsFragment(fragmentTag);
                break;
            case Constants.TAG_SETTINGS:
                ieMainActivity.showSettingsFragment(fragmentTag);
                break;
            default:
                ieMainActivity.showHomeFragment(fragmentTag);
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
