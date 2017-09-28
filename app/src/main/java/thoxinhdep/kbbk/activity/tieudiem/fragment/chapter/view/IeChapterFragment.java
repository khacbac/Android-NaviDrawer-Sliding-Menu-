package thoxinhdep.kbbk.activity.tieudiem.fragment.chapter.view;

import java.util.ArrayList;

import thoxinhdep.kbbk.activity.tieudiem.fragment.chapter.entity.ChapterView;

/**
 * Created by ThoXinhDep on 9/28/2017.
 */

public interface IeChapterFragment {
    void onSuccessLoadAllChapter(ArrayList<ChapterView> listChapter);
    void onErrorLoadAllChapter();
}
