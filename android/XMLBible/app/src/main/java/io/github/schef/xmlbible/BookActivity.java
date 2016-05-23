package io.github.schef.xmlbible;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.github.schef.xmlbible.Book.Book;
import io.github.schef.xmlbible.Book.Chapter;

/**
 * Created by schef on 5/23/16.
 */
public class BookActivity extends Activity {

    ListView listView;
    List<Chapter> chapters = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list);

        Bundle bundle = getIntent().getExtras();
        ArrayList<Chapter> chapters = bundle.getParcelable("book");
            ArrayAdapter<Chapter> adapter = new ArrayAdapter<Chapter>(this,R.layout.list_item, chapters);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    //Book item = employees.get(position);
                    //Toast.makeText(BookActivity.this,"You selected : " + item.toString(), Toast.LENGTH_SHORT).show();
                    System.out.println("");
                }
            });
    }

}
