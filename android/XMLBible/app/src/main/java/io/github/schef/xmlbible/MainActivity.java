package io.github.schef.xmlbible;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.io.IOException;

import io.github.schef.xmlbible.Book.Bible;
import io.github.schef.xmlbible.Fragments.ChaptersFragment;
import io.github.schef.xmlbible.Fragments.SmartFragmentStatePagerAdapter;

public class MainActivity extends AppCompatActivity {

    private SmartFragmentStatePagerAdapter adapterViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_pager);


        try {
            XMLPullParserHandler parser = new XMLPullParserHandler();
            Bible.getInstance().init("KJV");
            //Bible.getInstance().setBooks(parser.parse(getAssets().open("employees.xml")));
            Bible.getInstance().setBooks(parser.parse(getAssets().open("kjv.xml")));
            ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
            vpPager.setClipToPadding(false);
            vpPager.setPageMargin(12);
            vpPager.setOffscreenPageLimit(3);
            adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
            vpPager.setAdapter(adapterViewPager);

            // Attach the page change listener inside the activity
            vpPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

                // This method will be invoked when a new page becomes selected.
                @Override
                public void onPageSelected(int position) {
                    Toast.makeText(MainActivity.this, "Selected page position: " + position, Toast.LENGTH_SHORT).show();
                }

                // This method will be invoked when the current page is scrolled
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                    // Code goes here
                }

                // Called when the scroll state changes:
                // SCROLL_STATE_IDLE, SCROLL_STATE_DRAGGING, SCROLL_STATE_SETTLING
                @Override
                public void onPageScrollStateChanged(int state) {
                    // Code goes here
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        //ArrayAdapter<Book> adapter = new ArrayAdapter<Book>(this,R.layout.list_item, Bible.getInstance().getBooks());

    }


    // Extend from SmartFragmentStatePagerAdapter now instead for more dynamic ViewPager items
    public static class MyPagerAdapter extends SmartFragmentStatePagerAdapter {
        //private static int NUM_ITEMS = 6;
        private static int NUM_ITEMS = Bible.getInstance().getSize();

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
               return ChaptersFragment.newInstance(position);
        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            return Bible.getInstance().getBooks().get(position).toString();
        }

        @Override
        public float getPageWidth(int position) {
            return 0.93f;
        }

    }


}
