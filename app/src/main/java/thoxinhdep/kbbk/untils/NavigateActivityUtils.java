package thoxinhdep.kbbk.untils;

import android.app.Activity;
import android.content.Intent;

import thoxinhdep.kbbk.activity.doctruyen.view.DocTruyenActivity;
import thoxinhdep.kbbk.activity.tieudiem.view.TieuDiemActivity;
import thoxinhdep.kbbk.activity.privacy.PrivacyPolicyActivity;
import thoxinhdep.kbbk.constant.Constants;

/**
 * Created by ThoXinhDep on 9/27/2017.
 *
 */

public class NavigateActivityUtils {

    public static void handleSwitchToAboutScreen(Activity activity) {
        Intent intent = new Intent(activity, TieuDiemActivity.class);
        activity.startActivity(intent);
    }

    public static void handleSwitchToAboutScreen(Activity activity, String url) {
        Intent intent = new Intent(activity, TieuDiemActivity.class);
        intent.putExtra(Constants.TAG_TIEUDIEM, url);
        activity.startActivity(intent);
    }

    public static void handleSwitchToPrivacyScreen(Activity activity) {
        Intent intent = new Intent(activity, PrivacyPolicyActivity.class);
        activity.startActivity(intent);
    }

    public static void handleSwitchToDocScreen(Activity activity, String url) {
        Intent intent = new Intent(activity, DocTruyenActivity.class);
        intent.putExtra(Constants.TAG_DOCSCREEN, url);
        activity.startActivity(intent);
    }
}
