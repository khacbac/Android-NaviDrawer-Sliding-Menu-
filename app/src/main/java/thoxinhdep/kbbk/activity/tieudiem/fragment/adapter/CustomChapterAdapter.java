package thoxinhdep.kbbk.activity.tieudiem.fragment.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

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
    public void onBindViewHolder(final MyViewHolder holder,
                                 @SuppressLint("RecyclerView") final int position) {
        final ChapterView chapterView = listChapter.get(position);
        holder.layoutView.setTxtTitle(chapterView.getChapterTitle());
        holder.layoutView.setTxtNgayDang(chapterView.getNgayDang());
        holder.layoutView.setAlpha(0.5f);
        holder.layoutView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: link = " + chapterView.getLink());
                // Change alpha to know item selecting.
                holder.layoutView.setAlpha(1f);
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

    public void sortTangDan() {
        Collections.sort(listChapter, new Comparator<ChapterView>() {
            @Override
            public int compare(ChapterView arg0, ChapterView arg1) {
                @SuppressLint("SimpleDateFormat")
                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                int compareResult;
                try {
                    Date arg0Date = format.parse(arg0.getNgayDang());
                    Date arg1Date = format.parse(arg1.getNgayDang());
                    compareResult = arg0Date.compareTo(arg1Date);
                } catch (ParseException e) {
                    e.printStackTrace();
                    compareResult = arg0.getNgayDang().compareTo(arg1.getNgayDang());
                }
                return compareResult;
            }
        });
        notifyDataSetChanged();
    }

    public void sortGiamDan() {
        Collections.sort(listChapter, new Comparator<ChapterView>() {
            @Override
            public int compare(ChapterView arg0, ChapterView arg1) {
                @SuppressLint("SimpleDateFormat")
                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                int compareResult;
                try {
                    Date arg0Date = format.parse(arg0.getNgayDang());
                    Date arg1Date = format.parse(arg1.getNgayDang());
                    compareResult = arg1Date.compareTo(arg0Date);
                } catch (ParseException e) {
                    e.printStackTrace();
                    compareResult = arg1.getNgayDang().compareTo(arg0.getNgayDang());
                }
                return compareResult;
            }
        });
        notifyDataSetChanged();
    }
}
