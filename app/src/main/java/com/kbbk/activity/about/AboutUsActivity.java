package com.kbbk.activity.about;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.kbbk.base.BaseActivity;

import info.androidhive.navigationdrawer.R;

public class AboutUsActivity extends BaseActivity {

    private static final String TAG = AboutUsActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: About Us Activity");
        setContentView(R.layout.activity_about_us);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

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
}
