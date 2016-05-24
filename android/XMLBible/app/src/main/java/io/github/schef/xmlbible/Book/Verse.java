package io.github.schef.xmlbible.Book;

/**
 * Created by schef on 5/23/16.
 */
public class Verse {

    Integer num;
    String verse;

    public void init(Integer num, String verse){
        this.num = num;
        this.verse = verse;
        System.out.println("verse added");
    }

    @Override
    public String toString() {
        //return super.toString();
        return verse;
    }
}
