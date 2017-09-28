package thoxinhdep.kbbk.base;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import thoxinhdep.kbbk.constant.Constants;
import thoxinhdep.kbbk.activity.main.fragment.moidang.view.MoiDangFragment;
import thoxinhdep.kbbk.activity.main.fragment.NhieuNhatFragment;
import thoxinhdep.kbbk.activity.main.fragment.NotificationsFragment;
import thoxinhdep.kbbk.activity.main.fragment.TheLoaiFragment;
import thoxinhdep.kbbk.activity.main.fragment.tieudiem.view.TieuDiemFragment;
import thoxinhdep.kbbk.activity.main.fragment.NgauNhienFragment;

import thoxinhdep.navigationdrawer.R;

/**
 * Created by ThoXinhDep on 9/27/2017.
 *
 */

public abstract class BaseActivity extends AppCompatActivity {

    private static Handler handler = new Handler();
    public static boolean isHomeFragment = false;
    public static String CURRENT_TAG = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        onEnter();
        super.onCreate(savedInstanceState);
        initView();
        initData();
        listenerOnClickEvent();
    }

    public abstract void initView();
    public abstract void initData();
    public abstract void listenerOnClickEvent();
    public abstract void onEnter();

    public void handleSwitchFragmentTo(final String fragmentTag) {
        // Sometimes, when fragment has huge data, screen seems hanging
        // when switching between navigation menus
        // So using runnable, the fragment is loaded with cross fade effect
        // This effect can be seen in GMail app
        Runnable mPendingRunnable = new Runnable() {
            @Override
            public void run() {
                // update the main content by replacing fragments
                Fragment fragment = getHomeFragment(fragmentTag);
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,
                        android.R.anim.fade_out);
                fragmentTransaction.replace(R.id.frame, fragment, fragmentTag);
                fragmentTransaction.commitAllowingStateLoss();
            }
        };

        handler.post(mPendingRunnable);
        // Cll to refresh menu for option menu.
        invalidateOptionsMenu();
    }

    private Fragment getHomeFragment(String fragmentTag) {
        setToolbarTitle(fragmentTag);
        isHomeFragment = false;
        switch (fragmentTag) {
            case Constants.TAG_TIEUDIEM:
                isHomeFragment = true;
                CURRENT_TAG = Constants.TAG_TIEUDIEM;
                return new TieuDiemFragment();
            case Constants.TAG_MOIDANG:
                CURRENT_TAG = Constants.TAG_MOIDANG;
                return new MoiDangFragment();
            case Constants.TAG_DOCNHIEUNHAT:
                CURRENT_TAG = Constants.TAG_DOCNHIEUNHAT;
                return new NhieuNhatFragment();
            case Constants.TAG_NGAUNHIEN:
                CURRENT_TAG = Constants.TAG_NGAUNHIEN;
                return new NgauNhienFragment();
            case Constants.TAG_NOTIFICATION:
                CURRENT_TAG = Constants.TAG_NOTIFICATION;
                return new NotificationsFragment();
            case Constants.TAG_THELOAITRUYEN:
                CURRENT_TAG = Constants.TAG_THELOAITRUYEN;
                return new TheLoaiFragment();
            default:
                isHomeFragment = true;
                CURRENT_TAG = Constants.TAG_TIEUDIEM;
                return new TieuDiemFragment();
        }
    }

    public void setToolbarTitle(String toolbarTitle){}
}
