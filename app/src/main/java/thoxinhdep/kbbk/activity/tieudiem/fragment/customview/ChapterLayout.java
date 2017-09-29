package thoxinhdep.kbbk.activity.tieudiem.fragment.customview;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import thoxinhdep.navigationdrawer.R;

/**
 * Created by VST on 9/28/2017.
 */

public class ChapterLayout extends LinearLayout {

    private static final String TAG = ChapterLayout.class.getSimpleName();
    @BindView(R.id.txtTitle)
    TextView txtTitle;
    @BindView(R.id.txtNgayDang)
    TextView txtNgayDang;

    public ChapterLayout(Context context) {
        super(context);
        initData(context);
    }

    public ChapterLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initData(context);
    }

    public ChapterLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initData(context);
    }

    private void initData(Context context) {
        setOrientation(HORIZONTAL);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            setBackground(getResources().getDrawable(R.drawable.bg_single_layout));
        }
        inflate(context, R.layout.chapter_custom_layout, this);
        ButterKnife.bind(this);
    }

    public void setTxtTitle(String title) {
        txtTitle.setText(title);
    }

    public void setTxtNgayDang(String ngayDang) {
        txtNgayDang.setText(ngayDang);
    }
}
