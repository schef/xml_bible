package io.github.schef.xmlbible.Fragments;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import io.github.schef.xmlbible.Library.Library;
import io.github.schef.xmlbible.R;
import io.github.schef.xmlbible.ShowChapters.ChapterAdapter;

/**
 * Created by schef on 5/24/16.
 */

public class BookFragment extends ListFragment implements AdapterView.OnItemClickListener {
    // Store instance variables
    private Integer bible = 0;
    private Integer book = 0;
    private Integer pos;


    public static BookFragment newInstance(int bible, int book, int position) {
        
        Bundle args = new Bundle();
        args.putInt("bible", bible);
        args.putInt("book", book);
        args.putInt("position", position);
        BookFragment fragment = new BookFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bible = getArguments().getInt("bible", 0);
        book = getArguments().getInt("book", 0);
        pos = getArguments().getInt("position", 0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ChapterAdapter adapter = new ChapterAdapter(getActivity(), R.layout.list_item, Library.getInstance().getBible(bible).getBook(book).getChapter(pos).getVerses());
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Toast.makeText(getActivity(), "Item: " + position, Toast.LENGTH_SHORT).show();
        //Intent intent = new Intent(getActivity(), ShowBooksActivity.class);
        //startActivity(intent);
    }


}
