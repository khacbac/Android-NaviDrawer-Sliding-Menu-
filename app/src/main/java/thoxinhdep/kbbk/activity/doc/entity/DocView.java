package thoxinhdep.kbbk.activity.doc.entity;

/**
 * Created by VST on 9/28/2017.
 */

public class DocView {
    private String url;

    public DocView(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public DocView setUrl(String url) {
        this.url = url;
        return this;
    }
}
