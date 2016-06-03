package io.github.schef.xmlbible.Library;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by schef on 5/23/16.
 */
public class Chapter {

    Integer num;
    List<Verse> verses;

    public Chapter(Integer num){
        this.num = num;
        this.verses = new ArrayList<Verse>();
    }

    public void addVerse(Verse verse){
        verses.add(verse);
    }

    public List<Verse> getVerses() {
        return verses;
    }

    @Override
    public String toString() {
        //return super.toString();
        return String.valueOf(num);
    }

    public Verse getVerse(int pos){
        return verses.get(pos);
    }
}
