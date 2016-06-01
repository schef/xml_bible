package io.github.schef.xmlbible.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import io.github.schef.xmlbible.Library.Library;
import io.github.schef.xmlbible.R;
import io.github.schef.xmlbible.ShowBibles.BibleAdapter;
import io.github.schef.xmlbible.ShowBooks.BookAdapter;
import io.github.schef.xmlbible.ShowBooks.ShowBooksActivity;

/**
 * Created by schef on 5/24/16.
 */

public class BibleFragment extends ListFragment implements AdapterView.OnItemClickListener {
    // Store instance variables
    private Integer pos;
    private String name;
    private Integer bible = 0;


    public static BibleFragment newInstance(int bible, int position) {
        
        Bundle args = new Bundle();
        args.putInt("position", position);
        args.putInt("bible", bible);
        BibleFragment fragment = new BibleFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pos = getArguments().getInt("position", 0);
        bible = getArguments().getInt("bible", 0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(), R.array.Planets, android.R.layout.simple_list_item_1);
        //ArrayAdapter adapter = new ArrayAdapter(getActivity(), R.layout.list_item, Bible.getInstance().getBook(pos).getChapters());
        BookAdapter adapter = new BookAdapter(getActivity(), R.layout.list_item, Library.getInstance().getBible(bible).getBook(pos).getChapters());
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Toast.makeText(getActivity(), "Item: " + position, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getActivity(), ShowBooksActivity.class);
        startActivity(intent);
    }


}
