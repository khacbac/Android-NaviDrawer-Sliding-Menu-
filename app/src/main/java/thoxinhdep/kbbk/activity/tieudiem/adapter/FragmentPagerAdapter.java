package thoxinhdep.kbbk.activity.tieudiem.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import thoxinhdep.kbbk.activity.tieudiem.fragment.chapter.view.ChapterFragment;
import thoxinhdep.kbbk.activity.tieudiem.fragment.comment.CommentFragment;
import thoxinhdep.kbbk.activity.tieudiem.fragment.info.InfoFragment;

/**
 * Created by ThoXinhDep on 9/28/2017.
 */

public class FragmentPagerAdapter extends android.support.v4.app.FragmentPagerAdapter {
    private final int PAGE_COUNT = 3;
    private String tabTitles[] = new String[] { "Information", "Chapters", "Comments" };

    public FragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new InfoFragment();
            case 1:
                return new ChapterFragment();
            case 2:
                return new CommentFragment();
            default:
                return new ChapterFragment();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}