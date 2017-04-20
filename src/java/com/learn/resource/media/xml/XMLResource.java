/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.resource.media.xml;
import com.learn.domain.Book;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamSource;

@Path("media/xml")
public class XMLResource {
    private static final Logger LOGGER = Logger.getLogger(XMLResource.class);

    @POST
    @Path("stream")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public StreamSource getStreamSource(javax.xml.transform.stream.StreamSource streamSource) {
        return streamSource;
    }

    @POST
    @Path("sax")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public SAXSource getSAXSource(javax.xml.transform.sax.SAXSource saxSource) {
        return saxSource;
    }

    @POST
    @Path("dom")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public DOMSource getDOMSource(javax.xml.transform.dom.DOMSource domSource) {
        return domSource;
    }

    @POST
    @Path("doc")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Document getDocument(org.w3c.dom.Document document) {
        return document;
    }

    @POST
    @Path("jaxb")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Book getEntity(JAXBElement<Book> bookElement) {
        Book book = bookElement.getValue();
        LOGGER.debug(book.getBookName());
        return book;
    }

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_XML)
    public Book getEntity(Book book) {
        LOGGER.debug(book.getBookName());
        return book;
    }
    
    
    @GET
    @Path("jaxb2")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Hospital getHospital() {
         
        Hospital h = VirtualDatas.hospital;
        return h;
    }
    @POST
    @Path("jaxb2/add")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_XML)
    public Hospital addHospital(Hospital hospital) {
         LOGGER.debug(hospital.getName());
        return hospital;
    }
}

