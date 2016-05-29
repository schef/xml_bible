package io.github.schef.xmlbible;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import io.github.schef.xmlbible.Book.Bible;
import io.github.schef.xmlbible.Book.Book;
import io.github.schef.xmlbible.Book.Chapter;
import io.github.schef.xmlbible.Book.Verse;

/**
 * Created by schef on 5/23/16.
 */
public class XMLPullParserHandler {
    private String bibleString;
    private String bookString;
    private Integer chapterInt;
    private Integer verseInt;
    private String text;
    private Chapter chapter;
    private Verse verse;
    private Book book;
    Bible bible;

    public XMLPullParserHandler() {
        bible.init("dummy", new ArrayList<Book>());
    }

    //public List<Book> getEmployees() {
    //    return employees;
    //}

    public Bible parse(InputStream is) {
        XmlPullParserFactory factory = null;
        XmlPullParser parser = null;
        try {
            factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            parser = factory.newPullParser();

            parser.setInput(is, null);

            int eventType = parser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                String tagname = parser.getName();

                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        if (tagname.equalsIgnoreCase("bible")) {
                            bibleString = parser.getAttributeValue(0);
                            //employee = new Employee();
                            bible.setName(bibleString);


                        }
                        else if (tagname.equalsIgnoreCase("book")) {
                            //employee.setBook(parser.getAttributeValue(0));
                            bookString = parser.getAttributeValue(0);
                            //employee = new Employee();
                            book = new Book();
                            book.init(bookString);
                            //System.out.println("start bk: " + book);
                        } else if (tagname.equalsIgnoreCase("chapter")) {
                            //employee.setChapter();
                            chapterInt = Integer.parseInt(parser.getAttributeValue(0));
                            chapter = book.addChapter();
                            chapter.init(chapterInt);

                            //System.out.println("start ch: " + chapter);
                        } else if (tagname.equalsIgnoreCase("verse")) {
                            //employee.setDepartment(text);
                            verseInt = Integer.parseInt(parser.getAttributeValue(0));
                            verse = chapter.addVerse();

                            //System.out.println("start ve: " + verse);
                            text = "";
                        }
                        break;

                    case XmlPullParser.TEXT:
                        text += parser.getText();
                        break;

                    case XmlPullParser.END_TAG:
                        if (tagname.equalsIgnoreCase("book")) {
                            // add employee object to list
                            bible.addBook(book);
                            //System.out.println("end bk: " + book);
                        }
                        else if (tagname.equalsIgnoreCase("chapter")) {
                            //System.out.println("end ch: " + chapter);
                        }
                        else if (tagname.equalsIgnoreCase("verse")) {
                            verse.init(verseInt, text);
                        }
                        break;

                    default:
                        break;
                }
                eventType = parser.next();
            }

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bible;
    }
}
