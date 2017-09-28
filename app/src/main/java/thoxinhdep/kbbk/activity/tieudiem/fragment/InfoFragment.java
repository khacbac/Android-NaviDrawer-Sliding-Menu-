package thoxinhdep.kbbk.activity.tieudiem.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import thoxinhdep.kbbk.base.BaseTieuDiemFragment;
import thoxinhdep.navigationdrawer.R;

/**
 * Created by ThoXinhDep on 9/28/2017.
 */

// In this case, the fragment displays simple text based on the page
public class InfoFragment extends BaseTieuDiemFragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    private static final String TAG = InfoFragment.class.getSimpleName();

    @BindView(R.id.tvTitle)
    TextView tvTitle;

    public static InfoFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        InfoFragment fragment = new InfoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        mPage = getArguments().getInt(ARG_PAGE);
    }

    // Inflate the fragment layout we defined above for this fragment
    // Set the associated text for the title
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info, container, false);
        ButterKnife.bind(this,view);
        super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }

    @Override
    public void initAllView() {
    }

    @Override
    public void initAllData() {
        tvTitle.setText("Fragment Info");
    }

    @Override
    public void listenerOnEventClick() {

    }

    @Override
    public void onLoadInfomation(String url) {
        super.onLoadInfomation(url);
        Log.d(TAG, "onLoadListChapter: url = " + url);
    }
}