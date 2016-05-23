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

import io.github.schef.xmlbible.Book.Book;

/**
 * Created by schef on 5/23/16.
 */
public class XMLPullParserActivity extends Activity {

    ListView listView;
    List<Book> employees = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list);

        try {
            XMLPullParserHandler parser = new XMLPullParserHandler();
            employees = parser.parse(getAssets().open("employees.xml"));
            ArrayAdapter<Book> adapter = new ArrayAdapter<Book>(this,R.layout.list_item, employees);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(XMLPullParserActivity.this, BookActivity.class);
                    intent.putExtra("book", (Parcelable)employees.get(position));
                    startActivity(intent);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
