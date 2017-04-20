/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.resource;


import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * 方法一，Application类
 * @author Administrator
 */
//@ApplicationPath("/webapi/*")
//public class AirApplication extends Application {
//	@Override
//	public Set<Class<?>> getClasses() {
//		final Set<Class<?>> classes = new HashSet<Class<?>>();
//		classes.add(MyResource.class);
//		return classes;
//	}
//}

/**
 * 方法二，ResourceConfig子类
 * @author Administrator
 */
@ApplicationPath("/webapi")
public class AirApplication extends ResourceConfig {
    public AirApplication() {
//        packages("org.foo.rest;org.bar.rest");
// packages("com.example.resource");
//packages("com.learn.resource.annotation.method");
// register(MyResource.class);
// register(BookResource.class);
    }
}