package thoxinhdep.kbbk.untils;

import android.app.Activity;
import android.content.Intent;

import thoxinhdep.kbbk.activity.about.AboutUsActivity;
import thoxinhdep.kbbk.activity.privacy.PrivacyPolicyActivity;

/**
 * Created by doanLV4 on 9/27/2017.
 */

public class NavigateActivityUtils {

    public static void handleSwitchToAboutScreen(Activity activity) {
        Intent intent = new Intent(activity, AboutUsActivity.class);
        activity.startActivity(intent);
    }

    public static void handleSwitchToPrivacyScreen(Activity activity) {
        Intent intent = new Intent(activity, PrivacyPolicyActivity.class);
        activity.startActivity(intent);
    }
}
