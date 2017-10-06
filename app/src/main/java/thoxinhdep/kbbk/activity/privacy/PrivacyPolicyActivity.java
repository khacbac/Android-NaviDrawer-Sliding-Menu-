package thoxinhdep.kbbk.activity.privacy;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;
import thoxinhdep.kbbk.base.BaseActivity;
import thoxinhdep.kbbk.test.CustomDialog;
import thoxinhdep.navigationdrawer.R;


public class PrivacyPolicyActivity extends BaseActivity {

    private static final String TAG = PrivacyPolicyActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: Privacy Policy Activity");
        setContentView(R.layout.activity_privacy_policy);
        ButterKnife.bind(this);
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
        Log.d(TAG, "onEnter: Privacy Policy Activity");
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

    private void showYesNoDialog() {
        FragmentManager fm = getSupportFragmentManager();
        CustomDialog editNameDialogFragment = CustomDialog.newInstance("Some Title");
        editNameDialogFragment.show(fm, "fragment_edit_name");
    }

    @OnClick(R.id.onBtnShow)
    public void onBtnShowClick(View view) {
//        showYesNoDialog();

    }

}
