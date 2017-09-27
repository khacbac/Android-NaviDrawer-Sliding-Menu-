package thoxinhdep.kbbk.activity.main.model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import thoxinhdep.kbbk.constant.Constants;

import thoxinhdep.kbbk.helper.ApiUtils;
import thoxinhdep.navigationdrawer.R;

/**
 * Created by ThoXinhDep on 9/27/2017.
 *
 */

public class MainModel implements IeMainModel {

//    private FragmentController fragmentController = FragmentController.getInstance();

    @Override
    public void showFragmentOrActivityById(int itemId, IeFinishSwitchScreen finishSwitchScreen) {
        switch (itemId) {
            //Replacing the main content with ContentFragment Which is our Inbox View;
            case R.id.nav_tieudiem:
                finishSwitchScreen.finishShowFragmentByTag(Constants.TAG_TIEUDIEM);
                break;
            case R.id.nav_moidang:
                finishSwitchScreen.finishShowFragmentByTag(Constants.TAG_MOIDANG);
                break;
            case R.id.nav_docnhieunhat:
                finishSwitchScreen.finishShowFragmentByTag(Constants.TAG_DOCNHIEUNHAT);
                break;
            case R.id.nav_ngaunhiem:
                finishSwitchScreen.finishShowFragmentByTag(Constants.TAG_NGAUNHIEN);
                break;
            case R.id.nav_notifications:
                finishSwitchScreen.finishShowFragmentByTag(Constants.TAG_NOTIFICATION);
                break;
            case R.id.nav_theloaitruyen:
                finishSwitchScreen.finishShowFragmentByTag(Constants.TAG_THELOAITRUYEN);
                break;
            case R.id.nav_about_us:
                finishSwitchScreen.finishSwitchToAboutActivity();
                break;
            case R.id.nav_privacy_policy:
                finishSwitchScreen.finishSwitchToPrivacyActivity();
                break;
            default:
                finishSwitchScreen.finishShowFragmentByTag(Constants.TAG_TIEUDIEM);
                break;
        }
    }

}
