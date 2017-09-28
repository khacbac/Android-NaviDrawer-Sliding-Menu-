package thoxinhdep.kbbk.activity.main.fragment.tieudiem.entity;

/**
 * Created by ThoXinhDep on 9/28/2017.
 */

public class TieuDiemView {
    String avatarUrl;
    String txtTitle;
    String txtLink;

    public TieuDiemView(String avatarUrl, String txtTitle, String txtLink) {
        this.avatarUrl = avatarUrl;
        this.txtTitle = txtTitle;
        this.txtLink = txtLink;
    }

    public TieuDiemView() {
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getTxtTitle() {
        return txtTitle;
    }

    public void setTxtTitle(String txtTitle) {
        this.txtTitle = txtTitle;
    }

    public String getTxtLink() {
        return txtLink;
    }

    public void setTxtLink(String txtLink) {
        this.txtLink = txtLink;
    }
}
