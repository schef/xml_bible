package io.github.schef.xmlbible.ShowBibles;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.cert.CertificateException;

import io.github.schef.xmlbible.Library.Bible;
import io.github.schef.xmlbible.Library.Library;
import io.github.schef.xmlbible.Fragments.LibraryFragment;
import io.github.schef.xmlbible.Fragments.SmartFragmentStatePagerAdapter;
import io.github.schef.xmlbible.R;

public class ShowBibleActivity extends AppCompatActivity {

    private SmartFragmentStatePagerAdapter adapterViewPager;
    int bibleSelected = 0;

    public int getBibleSelected() {
        return bibleSelected;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_pager);

        if (Library.getInstance() != null) {
            try {
                Library.getInstance().init("MyLibrary");

                //add bibles
                XMLPullParserHandler parser = new XMLPullParserHandler();
                Bible Kjv = Library.getInstance().addBible(parser.parse(getAssets().open("kjv.xml")));

                parser = new XMLPullParserHandler();
                Bible Employees = Library.getInstance().addBible(parser.parse(getAssets().open("employees.xml")));

                parser = null;

                ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
                vpPager.setClipToPadding(false);
                //vpPager.setPageMargin(12);
                vpPager.setOffscreenPageLimit(3);
                adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
                vpPager.setAdapter(adapterViewPager);

                // Attach the page change listener inside the activity
                vpPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

                    // This method will be invoked when a new page becomes selected.
                    @Override
                    public void onPageSelected(int position) {
                        //Toast.makeText(ShowBibleActivity.this, "Selected page position: " + position, Toast.LENGTH_SHORT).show();
                        bibleSelected = position;
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
        }

    }


    // Extend from SmartFragmentStatePagerAdapter now instead for more dynamic ViewPager items
    public class MyPagerAdapter extends SmartFragmentStatePagerAdapter {
        //private static int NUM_ITEMS = 6;
        private int NUM_ITEMS = Library.getInstance().getSize();

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
            return LibraryFragment.newInstance(position);
        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            return Library.getInstance().getBible(position).toString();
        }

        @Override
        public float getPageWidth(int position) {
            return 0.93f;
        }

    }


}
