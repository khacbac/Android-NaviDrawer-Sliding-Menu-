package thoxinhdep.kbbk.fragment.tieudiem.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import thoxinhdep.kbbk.constant.Constants;
import thoxinhdep.kbbk.fragment.tieudiem.presenter.IeTieuDiemPresenter;
import thoxinhdep.kbbk.fragment.tieudiem.presenter.TieuDiemPresenter;
import thoxinhdep.navigationdrawer.R;
import uk.co.senab.photoview.PhotoViewAttacher;

public class TieuDiemFragment extends Fragment implements IeTieuDiemFragment{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG = TieuDiemFragment.class.getSimpleName();

    private String ConstructType = Constants.TAG_TIEUDIEM;
    private IeTieuDiemPresenter ieTieuDiemPresenter;

    @BindView(R.id.imgIconHome)
    ImageView imgIconHome;

    public TieuDiemFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this,view);

        imgIconHome.setImageDrawable(getResources().getDrawable(R.drawable.images_luffy));


        // Allow zoom in,zoom out image view.
        PhotoViewAttacher photoViewAttacher = new PhotoViewAttacher(imgIconHome);
        photoViewAttacher.update();

        ieTieuDiemPresenter = new TieuDiemPresenter(this);
        ieTieuDiemPresenter.getAllFeatureTitle();

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public String getConstructType() {
        return ConstructType;
    }

    public void setConstructType(String constructType) {
        this.ConstructType = constructType;
    }

    @Override
    public void onSuccessGetFeatureTitle(ArrayList<String> links) {
        if (links.size() > 0) {
            for (String title : links) {
                Log.d(TAG, "onSuccessGetFeatureTitle: link = " + title);
            }
        }
    }

    @Override
    public void onErrorGetFeatureTitle() {
        Log.d(TAG, "onErrorGetFeatureTitle: get link error");
    }
}
