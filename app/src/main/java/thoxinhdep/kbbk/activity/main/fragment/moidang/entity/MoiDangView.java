package thoxinhdep.kbbk.activity.main.fragment.moidang.entity;

/**
 * Created by ThoXinhDep on 9/28/2017.
 */

public class MoiDangView {
    private String title;
    private String link;
    private String imgUrl;

    public MoiDangView() {
    }

    public MoiDangView(String title, String link, String imgUrl) {
        this.title = title;
        this.link = link;
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
