package thoxinhdep.kbbk.activity.main.fragment.moidang.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import thoxinhdep.kbbk.base.BaseFragment;
import thoxinhdep.kbbk.activity.main.fragment.moidang.adapter.CustomMoiDangAdapter;
import thoxinhdep.kbbk.activity.main.fragment.moidang.entity.MoiDangView;
import thoxinhdep.kbbk.activity.main.fragment.moidang.presenter.IeMoiDangPresenter;
import thoxinhdep.kbbk.activity.main.fragment.moidang.presenter.MoiDangPresenter;
import thoxinhdep.navigationdrawer.R;


public class MoiDangFragment extends BaseFragment implements IeMoiDangFragment{

    private static final String TAG = MoiDangFragment.class.getSimpleName();

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private IeMoiDangPresenter ieMoiDangPresenter;
    private ArrayList<MoiDangView> listTieuDiem = new ArrayList<>();
    private CustomMoiDangAdapter layoutAdapter;

    public MoiDangFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_moidang, container, false);
        ButterKnife.bind(this,view);
        super.onCreateView(inflater, container, savedInstanceState);
        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void initAllView() {
        ieMoiDangPresenter = new MoiDangPresenter(this);
        layoutAdapter = new CustomMoiDangAdapter(listTieuDiem, getActivity());
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(
                getActivity(), 3, GridLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(layoutAdapter);
    }

    @Override
    public void initAllData() {
        ieMoiDangPresenter.getAllDataForMoiDangMenu();
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

    @Override
    public void onSuccessGetMoiDangMenu(ArrayList<MoiDangView> listMoiDang) {
        for (MoiDangView view : listMoiDang) {
            Log.d(TAG, "onSuccessGetMoiDangMenu: title = " + view.getTitle());
            Log.d(TAG, "onSuccessGetMoiDangMenu: link = " + view.getLink());
            Log.d(TAG, "onSuccessGetMoiDangMenu: imgUrl = " + view.getImgUrl());
        }
        layoutAdapter.setMoiDangList(listMoiDang);
    }

    @Override
    public void onErrorGetMoiDangMenu() {
        Log.d(TAG, "onErrorGetMoiDangMenu: get data error");
    }
}
