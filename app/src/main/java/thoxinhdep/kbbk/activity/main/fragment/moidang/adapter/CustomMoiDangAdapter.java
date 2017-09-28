package thoxinhdep.kbbk.activity.main.fragment.moidang.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import thoxinhdep.kbbk.activity.main.fragment.moidang.entity.MoiDangView;
import thoxinhdep.kbbk.customviews.MoiDangLayoutView;
import thoxinhdep.navigationdrawer.R;

/**
 * Created by ThoXinhDep on 9/28/2017.
 */

public class CustomMoiDangAdapter extends RecyclerView.Adapter<CustomMoiDangAdapter.MyViewHolder>{
    private static final String TAG = CustomMoiDangAdapter.class.getSimpleName();
    private ArrayList<MoiDangView> listMoiDang;
    private Context context;

    public CustomMoiDangAdapter(ArrayList<MoiDangView> listMoiDang) {
        this.listMoiDang = listMoiDang;
    }

    public CustomMoiDangAdapter(ArrayList<MoiDangView> listMoiDang, Context context) {
        this.listMoiDang = listMoiDang;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.layout_moidang_adapter,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        MoiDangView moiDangView = listMoiDang.get(position);
        holder.layoutView.setTitle(moiDangView.getTitle());
        holder.layoutView.setImageAvatarUrl(context,moiDangView.getImgUrl());
    }

    @Override
    public int getItemCount() {
        return listMoiDang.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        MoiDangLayoutView layoutView;

        MyViewHolder(View itemView) {
            super(itemView);
            layoutView = (MoiDangLayoutView) itemView.findViewById(R.id.linearLayoutView);
        }
    }

    public void setMoiDangList(ArrayList<MoiDangView> listMoiDang) {
        this.listMoiDang = listMoiDang;
        notifyDataSetChanged();
    }
}
