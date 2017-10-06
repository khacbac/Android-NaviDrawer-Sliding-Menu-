package thoxinhdep.kbbk.activity.tieudiem.fragment.chapter.model;

import java.util.ArrayList;

import thoxinhdep.kbbk.activity.tieudiem.fragment.chapter.entity.ChapterView;

/**
 * Created by ThoXinhDep on 9/28/2017.
 */

public interface IeChapterModel {

    interface IeOnFisnishLoadAllChapter {
        void onSuccessLoadAllChapter(ArrayList<ChapterView> listChapter);
        void onErrorLoadALlChapter();
    }

    void loadAllChapter(String urlGet, IeOnFisnishLoadAllChapter loadAllChapter, String urlId);
}
