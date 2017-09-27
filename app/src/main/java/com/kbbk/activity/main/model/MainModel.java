package com.kbbk.activity.main.model;

import com.kbbk.constant.Constants;

import info.androidhive.navigationdrawer.R;

/**
 * Created by doanLV4 on 9/27/2017.
 */

public class MainModel implements IeMainModel {

//    private FragmentController fragmentController = FragmentController.getInstance();

    @Override
    public void showFragmentOrActivityById(int itemId, IeFinishSwitchScreen finishSwitchScreen) {
        switch (itemId) {
            //Replacing the main content with ContentFragment Which is our Inbox View;
            case R.id.nav_home:
                finishSwitchScreen.finishShowFragmentByTag(Constants.TAG_HOME);
                break;
            case R.id.nav_photos:
                finishSwitchScreen.finishShowFragmentByTag(Constants.TAG_PHOTOS);
                break;
            case R.id.nav_movies:
                finishSwitchScreen.finishShowFragmentByTag(Constants.TAG_MOVIES);
                break;
            case R.id.nav_notifications:
                finishSwitchScreen.finishShowFragmentByTag(Constants.TAG_NOTIFICATIONS);
                break;
            case R.id.nav_settings:
                finishSwitchScreen.finishShowFragmentByTag(Constants.TAG_SETTINGS);
                break;
            case R.id.nav_about_us:
                finishSwitchScreen.finishSwitchToAboutActivity();
                break;
            case R.id.nav_privacy_policy:
                finishSwitchScreen.finishSwitchToPrivacyActivity();
                break;
            default:
                finishSwitchScreen.finishShowFragmentByTag(Constants.TAG_HOME);
                break;
        }
    }

}
