package io.github.schef.xmlbible.Fragments;

import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import io.github.schef.xmlbible.Book.Library;
import io.github.schef.xmlbible.R;
import io.github.schef.xmlbible.ShowBibles.BibleAdapter;

/**
 * Created by schef on 5/24/16.
 */

public class LibraryFragment extends ListFragment implements AdapterView.OnItemClickListener {
    // Store instance variables
    private Integer pos;
    private String name;


    public static LibraryFragment newInstance(int position) {
        
        Bundle args = new Bundle();
        args.putInt("position", position);
        LibraryFragment fragment = new LibraryFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        //ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(), R.array.Planets, android.R.layout.simple_list_item_1);
        //ArrayAdapter adapter = new ArrayAdapter(getActivity(), R.layout.list_item, Bible.getInstance().getBook(pos).getChapters());
        BibleAdapter adapter = new BibleAdapter(getActivity(), R.layout.list_item, Library.getInstance().getBible(pos).getBooks());
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getActivity(), "Item: " + position, Toast.LENGTH_SHORT).show();
    }


}
