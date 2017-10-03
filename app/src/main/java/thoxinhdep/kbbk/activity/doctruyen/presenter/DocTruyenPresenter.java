package thoxinhdep.kbbk.activity.doctruyen.presenter;

import java.util.ArrayList;

import thoxinhdep.kbbk.activity.doctruyen.entity.DocView;
import thoxinhdep.kbbk.activity.doctruyen.model.DocTruyenModel;
import thoxinhdep.kbbk.activity.doctruyen.model.IeDocTruyenModel;
import thoxinhdep.kbbk.activity.doctruyen.view.IeDocTruyenActivity;

/**
 * Created by ThoXinhDep on 9/29/2017.
 */

public class DocTruyenPresenter implements IeDocTruyenPresenter, IeDocTruyenModel.IeFinishLoadTruyenContent {

    private IeDocTruyenActivity docTruyenActivity;
    private IeDocTruyenModel docTruyenModel;

    public DocTruyenPresenter(IeDocTruyenActivity docTruyenActivity) {
        this.docTruyenActivity = docTruyenActivity;
        docTruyenModel = new DocTruyenModel();
    }

    @Override
    public void loadAllTruyenContent(String url) {
        docTruyenActivity.showProgressBar();
        docTruyenModel.loadAllTruyenContent(url,this);
    }

    @Override
    public void onSuccessLoadContnet(ArrayList<DocView> listDocView) {
        docTruyenActivity.onSuccessLoadContnet(listDocView);
        docTruyenActivity.hideProgressBar();
    }

    @Override
    public void onErrorLoadContent() {
        docTruyenActivity.onErrorLoadContent();
        docTruyenActivity.hideProgressBar();
    }
}
