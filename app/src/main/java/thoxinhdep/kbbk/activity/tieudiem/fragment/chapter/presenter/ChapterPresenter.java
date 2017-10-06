package thoxinhdep.kbbk.activity.tieudiem.fragment.chapter.presenter;

import java.util.ArrayList;

import thoxinhdep.kbbk.activity.tieudiem.fragment.chapter.entity.ChapterView;
import thoxinhdep.kbbk.activity.tieudiem.fragment.chapter.model.ChapterModel;
import thoxinhdep.kbbk.activity.tieudiem.fragment.chapter.model.IeChapterModel;
import thoxinhdep.kbbk.activity.tieudiem.fragment.chapter.view.IeChapterFragment;

/**
 * Created by ThoXinhDep on 9/28/2017.
 */

public class ChapterPresenter implements IeChapterPresenter, IeChapterModel.IeOnFisnishLoadAllChapter {

    private IeChapterFragment ieChapterFragment;
    private IeChapterModel ieChapterModel;

    public ChapterPresenter(IeChapterFragment ieChapterFragment) {
        this.ieChapterFragment = ieChapterFragment;
        ieChapterModel = new ChapterModel();
    }

    @Override
    public void loadAllChapter(String urlGet, String urlId) {
        ieChapterModel.loadAllChapter(urlGet, this, urlId);
    }

    @Override
    public void onSuccessLoadAllChapter(ArrayList<ChapterView> listChapter) {
        ieChapterFragment.onSuccessLoadAllChapter(listChapter);
    }

    @Override
    public void onErrorLoadALlChapter() {
        ieChapterFragment.onErrorLoadAllChapter();
    }
}
