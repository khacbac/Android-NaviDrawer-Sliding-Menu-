package thoxinhdep.kbbk.activity.main.view;

/**
 * Created by ThoXinhDep on 9/27/2017.
 *
 */

public interface IeMainActivity {
    void showHomeFragment(String tagHome);
    void showMoviesFragment(String tagMovies);
    void showNotificationsFragment(String tagNotifications);
    void showPhotosFragment(String tagPhotos);
    void showSettingsFragment(String tagSettings);
    void switchToAboutActivity();
    void switchToPrivacyActivity();

    void showToggleButton();
    void hideToggleButton();
    void closeDrawerLayout();
}
