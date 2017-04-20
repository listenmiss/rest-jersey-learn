/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.resource.annotation.method;

import com.learn.domain.Book;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.log4j.Logger;

/**
 *
 * @author Administrator
 */
@Path("book")
//public interface BookResource {
public class BookResource {

    private final static Logger LOGGER = Logger.getLogger(BookResource.class);
    public static AtomicLong serverBookSequence = new AtomicLong();

    @GET
    public String getWeight() {
        return "150M";
    }

    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_XML)
    public String newBook(Book book) {
        SimpleDateFormat f = new SimpleDateFormat("d MMM yyyy HH:mm:ss");
        Date lastUpdate = Calendar.getInstance().getTime();
        //...
        LOGGER.debug(book.getBookId());
        return f.format(lastUpdate);
    }
//    

    @POST
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    public Book createBook(Book book) {
        book.setBookId(serverBookSequence.incrementAndGet());
        return book;
    }
//

    @DELETE
    public void delete(@QueryParam("bookId") final long bookId) {
        LOGGER.debug(bookId);
    }
}
