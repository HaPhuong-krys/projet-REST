package rest.asii.resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import rest.asii.dao.ArticlesDao;
import rest.asii.model.*;
import rest.asii.dao.*;

public class UsersResources {
	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	UserDao a = new UserDao();


	// Return the list of users to the user in the browser
	@GET
	@Produces(MediaType.TEXT_XML)
	public List<User> getUsersBrowser() {
	    List<User> users = new ArrayList<User>();
	    users.addAll(a.testerBD());
	    return users;
	}



	// Return the list of users for applications
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<User> getUsers() {
	    List<User> users = new ArrayList<User>();
	    users.addAll(a.testerBD());
	    return users;
	}


	// returns the number of users
	// Use http://localhost:8080/rest.asii/rest/users/count
	// to get the total number of records
	@GET
	@Path("count")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCount() {
	    List<User> users = new ArrayList<User>();
	    int count = users.size();
	    return String.valueOf(count);
	}
	
    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void newUser(@FormParam("id") int id,
            @FormParam("nom") String nom,
            @FormParam("login") String login,
            @FormParam("pass") String pass,
            @FormParam("role") String role,
            @Context HttpServletResponse servletResponse) throws IOException {
        
        User newUser = new User(id, nom, login, pass, role);

        //ArticlesDao.instance.getModel().put(id, newUser);

        servletResponse.sendRedirect("../create_article.html");
    }


    // Defines that the next path parameter after todos is
    // treated as a parameter and passed to the TodoResources
    // Allows to type http://localhost:8080/rest.todo/rest/todos/1
    // 1 will be treaded as parameter todo and passed to TodoResource
    @Path("{article}")
    public ArticleResource getArticle(@PathParam("article") String id) {
        return new ArticleResource(uriInfo, request, id);
    }



}
