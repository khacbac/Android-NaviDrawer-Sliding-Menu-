package thoxinhdep.kbbk.controller;

import thoxinhdep.kbbk.base.BaseController;

/**
 * Created by doanLV4 on 9/27/2017.
 */

public class FragmentController extends BaseController {

//    private Handler handler = new Handler();
//    private static FragmentController fragmentController;
//
//    public static FragmentController getInstance () {
//        if (fragmentController == null) {
//            fragmentController = new FragmentController();
//        }
//        return fragmentController;
//    }
//
//    @Override
//    public void handleSwitchFragmentTo(final String fragmentTag) {
//        // Sometimes, when fragment has huge data, screen seems hanging
//        // when switching between navigation menus
//        // So using runnable, the fragment is loaded with cross fade effect
//        // This effect can be seen in GMail app
//        Runnable mPendingRunnable = new Runnable() {
//            @Override
//            public void run() {
//                // update the main content by replacing fragments
//                Fragment fragment = getHomeFragment(fragmentTag);
//                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//                fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,
//                        android.R.anim.fade_out);
//                fragmentTransaction.replace(R.id.frame, fragment, currentTag);
//                fragmentTransaction.commitAllowingStateLoss();
//            }
//        };
//
//        handler.post(mPendingRunnable);
//    }
//
//    private Fragment getHomeFragment(String fragmentTag) {
//        switch (fragmentTag) {
//            case Constants.TAG_HOME:
//                return new HomeFragment();
//            case Constants.TAG_PHOTOS:
//                return new PhotosFragment();
//            case Constants.TAG_MOVIES:
//                return new MoviesFragment();
//            case Constants.TAG_NOTIFICATIONS:
//                return new NotificationsFragment();
//            case Constants.TAG_SETTINGS:
//                return new SettingsFragment();
//            default:
//                return new HomeFragment();
//        }
//    }
}
