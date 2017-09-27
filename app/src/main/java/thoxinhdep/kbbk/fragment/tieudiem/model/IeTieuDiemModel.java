package thoxinhdep.kbbk.fragment.tieudiem.model;

import java.util.ArrayList;

/**
 * Created by VST on 9/27/2017.
 */

public interface IeTieuDiemModel {

    interface IeFinisGetFeatureLink {
        void onSuccessGetFeatureTitle(ArrayList<String> links);
        void onErrorGetFeatureTitle();
    }

    void getAllFeatureTitle(IeFinisGetFeatureLink finisGetFeatureLink);
}
