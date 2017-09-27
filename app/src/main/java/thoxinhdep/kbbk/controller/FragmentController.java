package thoxinhdep.kbbk.controller;

import thoxinhdep.kbbk.base.BaseController;

/**
 * Created by ThoXinhDep on 9/27/2017.
 *
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
//            case Constants.TAG_TIEUDIEM:
//                return new TieuDiemFragment();
//            case Constants.TAG_NOTIFICATION:
//                return new MoiDangFragment();
//            case Constants.TAG_NGAUNHIEN:
//                return new NhieuNhatFragment();
//            case Constants.TAG_DOCNHIEUNHAT:
//                return new NgauNhienFragment();
//            case Constants.TAG_MOIDANG:
//                return new NotificationsFragment();
//            default:
//                return new TieuDiemFragment();
//        }
//    }
}
