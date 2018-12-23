package com.cdac.examiner.user;

import com.cdac.examiner.entities.User;
import com.cdac.examiner.request.CreateUserRequest;
import com.cdac.examiner.response.UserResponse;
import com.cdac.examiner.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/users")
public class UsersController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser() {
        Session session = HibernateUtil.getSession();
        try {
            Query query = session.createQuery("FROM " + User.class.getSimpleName());
            List list = query.list();
            List<UserResponse> returnList = new ArrayList();
            list.forEach(each -> returnList.add(new UserResponse((User)each)));
            return Response.status(201).entity(returnList).build();
        } finally {
            session.close();
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public UserResponse registerUser(CreateUserRequest request) {
        validateParams(request.name, request.email, request.userId, request.userType);
        Session session = HibernateUtil.getSession();
        try {
            User user = new User(request.name, request.email, request.userId, request.userType, true);
            session.save(user);
            return new UserResponse(user);
        } finally {
            session.close();
        }
    }

    private void validateParams(String name, String email, String userId, String userType) throws IllegalArgumentException {

    }

}
