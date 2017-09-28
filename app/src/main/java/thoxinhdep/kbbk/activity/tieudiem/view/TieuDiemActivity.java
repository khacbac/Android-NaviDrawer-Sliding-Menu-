package thoxinhdep.kbbk.activity.tieudiem.view;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import thoxinhdep.kbbk.activity.tieudiem.adapter.FragmentPagerAdapter;
import thoxinhdep.kbbk.activity.tieudiem.listener.IeTieuDiemListener;
import thoxinhdep.kbbk.base.BaseActivity;

import thoxinhdep.kbbk.constant.Constants;
import thoxinhdep.navigationdrawer.R;

public class TieuDiemActivity extends BaseActivity {

    private static final String TAG = TieuDiemActivity.class.getSimpleName();

    private IeTieuDiemListener tieuDiemListener;
    private String intentUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {
        Log.d(TAG, "onCreate: About Us Activity");
        setContentView(R.layout.activity_tieudiem);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        intentUrl = getIntent().getStringExtra(Constants.TAG_TIEUDIEM);
        Log.d(TAG, "initView: url from tieu diem = " + intentUrl);

        // Get the ViewPager and set it's PagerAdapter so that it can display items
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()));

        // Give the PagerSlidingTabStrip the ViewPager
        PagerSlidingTabStrip tabsStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        // Attach the view pager to the tab strip
        tabsStrip.setViewPager(viewPager);

        // Display Chapter Fragment First.
        viewPager.setCurrentItem(1);
    }

    @Override
    public void initData() {
        Log.d(TAG, "initData: called");
    }


    @Override
    public void listenerOnClickEvent() {

    }

    @Override
    public void onEnter() {
        Log.d(TAG, "onEnter: About Us Activity");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            // finish the activity
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    // Start load data for every Fragment.
    public void setOnTieuDiemListener(IeTieuDiemListener listener) {
        this.tieuDiemListener = listener;
        tieuDiemListener.onLoadAllListChapter(intentUrl);
    }
}