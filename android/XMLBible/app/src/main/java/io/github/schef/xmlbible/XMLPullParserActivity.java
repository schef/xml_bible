package io.github.schef.xmlbible;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

import io.github.schef.xmlbible.Book.Bible;
import io.github.schef.xmlbible.Book.Book;

/**
 * Created by schef on 5/23/16.
 */
public class XMLPullParserActivity extends Activity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list);

        try {

            XMLPullParserHandler parser = new XMLPullParserHandler();
            Bible.getInstance().init("KJV");
            Bible.getInstance().setBooks(parser.parse(getAssets().open("employees.xml")));
            ArrayAdapter<Book> adapter = new ArrayAdapter<Book>(this,R.layout.list_item, Bible.getInstance().getBooks());
            listView.setAdapter(adapter);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
