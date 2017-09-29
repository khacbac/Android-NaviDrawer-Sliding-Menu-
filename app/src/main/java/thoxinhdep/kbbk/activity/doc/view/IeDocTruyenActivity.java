package thoxinhdep.kbbk.activity.doc.view;

import java.util.ArrayList;

import thoxinhdep.kbbk.activity.doc.entity.DocView;

/**
 * Created by ThoXinhDep on 9/29/2017.
 */

public interface IeDocTruyenActivity {
    void onSuccessLoadContnet(ArrayList<DocView> listDocView);
    void onErrorLoadContent();
    void hideProgressBar();
    void showProgressBar();
}
