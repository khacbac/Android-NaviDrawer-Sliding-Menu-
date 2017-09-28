package thoxinhdep.kbbk.activity.main.fragment.tieudiem.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import thoxinhdep.kbbk.activity.main.fragment.tieudiem.entity.TieuDiemView;
import thoxinhdep.kbbk.customviews.TieuDiemLayoutView;
import thoxinhdep.kbbk.untils.NavigateActivityUtils;
import thoxinhdep.navigationdrawer.R;

/**
 * Created by ThoXinhDep on 9/28/2017.
 */

public class CustomTieuDiemAdapter extends RecyclerView.Adapter<CustomTieuDiemAdapter.MyViewHolder> {

    private static final String TAG = CustomTieuDiemAdapter.class.getSimpleName();
    private ArrayList<TieuDiemView> listTieuDiem;
    private Context context;

    public CustomTieuDiemAdapter(ArrayList<TieuDiemView> listTieuDiem) {
        this.listTieuDiem = listTieuDiem;
    }

    public CustomTieuDiemAdapter(ArrayList<TieuDiemView> listTieuDiem, Context context) {
        this.listTieuDiem = listTieuDiem;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.layout_tieudiem_adapter,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder,
                                 @SuppressLint("RecyclerView") final int position) {
        final TieuDiemView tieuDiemView = listTieuDiem.get(position);
        holder.layoutView.setTitle(tieuDiemView.getTxtTitle());
        holder.layoutView.setImageAvatarUrl(context,tieuDiemView.getAvatarUrl());
        Log.d(TAG, "onBindViewHolder: url = " + tieuDiemView.getAvatarUrl());

        holder.layoutView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavigateActivityUtils.handleSwitchToAboutScreen(
                        (Activity) context, tieuDiemView.getTxtLink());
            }
        });
    }

    @Override
    public int getItemCount() {
        return listTieuDiem.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TieuDiemLayoutView layoutView;

        MyViewHolder(View itemView) {
            super(itemView);
            layoutView = (TieuDiemLayoutView) itemView.findViewById(R.id.linearLayoutView);
        }
    }

    public void setTieuDiemList(ArrayList<TieuDiemView> listTieuDiem) {
        this.listTieuDiem = listTieuDiem;
        notifyDataSetChanged();
    }

}
