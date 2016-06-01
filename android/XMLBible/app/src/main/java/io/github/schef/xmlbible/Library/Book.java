package io.github.schef.xmlbible.Library;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by schef on 5/23/16.
 */
public class Book{

    String name;
    List<Chapter> chapters;

    public Book(String name){
        this.name = name;
        this.chapters = new ArrayList<Chapter>();
    }

    public Chapter addChapter(Chapter chapter){
        Chapter myChapter = chapter;
        chapters.add(chapter);
        return myChapter;
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
