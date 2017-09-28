package thoxinhdep.kbbk.activity.tieudiem.fragment.chapter.entity;

/**
 * Created by VST on 9/28/2017.
 */

public class ChapterView {
    private String chapterTitle;
    private String ngayDang;
    private String link;

    public ChapterView() {
    }

    public ChapterView(String chapterTitle, String ngayDang, String link) {
        this.chapterTitle = chapterTitle;
        this.ngayDang = ngayDang;
        this.link = link;
    }

    public String getChapterTitle() {
        return chapterTitle;
    }

    public ChapterView setChapterTitle(String chapterTitle) {
        this.chapterTitle = chapterTitle;
        return this;
    }

    public String getNgayDang() {
        return ngayDang;
    }

    public ChapterView setNgayDang(String ngayDang) {
        this.ngayDang = ngayDang;
        return this;
    }

    public String getLink() {
        return link;
    }

    public ChapterView setLink(String link) {
        this.link = link;
        return this;
    }
}
