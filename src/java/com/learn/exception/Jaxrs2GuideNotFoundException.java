/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.exception;

import javax.ws.rs.WebApplicationException;

public class Jaxrs2GuideNotFoundException extends WebApplicationException {
    private static final long serialVersionUID = 1L;

    public Jaxrs2GuideNotFoundException() {
        super(javax.ws.rs.core.Response.Status.NOT_FOUND);
    }

    public Jaxrs2GuideNotFoundException(String message) {
        super(message);
    }
}
