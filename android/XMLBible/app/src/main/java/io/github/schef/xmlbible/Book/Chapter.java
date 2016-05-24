package io.github.schef.xmlbible.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by schef on 5/23/16.
 */
public class Chapter {

    Integer num;
    List<Verse> verses;

    public void init(Integer num){
        this.num = num;
        this.verses = new ArrayList<Verse>();
        System.out.println("chapter added");
    }

    public Verse addVerse(){
        Verse verse = new Verse();
        verses.add(verse);
        return verse;
    }

    public List<Verse> getVerses() {
        return verses;
    }

    @Override
    public String toString() {
        //return super.toString();
        return String.valueOf(num);
    }
}
