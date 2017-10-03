package thoxinhdep.kbbk.activity.doctruyen.model;

import java.util.ArrayList;

import thoxinhdep.kbbk.activity.doctruyen.entity.DocView;

/**
 * Created by ThoXinhDep on 9/29/2017.
 */

public interface IeDocTruyenModel {
    interface IeFinishLoadTruyenContent {
        void onSuccessLoadContnet(ArrayList<DocView> listDocView);
        void onErrorLoadContent();
    }
    void loadAllTruyenContent(String url, IeFinishLoadTruyenContent finish);
}
