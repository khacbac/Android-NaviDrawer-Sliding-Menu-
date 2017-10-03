package thoxinhdep.kbbk.activity.main.fragment.tieudiem.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import java.util.ArrayList;
import thoxinhdep.kbbk.activity.main.fragment.tieudiem.entity.TieuDiemView;
import thoxinhdep.navigationdrawer.R;
import thoxinhdep.navigationdrawer.databinding.LayoutTieudiemAdapterBinding;

/**
 * Created by ThoXinhDep on 9/28/2017.
 */

public class CustomTieuDiemAdapter extends RecyclerView.Adapter<CustomTieuDiemAdapter.MyViewHolder> implements Filterable {

    private static final String TAG = CustomTieuDiemAdapter.class.getSimpleName();
    private ArrayList<TieuDiemView> listTieuDiem = new ArrayList<>();
    private ArrayList<TieuDiemView> listFilter = new ArrayList<>();

    public CustomTieuDiemAdapter() {
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.layout_tieudiem_adapter,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder,
                                 @SuppressLint("RecyclerView") final int position) {
        final TieuDiemView tieuDiemView = listTieuDiem.get(position);
        holder.binding.setTieudiemview(tieuDiemView);
        Log.d(TAG, "onBindViewHolder: url = " + tieuDiemView.getAvatarUrl());

    }

    @Override
    public int getItemCount() {
        return listTieuDiem.size();
    }

    @Override
    public Filter getFilter() {
        return new filter();
    }

    private class filter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            if (constraint != null && constraint.length() > 0) {
                ArrayList<TieuDiemView> filterList = new ArrayList<>();
                for (int i = 0; i < listFilter.size(); i++) {
                    if ((listFilter.get(i).getTxtTitle().toUpperCase())
                            .contains(constraint.toString().toUpperCase())) {
                        TieuDiemView viewFilter = new TieuDiemView();
                        viewFilter.setTxtTitle(listFilter.get(i).getTxtTitle());
                        viewFilter.setAvatarUrl(listFilter.get(i).getAvatarUrl());
                        viewFilter.setTxtUrlId(listFilter.get(i).getTxtUrlId());
                        filterList.add(viewFilter);
                    }
                }
                results.count = filterList.size();
                results.values = filterList;
            } else {
                results.count = listFilter.size();
                results.values = listFilter;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            listTieuDiem = (ArrayList<TieuDiemView>) results.values;
            notifyDataSetChanged();
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private LayoutTieudiemAdapterBinding binding;

        MyViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }

    public void setTieuDiemList(ArrayList<TieuDiemView> listTieuDiem) {
        this.listTieuDiem = listTieuDiem;
        listFilter = listTieuDiem;
        notifyDataSetChanged();
    }

}
