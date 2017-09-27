package thoxinhdep.kbbk.activity.main.model;

import java.util.ArrayList;

/**
 * Created by ThoXinhDep on 9/27/2017.
 *
 */

public interface IeMainModel {

    interface IeFinishSwitchScreen {
        void finishShowFragmentByTag(String fragmentTag);
        void finishSwitchToAboutActivity();
        void finishSwitchToPrivacyActivity();
    }

    void showFragmentOrActivityById(int itemId, IeFinishSwitchScreen finishSwitchScreen);
}
