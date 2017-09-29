package thoxinhdep.kbbk.activity.doc.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import thoxinhdep.kbbk.activity.doc.customview.DocLayout;
import thoxinhdep.kbbk.activity.doc.entity.DocView;
import thoxinhdep.navigationdrawer.R;

/**
 * Created by VST on 9/28/2017.
 */

public class CustomDocAdapter extends RecyclerView.Adapter<CustomDocAdapter.MyViewHolder> {

    private static final String TAG = CustomDocAdapter.class.getSimpleName();
    private ArrayList<DocView> listContent = new ArrayList<>();
    private Context context;

    public CustomDocAdapter(ArrayList<DocView> listContent) {
        this.listContent = listContent;
    }

    public CustomDocAdapter(Context context) {
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.custom_doc_adapter,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder,
                                 @SuppressLint("RecyclerView") final int position) {
        final DocView docView = listContent.get(position);
        holder.layoutView.setImageUrl(docView.getUrl());
    }

    @Override
    public int getItemCount() {
        return listContent.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        DocLayout layoutView;

        MyViewHolder(View itemView) {
            super(itemView);
            layoutView = (DocLayout) itemView.findViewById(R.id.layoutDoc);
        }
    }

    public void setDocViewList(ArrayList<DocView> listContent) {
        this.listContent = listContent;
        notifyDataSetChanged();
    }

}

