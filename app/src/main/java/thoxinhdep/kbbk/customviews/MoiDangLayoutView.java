package thoxinhdep.kbbk.customviews;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import butterknife.BindView;
import butterknife.ButterKnife;
import thoxinhdep.navigationdrawer.R;

/**
 * Created by ThoXinhDep on 9/28/2017.
 */

public class MoiDangLayoutView extends RelativeLayout {

    @BindView(R.id.txtTitle)
    TextView txtTitle;
    @BindView(R.id.imageAvatar)
    ImageView imageAvatar;

    public MoiDangLayoutView(Context context) {
        super(context);
        init(context);
    }

    public MoiDangLayoutView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MoiDangLayoutView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        View rootView = inflate(context, R.layout.layout_moidang_view,this);
        rootView.setPadding(10,10,10,10);
        ButterKnife.bind(this);
    }

    public void setImageAvatarDrawable(Drawable drawable) {
        imageAvatar.setImageDrawable(drawable);
    }

    public void setImageAvatarUrl(Context context,String imageUrl) {
        // Loading profile image
        Glide.with(context).load(imageUrl)
                .crossFade()
                .thumbnail(0.5f)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageAvatar);
    }

    public void setTitle(String title) {
        txtTitle.setText(title);
    }

}