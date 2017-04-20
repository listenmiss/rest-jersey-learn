/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.resource.media.jackson;

import com.learn.domain.Book;
import com.learn.domain.Books;
import java.text.SimpleDateFormat;
import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.*;
import java.util.Map.Entry;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

@Path("media/jackson")
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_ATOM_XML})
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_ATOM_XML})
public class JacksonResource {

    private static final Logger LOGGER = Logger.getLogger(JacksonResource.class);
    private static final HashMap<Long, Book> memoryBase;

    static {
        memoryBase = new HashMap();
        memoryBase.put(1L, new Book(1L, "JSF2和RichFaces4使用指南", "电子工业出版社", "9787121177378", "2012-09-01"));
        memoryBase.put(2L, new Book(2L, "Java Restful Web Services实战", "机械工业出版社", "9787111478881", "2014-09-01"));
        memoryBase.put(3L, new Book(3L, "Java EE 7 精髓", "人民邮电出版社", "9787115375483", "2015-02-01"));
        memoryBase.put(4L, new Book(4L, "Java Restful Web Services实战II", "机械工业出版社"));
    }

    @Path("/emptybook")
    @GET
    public JsonBook getEmptyArrayBook() {
        final JsonBook book = new JsonBook();
        JacksonResource.LOGGER.debug(book);
        return book;
    }

    @Path("/hybirdbook")
    @GET
    public JsonHybridBook getHybirdBook() {
        final JsonHybridBook book = new JsonHybridBook();
        JacksonResource.LOGGER.debug(book);
        return book;
    }

    @Path("/nojaxbbook")
    @GET
    public JsonNoJaxbBook getNoJaxbBook() {
        final JsonNoJaxbBook book = new JsonNoJaxbBook();
        JacksonResource.LOGGER.debug(book);
        return book;
    }

    @GET
    public Books getBooks() {
        final List<Book> bookList = new ArrayList<>();
        final Set<Map.Entry<Long, Book>> entries = JacksonResource.memoryBase.entrySet();
        final Iterator<Entry<Long, Book>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            final Entry<Long, Book> cursor = iterator.next();
            JacksonResource.LOGGER.debug(cursor.getKey());
            bookList.add(cursor.getValue());
        }
        final Books books = new Books(bookList);
        JacksonResource.LOGGER.debug(books);
        return books;
    }
    
   @Path("/query") 
   @GET
    public Book getBookById(@QueryParam("bookId") final long bookId) {
     return   JacksonResource.memoryBase.get(bookId);
    }
     @Path("/path/{bookId}") 
   @GET
    public Book getBookByPath(@PathParam("bookId") final long bookId) {
     return   JacksonResource.memoryBase.get(bookId);
    }
    
    @POST
    public Book saveBook(final Book book) {
        book.setBookId(System.nanoTime());
        JacksonResource.memoryBase.put(book.getBookId(), book);
        return book;
    }
    @Path("/save/{bookName}")
    @POST
    public Book saveBook2(@PathParam("bookName") final String bookName,final Book book) {
        book.setBookId(System.nanoTime());
        book.setBookName(bookName);
        JacksonResource.memoryBase.put(book.getBookId(), book);
        return book;
    }
    @DELETE
    public void deleteBook(@QueryParam("bookId") final long bookId) {
        JacksonResource.memoryBase.remove(bookId);
    }

    @Path("/del")
    @DELETE
    public boolean deleteBook2(@QueryParam("bookId") final long bookId) {
        JacksonResource.memoryBase.remove(bookId);
        return true;
    }

    @PUT
    public Book updateBook(Book book) {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        book.setPublishTime(dateString);
        JacksonResource.memoryBase.put(book.getBookId(), book);
        return book;
    }
}
