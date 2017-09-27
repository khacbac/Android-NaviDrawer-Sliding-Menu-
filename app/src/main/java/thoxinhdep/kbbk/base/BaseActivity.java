package thoxinhdep.kbbk.base;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import thoxinhdep.kbbk.constant.Constants;
import thoxinhdep.kbbk.fragment.HomeFragment;
import thoxinhdep.kbbk.fragment.MoviesFragment;
import thoxinhdep.kbbk.fragment.NotificationsFragment;
import thoxinhdep.kbbk.fragment.PhotosFragment;
import thoxinhdep.kbbk.fragment.SettingsFragment;

import thoxinhdep.navigationdrawer.R;

/**
 * Created by doanLV4 on 9/27/2017.
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

    public void handleSwitchScreenTo(Class activityTo) {
        Intent intent = new Intent(this,activityTo);
        startActivity(intent);
    }

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
            case Constants.TAG_HOME:
                isHomeFragment = true;
                CURRENT_TAG = Constants.TAG_HOME;
                return new HomeFragment();
            case Constants.TAG_PHOTOS:
                CURRENT_TAG = Constants.TAG_PHOTOS;
                return new PhotosFragment();
            case Constants.TAG_MOVIES:
                CURRENT_TAG = Constants.TAG_MOVIES;
                return new MoviesFragment();
            case Constants.TAG_NOTIFICATIONS:
                CURRENT_TAG = Constants.TAG_NOTIFICATIONS;
                return new NotificationsFragment();
            case Constants.TAG_SETTINGS:
                CURRENT_TAG = Constants.TAG_SETTINGS;
                return new SettingsFragment();
            default:
                isHomeFragment = true;
                CURRENT_TAG = Constants.TAG_HOME;
                return new HomeFragment();
        }
    }

    public void setToolbarTitle(String toolbarTitle){}
}
