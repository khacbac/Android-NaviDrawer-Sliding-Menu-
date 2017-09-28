package thoxinhdep.kbbk.activity.doc.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import butterknife.BindView;
import butterknife.ButterKnife;
import thoxinhdep.navigationdrawer.R;
import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by VST on 9/28/2017.
 */

public class DocLayout extends RelativeLayout {

    @BindView(R.id.imageDocView)
    ImageView imageDocView;

    public DocLayout(Context context) {
        super(context);
        initData(context);
    }

    public DocLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initData(context);
    }

    public DocLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initData(context);
    }

    private void initData(Context context) {
        inflate(context, R.layout.custom_doc_layout, this);
        ButterKnife.bind(this);
//        PhotoViewAttacher photoViewAttacher = new PhotoViewAttacher(imageDocView);
//        photoViewAttacher.update();
    }

    public void setImageUrl(String url) {
        // Loading profile image
        Glide.with(getContext()).load(url)
                .crossFade()
                .thumbnail(0.5f)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageDocView);
    }
}
