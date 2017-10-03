package thoxinhdep.kbbk.activity.main.fragment.tieudiem.view;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
import thoxinhdep.navigationdrawer.databinding.FragmentTieudiemBinding;

public class TieuDiemFragment extends BaseFragment
        implements IeTieuDiemFragment, SearchView.OnQueryTextListener{
    private static final String TAG = TieuDiemFragment.class.getSimpleName();
    private IeTieuDiemPresenter ieTieuDiemPresenter;
    private CustomTieuDiemAdapter layoutAdapter;
    private FragmentTieudiemBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return binding.getRoot();
    }

    @Override
    public void bindingLayout(LayoutInflater inflater, ViewGroup container) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_tieudiem, container, false);
    }

    @Override
    public void initAllView() {
        binding.avLoadingIndicate.show();
        ieTieuDiemPresenter = new TieuDiemPresenter(this);
        layoutAdapter = new CustomTieuDiemAdapter();
        binding.setAdapter(layoutAdapter);
        setHasOptionsMenu(true);
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

    @Override
    public void onSuccessGetTieuDiemData(ArrayList<TieuDiemView> listTieuDiem) {
        if (listTieuDiem.size() > 0) {
            layoutAdapter.setTieuDiemList(listTieuDiem);
            binding.avLoadingIndicate.hide();
        }
    }

    @Override
    public void onErrorGetTieuDiemData() {
        Log.d(TAG, "onErrorGetTieuDiemData: get link error");
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        Log.d(TAG, "onCreateOptionsMenu: called");
        getActivity().getMenuInflater().inflate(R.menu.search_main, menu);
        MenuItem item = menu.findItem(R.id.searchMain);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(this);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        Log.d(TAG, "onQueryTextSubmit: called");
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Log.d(TAG, "onQueryTextChange: called");
        layoutAdapter.getFilter().filter(newText);
        return false;
    }
}
