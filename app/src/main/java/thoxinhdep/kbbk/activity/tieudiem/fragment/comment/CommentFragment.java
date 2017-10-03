package thoxinhdep.kbbk.activity.tieudiem.fragment.comment;

import android.os.Bundle;
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
public class CommentFragment extends BaseTieuDiemFragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    private static final String TAG = CommentFragment.class.getSimpleName();

    @BindView(R.id.tvTitle)
    TextView tvTitle;

    private int mPage;

    public static CommentFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        CommentFragment fragment = new CommentFragment();
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
        View view = inflater.inflate(R.layout.fragment_comment, container, false);
        ButterKnife.bind(this,view);
        super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }

    @Override
    public void bindingLayout(LayoutInflater inflater, ViewGroup container) {

    }

    @Override
    public void initAllView() {
    }

    @Override
    public void initAllData() {
        tvTitle.setText("Fragment Comment");
    }

    @Override
    public void listenerOnEventClick() {

    }

    @Override
    public void onLoadComment(String url) {
        super.onLoadComment(url);
        Log.d(TAG, "onLoadListChapter: url = " + url);
    }
}