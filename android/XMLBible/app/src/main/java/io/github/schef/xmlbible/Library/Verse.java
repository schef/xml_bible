package io.github.schef.xmlbible.Library;

/**
 * Created by schef on 5/23/16.
 */
public class Verse {

    Integer num;
    String verse;

    public Verse(Integer num, String verse){
        this.num = num;
        this.verse = verse;
    }

    @Override
    public String toString() {
        //return super.toString();
        return num + " " + verse;
    }
}
