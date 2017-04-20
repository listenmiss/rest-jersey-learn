/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.resource.media.jackson;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class JsonHybridBook {
    @JsonProperty("bookId")
    private String bookId;

    @JsonProperty("bookName")
    private String bookName;

    public JsonHybridBook() {
        bookId = "2";
        bookName = "Java Restful Web Services实战";
    }
}
