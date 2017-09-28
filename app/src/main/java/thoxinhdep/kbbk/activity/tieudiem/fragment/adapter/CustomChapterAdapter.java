package thoxinhdep.kbbk.activity.tieudiem.fragment.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import thoxinhdep.kbbk.activity.tieudiem.fragment.chapter.entity.ChapterView;
import thoxinhdep.kbbk.activity.tieudiem.fragment.customview.ChapterLayout;
import thoxinhdep.kbbk.untils.NavigateActivityUtils;
import thoxinhdep.navigationdrawer.R;

/**
 * Created by VST on 9/28/2017.
 */

public class CustomChapterAdapter extends RecyclerView.Adapter<CustomChapterAdapter.MyViewHolder> {

    private static final String TAG = CustomChapterAdapter.class.getSimpleName();
    private ArrayList<ChapterView> listChapter = new ArrayList<>();
    private Context context;

    public CustomChapterAdapter(ArrayList<ChapterView> listChapter) {
        this.listChapter = listChapter;
    }

    public CustomChapterAdapter(Context context) {
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.chapter_layout_adapter,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder,
                                 @SuppressLint("RecyclerView") final int position) {
        final ChapterView chapterView = listChapter.get(position);
        holder.layoutView.setTxtTitle(chapterView.getChapterTitle());
        holder.layoutView.setTxtNgayDang(chapterView.getNgayDang());

        holder.layoutView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: link = " + chapterView.getLink());
                NavigateActivityUtils.handleSwitchToDocScreen(
                        (Activity) context, chapterView.getLink());
            }
        });
    }

    @Override
    public int getItemCount() {
        return listChapter.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        ChapterLayout layoutView;

        MyViewHolder(View itemView) {
            super(itemView);
            layoutView = (ChapterLayout) itemView.findViewById(R.id.chapterLayout);
        }
    }

    public void setChapterList(ArrayList<ChapterView> listChapter) {
        this.listChapter = listChapter;
        notifyDataSetChanged();
    }

}

