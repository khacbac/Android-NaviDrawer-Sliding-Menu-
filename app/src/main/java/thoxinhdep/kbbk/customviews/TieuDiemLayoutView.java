package thoxinhdep.kbbk.customviews;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import butterknife.BindView;
import butterknife.ButterKnife;
import thoxinhdep.kbbk.activity.main.fragment.tieudiem.adapter.CustomTieuDiemAdapter;
import thoxinhdep.kbbk.activity.main.fragment.tieudiem.entity.TieuDiemView;
import thoxinhdep.navigationdrawer.R;
import thoxinhdep.navigationdrawer.databinding.LayoutTieudiemViewBinding;

/**
 * Created by ThoXinhDep on 9/28/2017.
 */

public class TieuDiemLayoutView extends RelativeLayout {

    private LayoutTieudiemViewBinding binding;

    public TieuDiemLayoutView(Context context) {
        super(context);
        init(context);
    }

    public TieuDiemLayoutView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TieuDiemLayoutView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        binding = DataBindingUtil.inflate(inflater, R.layout.layout_tieudiem_view, this, true);
        View view = binding.getRoot();
        view.setPadding(10,10,10,10);
    }

    public void bindDingTieuDiemView(TieuDiemView view) {
        binding.setTieudiemview(view);
    }
}