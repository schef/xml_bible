package io.github.schef.xmlbible.ShowChapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import io.github.schef.xmlbible.Fragments.BibleFragment;
import io.github.schef.xmlbible.Fragments.BookFragment;
import io.github.schef.xmlbible.Fragments.SmartFragmentStatePagerAdapter;
import io.github.schef.xmlbible.Library.Library;
import io.github.schef.xmlbible.R;

public class ShowChapterActivity extends AppCompatActivity {

    private SmartFragmentStatePagerAdapter adapterViewPager;
    int selectedBible;
    int selectedBook;
    int selectedChapter;
    int bible;

    public int getChapterSelected() {
        return selectedChapter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_pager);

        ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);

        int selectedTabIndex = getIntent().getExtras().getInt("position");
        selectedBible = getIntent().getExtras().getInt("bible");
        selectedBook = getIntent().getExtras().getInt("book");
        // Switch to page based on index

        vpPager.setClipToPadding(false);
        //vpPager.setPageMargin(12);
        vpPager.setOffscreenPageLimit(3);
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);
        vpPager.setCurrentItem(selectedTabIndex);

        // Attach the page change listener inside the activity
        vpPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            // This method will be invoked when a new page becomes selected.
            @Override
            public void onPageSelected(int position) {
                //Toast.makeText(ShowBibleActivity.this, "Selected page position: " + position, Toast.LENGTH_SHORT).show();
            }

            // This method will be invoked when the current page is scrolled
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // Code goes here
                selectedChapter = position;
            }

            // Called when the scroll state changes:
            // SCROLL_STATE_IDLE, SCROLL_STATE_DRAGGING, SCROLL_STATE_SETTLING
            @Override
            public void onPageScrollStateChanged(int state) {
                // Code goes here
            }
        });

    }


    // Extend from SmartFragmentStatePagerAdapter now instead for more dynamic ViewPager items
    public class MyPagerAdapter extends SmartFragmentStatePagerAdapter {
        //private static int NUM_ITEMS = 6;
        private int NUM_ITEMS = Library.getInstance().getBible(selectedBible).getBook(selectedBook).getSize();

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            return BookFragment.newInstance(selectedBible, selectedBook, position);
        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            return Library.getInstance().getBible(selectedBible).getBook(selectedBook).getChapter(position).toString();
        }

        @Override
        public float getPageWidth(int position) {
            return 0.93f;
        }

    }

    public void setSelectedTab() {
        // Fetch the selected tab index with default
    }

}
