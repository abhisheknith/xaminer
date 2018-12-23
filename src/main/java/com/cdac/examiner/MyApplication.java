package com.cdac.examiner;

import com.cdac.examiner.user.UsersController;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import java.util.HashSet;
import java.util.Set;

/**
 * Home application.
 * Add all the resource classes here to expose.
 */
@ApplicationPath("/xaminer")
public class MyApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(UsersController.class);
        return classes;
    }
}
