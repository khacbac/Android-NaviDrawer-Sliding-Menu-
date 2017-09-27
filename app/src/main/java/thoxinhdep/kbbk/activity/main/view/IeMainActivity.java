package thoxinhdep.kbbk.activity.main.view;

import java.util.ArrayList;

/**
 * Created by ThoXinhDep on 9/27/2017.
 *
 */

public interface IeMainActivity {
    void showTieuDiemFragment(String tagTieuDiem);
    void showMoiDangFragment(String tagMoiDang);
    void showNhieuNhatFragment(String tagNhieuNhat);
    void showNgauNhienFragment(String tagNgauNhien);
    void showNotificationsFragment(String tagNotification);
    void showTheLoaiFragment(String tagTheLoai);
    void switchToAboutActivity();
    void switchToPrivacyActivity();

    void showToggleButton();
    void hideToggleButton();
    void closeDrawerLayout();
}
