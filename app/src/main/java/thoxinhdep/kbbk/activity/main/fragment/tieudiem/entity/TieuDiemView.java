package thoxinhdep.kbbk.activity.main.fragment.tieudiem.entity;

/**
 * Created by ThoXinhDep on 9/28/2017.
 */

public class TieuDiemView {
    private static final String TAG = TieuDiemView.class.getSimpleName();
    private String avatarUrl;
    private String txtTitle;
    private String txtUrlId;

    public TieuDiemView(String avatarUrl, String txtTitle, String txtUrlId) {
        this.avatarUrl = avatarUrl;
        this.txtTitle = txtTitle;
        this.txtUrlId = txtUrlId;
    }

    public TieuDiemView() {
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String url) {
        if (url.isEmpty()) {
            this.avatarUrl = "https://miscmedia-9gag-fun.9cache.com/images/thumbnail-facebook/1481537858.9056_aZAvYJ_220x220.jpg";
        } else {
            this.avatarUrl = url;
        }

    }

    public String getTxtTitle() {
        return txtTitle;
    }

    public void setTxtTitle(String txtTitle) {
        this.txtTitle = txtTitle;
    }

    public String getTxtUrlId() {
        return txtUrlId;
    }

    public void setTxtUrlId(String txtUrlId) {
        this.txtUrlId = txtUrlId;
    }
}
