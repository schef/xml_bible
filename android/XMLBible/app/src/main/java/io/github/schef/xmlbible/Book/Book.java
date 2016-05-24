package io.github.schef.xmlbible.Book;

import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by schef on 5/23/16.
 */
public class Book{

    String name;
    List<Chapter> chapters;

    public void init(String name){
        this.name = name;
        this.chapters = new ArrayList<Chapter>();
        System.out.println("book added");
    }

    public Chapter addChapter(){
        Chapter chapter = new Chapter();
        chapters.add(chapter);
        return chapter;
    }

    public String getName() {
        return name;
    }

    public List<Chapter> getChapters() {
        return chapters;
    }

    @Override
    public String toString() {
        //return super.toString();
        return this.name;
    }
}
