package thoxinhdep.kbbk.activity.main.fragment.tieudiem.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import thoxinhdep.kbbk.base.BaseFragment;
import thoxinhdep.kbbk.activity.main.fragment.tieudiem.adapter.CustomTieuDiemAdapter;
import thoxinhdep.kbbk.constant.Constants;
import thoxinhdep.kbbk.activity.main.fragment.tieudiem.entity.TieuDiemView;
import thoxinhdep.kbbk.activity.main.fragment.tieudiem.presenter.IeTieuDiemPresenter;
import thoxinhdep.kbbk.activity.main.fragment.tieudiem.presenter.TieuDiemPresenter;
import thoxinhdep.navigationdrawer.R;

public class TieuDiemFragment extends BaseFragment implements IeTieuDiemFragment{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG = TieuDiemFragment.class.getSimpleName();

    private String ConstructType = Constants.TAG_TIEUDIEM;
    private IeTieuDiemPresenter ieTieuDiemPresenter;
    private ArrayList<TieuDiemView> listTieuDiem = new ArrayList<>();
    private CustomTieuDiemAdapter layoutAdapter;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.avLoadingIndicate)
    AVLoadingIndicatorView loadingIndicatorView;

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
        View view = inflater.inflate(R.layout.fragment_tieudiem, container, false);
        ButterKnife.bind(this,view);
        super.onCreateView(inflater, container, savedInstanceState);
//        imgIconHome.setImageDrawable(getResources().getDrawable(R.drawable.images_luffy));
//
//        // Allow zoom in,zoom out image view.
//        PhotoViewAttacher photoViewAttacher = new PhotoViewAttacher(imgIconHome);
//        photoViewAttacher.update();

        return view;
    }

    @Override
    public void initAllView() {
        loadingIndicatorView.show();

        ieTieuDiemPresenter = new TieuDiemPresenter(this);
        layoutAdapter = new CustomTieuDiemAdapter(listTieuDiem, getActivity());
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(layoutAdapter);
    }

    @Override
    public void initAllData() {
        ieTieuDiemPresenter.getAllDataForTieuDiem();
    }

    @Override
    public void listenerOnEventClick() {
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
    public void onSuccessGetTieuDiemData(ArrayList<TieuDiemView> listTieuDiem) {
        if (listTieuDiem.size() > 0) {
            layoutAdapter.setTieuDiemList(listTieuDiem);
            loadingIndicatorView.hide();
        }
    }

    @Override
    public void onErrorGetTieuDiemData() {
        Log.d(TAG, "onErrorGetTieuDiemData: get link error");
    }

}
