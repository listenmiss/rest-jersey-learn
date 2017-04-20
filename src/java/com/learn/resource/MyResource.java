/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.resource;

import com.learn.domain.Message;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "rest-jersey-learn";
    }
    
    @Path("message/xml")
    @GET
    @Produces({"application/xml", "text/html"})
    public Message getMessage()  {
        Message m = new Message();
        m.setAppInfo("使用jersey的案例！");
        m.setMsgType(1);
        return m;

    }
    @Path("message/json")
    @GET
    @Produces({"application/json", "text/html"})
    public Message getJSONMessage()  {
        Message m = new Message();
        m.setAppInfo("使用jersey的案例！");
        m.setMsgType(1);
        return m;
    }
}
