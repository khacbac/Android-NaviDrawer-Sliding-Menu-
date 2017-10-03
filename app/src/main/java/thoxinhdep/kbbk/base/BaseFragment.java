package thoxinhdep.kbbk.base;

import android.database.DatabaseUtils;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import thoxinhdep.navigationdrawer.R;
import thoxinhdep.navigationdrawer.databinding.FragmentLayoutBaseBinding;

/**
 * Created by ThoXinhDep on 9/28/2017.
 */

public abstract class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        FragmentLayoutBaseBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_layout_base, container, false);
        View view = binding.getRoot();
        bindingLayout(inflater, container);
        initAllView();
        initAllData();
        listenerOnEventClick();
        return view;
    }

    public abstract void bindingLayout(LayoutInflater inflater, ViewGroup container);

    public abstract void initAllView();

    public abstract void initAllData();

    public abstract void listenerOnEventClick();
}
