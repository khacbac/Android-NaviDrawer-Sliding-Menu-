package com.kbbk.activity.main.model;

/**
 * Created by doanLV4 on 9/27/2017.
 */

public interface IeMainModel {

    interface IeFinishSwitchScreen {
        void finishShowFragmentByTag(String fragmentTag);
        void finishSwitchToAboutActivity();
        void finishSwitchToPrivacyActivity();
    }

    void showFragmentOrActivityById(int itemId, IeFinishSwitchScreen finishSwitchScreen);

}
