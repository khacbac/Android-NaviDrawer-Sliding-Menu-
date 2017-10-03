package thoxinhdep.kbbk.activity.doctruyen.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Toast;

import com.lsjwzh.widget.recyclerviewpager.RecyclerViewPager;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import thoxinhdep.kbbk.activity.doctruyen.adapter.CustomDocAdapter;
import thoxinhdep.kbbk.activity.doctruyen.entity.DocView;
import thoxinhdep.kbbk.activity.doctruyen.presenter.DocTruyenPresenter;
import thoxinhdep.kbbk.activity.doctruyen.presenter.IeDocTruyenPresenter;
import thoxinhdep.kbbk.base.BaseActivity;
import thoxinhdep.kbbk.constant.Constants;
import thoxinhdep.navigationdrawer.R;

/**
 * Created by VST on 9/28/2017.
 */

public class DocTruyenActivity extends BaseActivity implements IeDocTruyenActivity{

    private static final String TAG = DocTruyenActivity.class.getSimpleName();

    private CustomDocAdapter layoutAdapter;
    private IeDocTruyenPresenter docTruyenPresenter;

    @BindView(R.id.recyclerView)
    RecyclerViewPager recyclerView;
    @BindView(R.id.aviIndicateView)
    AVLoadingIndicatorView aviIndicateView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {
        setContentView(R.layout.activity_doc);
        ButterKnife.bind(this);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        docTruyenPresenter = new DocTruyenPresenter(this);
        layoutAdapter = new CustomDocAdapter(this);
        RecyclerView.LayoutManager mLayoutManager
                = new GridLayoutManager(this, 1, GridLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(layoutAdapter);
    }

    @Override
    public void initData() {
        String intentUrl = getIntent().getStringExtra(Constants.TAG_DOCSCREEN);
        String urlTail = intentUrl.replaceAll(Constants.URL_HOME,"");
        docTruyenPresenter.loadAllTruyenContent(urlTail);
    }

    @Override
    public void listenerOnClickEvent() {

    }

    @Override
    public void onEnter() {

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

    @Override
    public void onSuccessLoadContnet(ArrayList<DocView> listDocView) {
        if (listDocView.size() > 0) {
            layoutAdapter.setDocViewList(listDocView);
        }
    }

    @Override
    public void onErrorLoadContent() {
        Toast.makeText(this, "Load error,please try again!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideProgressBar() {
        aviIndicateView.hide();
    }

    @Override
    public void showProgressBar() {
        aviIndicateView.show();
    }
}
