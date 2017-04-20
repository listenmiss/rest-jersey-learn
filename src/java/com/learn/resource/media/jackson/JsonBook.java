/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.resource.media.jackson;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {"bookId", "bookName", "chapters"})
public class JsonBook {
    private String[] chapters;
    private String bookId;
    private String bookName;

    public JsonBook() {
        bookId = "1";
        bookName = "Java Restful Web Services实战";
        chapters = new String[0];
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String[] getChapters() {
        return chapters;
    }

    public void setChapters(String[] chapters) {
        this.chapters = chapters;
    }
}
