package thoxinhdep.kbbk.database;

import java.util.ArrayList;

/**
 * Created by doanLV4 on 10/5/2017.
 */

public class TruyenEntity {
    private String id;
    private String truyenId;
    private String truyenTitle;
    private ArrayList<String> listCLicked;
    private ArrayList<String> imageRead;

    public TruyenEntity() {
    }

    public TruyenEntity(String truyenId, ArrayList<String> listCLicked, ArrayList<String> imageRead) {
        this.truyenId = truyenId;
        this.listCLicked = listCLicked;
        this.imageRead = imageRead;
    }

    public String getTruyenId() {
        return truyenId;
    }

    public void setTruyenId(String truyenId) {
        this.truyenId = truyenId;
    }

    public ArrayList<String> getListCLicked() {
        return listCLicked;
    }

    public void setListCLicked(ArrayList<String> listCLicked) {
        this.listCLicked = listCLicked;
    }

    public ArrayList<String> getImageRead() {
        return imageRead;
    }

    public void setImageRead(ArrayList<String> imageRead) {
        this.imageRead = imageRead;
    }

    public String getTruyenTitle() {
        return truyenTitle;
    }

    public void setTruyenTitle(String truyenTitle) {
        this.truyenTitle = truyenTitle;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
