/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leatn.resource.annotation.param;

import javax.ws.rs.*;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("form-resource")
public class FormResource {
    public static final String USER = "user";
    public static final String PW = "password";
    public static final String NPW = "newPassword";
    public static final String VNPW = "verification";

    @POST
    public String newPassword(
            @DefaultValue("feuyeux") @FormParam(FormResource.USER) final String user,
            @Encoded @FormParam(FormResource.PW) final String password,
            @Encoded @FormParam(FormResource.NPW) final String newPassword,
            @FormParam(FormResource.VNPW) final String verification) {
        return user + ":" + password + ":" + newPassword + ":" + verification;
    }
}

