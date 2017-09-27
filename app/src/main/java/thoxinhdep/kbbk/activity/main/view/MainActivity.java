package thoxinhdep.kbbk.activity.main.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import thoxinhdep.kbbk.untils.NavigateActivityUtils;
import thoxinhdep.navigationdrawer.R;
import thoxinhdep.kbbk.activity.about.AboutUsActivity;
import thoxinhdep.kbbk.activity.main.presenter.IeMainPresenter;
import thoxinhdep.kbbk.activity.main.presenter.MainPresenter;
import thoxinhdep.kbbk.base.BaseActivity;
import thoxinhdep.kbbk.activity.privacy.PrivacyPolicyActivity;
import thoxinhdep.kbbk.constant.Constants;
import thoxinhdep.kbbk.other.CircleTransform;

public class MainActivity extends BaseActivity implements IeMainActivity{

    private static final String TAG = MainActivity.class.getSimpleName();
    private NavigationView navigationView;
    private DrawerLayout drawer;
    private View navHeader;
    private ImageView imgNavHeaderBg, imgProfile;
    private TextView txtName, txtWebsite;
    private Toolbar toolbar;
    private FloatingActionButton fab;
    private IeMainPresenter ieMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: Main Activity");
        if (savedInstanceState == null) {
            navigationView.setCheckedItem(R.id.nav_home);
            handleSwitchFragmentTo(Constants.TAG_HOME);
        }
    }

    @Override
    public void initView() {
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        fab = (FloatingActionButton) findViewById(R.id.fab);

        // Navigation view header
        navHeader = navigationView.getHeaderView(0);
        txtName = (TextView) navHeader.findViewById(R.id.name);
        txtWebsite = (TextView) navHeader.findViewById(R.id.website);
        imgNavHeaderBg = (ImageView) navHeader.findViewById(R.id.img_header_bg);
        imgProfile = (ImageView) navHeader.findViewById(R.id.img_profile);

        // initializing navigation menu
        setUpDrawerToggle();

        ieMainPresenter = new MainPresenter(this);
    }

    @Override
    public void initData() {
        // load nav menu header data
        loadNavHeader();
    }

    @Override
    public void listenerOnClickEvent() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //Setting Navigation View Item Selected Listener
        // to handle the item click of the navigation menu
        navigationView.setNavigationItemSelectedListener(new NavigationView
                .OnNavigationItemSelectedListener() {
            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                //Check to see which item was being clicked and perform appropriate action.
                if (menuItem.isChecked()) {
                    closeDrawerLayout();
                } else {
                    ieMainPresenter.showFragmentOrActivityById(menuItem.getItemId());
                }
                return true;
            }
        });
    }

    @Override
    public void onEnter() {
        Log.d(TAG, "onEnter: Main Activity");
    }

    /***
     * Load navigation menu header information
     * like background image, profile image
     * name, website, notifications action view (dot)
     */
    private void loadNavHeader() {
        // name, website
        txtName.setText("Ravi Tamada");
        txtWebsite.setText("www.androidhive.info");

        // loading header background image
        Glide.with(this).load(Constants.URL_NAV_HEADER_BG)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imgNavHeaderBg);

        // Loading profile image
        Glide.with(this).load(Constants.URL_PROFILE_IMG)
                .crossFade()
                .thumbnail(0.5f)
                .bitmapTransform(new CircleTransform(this))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imgProfile);

        // showing dot next to notifications label
        navigationView.getMenu().getItem(3).setActionView(R.layout.menu_dot);
    }

    @Override
    public void setToolbarTitle(String toolbarTitle) {
        super.setToolbarTitle(toolbarTitle);
        getSupportActionBar().setTitle(toolbarTitle);
    }

    private void setUpDrawerToggle() {
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.openDrawer, R.string.closeDrawer) {
            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want
                // anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }
            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont
                // want anything to happen so we leave this blank
                super.onDrawerOpened(drawerView);
            }
        };
        //Setting the actionbarToggle to drawer layout
        drawer.setDrawerListener(actionBarDrawerToggle);
        //calling sync state is necessary or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawers();
            return;
        }
        if (!isHomeFragment) {
            navigationView.setCheckedItem(R.id.nav_home);
            showToggleButton();
            handleSwitchFragmentTo(Constants.TAG_HOME);
            return;
        }

        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        Log.d(TAG, "onCreateOptionsMenu: current tag = " + CURRENT_TAG);
        // show menu only when home fragment is selected
        if (CURRENT_TAG.equals(Constants.TAG_HOME)) {
            getMenuInflater().inflate(R.menu.main, menu);
        }
        // when fragment is notifications, load the menu created for notifications
        if (CURRENT_TAG.equals(Constants.TAG_NOTIFICATIONS)) {
            getMenuInflater().inflate(R.menu.notifications, menu);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            Toast.makeText(getApplicationContext(), "Logout user!", Toast.LENGTH_LONG).show();
            return true;
        }

        // user is in notifications fragment
        // and selected 'Mark all as Read'
        if (id == R.id.action_mark_all_read) {
            Toast.makeText(getApplicationContext(),
                    "All notifications marked as read!", Toast.LENGTH_LONG).show();
        }

        // user is in notifications fragment
        // and selected 'Clear All'
        if (id == R.id.action_clear_notifications) {
            Toast.makeText(getApplicationContext(),
                    "Clear all notifications!", Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showHomeFragment(String tagHome) {
        handleSwitchFragmentTo(tagHome);
    }

    @Override
    public void showPhotosFragment(String tagPhotos) {
        handleSwitchFragmentTo(tagPhotos);
    }

    @Override
    public void showMoviesFragment(String tagMovies) {
        handleSwitchFragmentTo(tagMovies);
    }

    @Override
    public void showNotificationsFragment(String tagNotifications) {
        handleSwitchFragmentTo(tagNotifications);
    }

    @Override
    public void showSettingsFragment(String tagSettings) {
        handleSwitchFragmentTo(tagSettings);
    }

    @Override
    public void switchToAboutActivity() {
        // launch new intent instead of loading fragment
        NavigateActivityUtils.handleSwitchToAboutScreen(this);
    }

    @Override
    public void switchToPrivacyActivity() {
        // launch new intent instead of loading fragment
        NavigateActivityUtils.handleSwitchToPrivacyScreen(this);
    }

    @Override
    public void showToggleButton() {
        if (fab != null) {
            fab.show();
        }
    }

    @Override
    public void hideToggleButton() {
        if (fab != null) {
            fab.hide();
        }
    }

    @Override
    public void closeDrawerLayout() {
        if (drawer != null) {
            drawer.closeDrawers();
        }
    }
}
