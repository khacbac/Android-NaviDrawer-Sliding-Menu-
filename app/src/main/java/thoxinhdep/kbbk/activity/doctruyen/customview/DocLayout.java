package thoxinhdep.kbbk.activity.doctruyen.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.wang.avi.AVLoadingIndicatorView;

import butterknife.BindView;
import butterknife.ButterKnife;
import thoxinhdep.navigationdrawer.R;
import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by VST on 9/28/2017.
 */

public class DocLayout extends RelativeLayout {

    private static final String TAG = DocLayout.class.getSimpleName();
    @BindView(R.id.imageDocView)
    ImageView imageDocView;
    @BindView(R.id.aviIndicateView)
    AVLoadingIndicatorView aviIndicateView;

    private PhotoViewAttacher photoViewAttacher;

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
        aviIndicateView.show();
    }

    public void setImageUrl(String url) {
        // Loading profile image
        Glide.with(getContext())
                .load(url)
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model,
                                               Target<GlideDrawable> target, boolean isFirstResource) {
                        aviIndicateView.show();
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model,
                                                   Target<GlideDrawable> target,
                                                   boolean isFromMemoryCache, boolean isFirstResource) {
                        aviIndicateView.hide();
                        return false;
                    }
                })
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageDocView);
    }
}
