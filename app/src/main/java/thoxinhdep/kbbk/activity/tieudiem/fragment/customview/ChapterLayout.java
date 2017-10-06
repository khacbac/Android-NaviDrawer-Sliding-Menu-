package thoxinhdep.kbbk.activity.tieudiem.fragment.customview;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import thoxinhdep.kbbk.activity.tieudiem.fragment.chapter.entity.ChapterView;
import thoxinhdep.navigationdrawer.R;
import thoxinhdep.navigationdrawer.databinding.ChapterCustomLayoutBinding;

/**
 * Created by VST on 9/28/2017.
 */

public class ChapterLayout extends LinearLayout {
    private static final String TAG = ChapterLayout.class.getSimpleName();

    private ChapterCustomLayoutBinding binding;

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
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            setBackground(getResources().getDrawable(R.drawable.bg_single_layout));
//        }
        LayoutInflater inflater = LayoutInflater.from(context);
        binding = DataBindingUtil.inflate(inflater, R.layout.chapter_custom_layout, this, true);
    }

    public void bindChapterView(ChapterView view) {
        binding.setChapter(view);
    }

    public ChapterCustomLayoutBinding getBinding() {
        return binding;
    }

    public void updateItemClick() {
        setBackground(getResources().getDrawable(R.drawable.bg_single_layout_test));
    }
}
