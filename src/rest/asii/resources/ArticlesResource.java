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



/// Will map the resource to the URL articles
@Path("/articles")
public class ArticlesResource {

    // Allows to insert contextual objects into the class,
    // e.g. ServletContext, Request, Response, UriInfo
    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    GestionArticles g = new GestionArticles();
    
    
    // Return the list of articles to the user in the browser
    @GET
    @Produces(MediaType.TEXT_XML)
    public List<Article> getArticlesBrowser() {
        List<Article> articles = new ArrayList<Article>();
        articles.addAll(g.testerBD());
        return articles;
    }

    
    
    // Return the list of articles for applications
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public List<Article> getArticles() {
        List<Article> articles = new ArrayList<Article>();
        articles.addAll(g.testerBD());
        return articles;
    }

    
    // returns the number of articles
    // Use http://localhost:8080/rest.asii/rest/articles/count
    // to get the total number of records
    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String getCount() {
        int count = 0;//ArticlesDao.instance.getModel().size();
        return String.valueOf(count);
    }

    
    
    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void newArticle(@FormParam("id") String id,
            @FormParam("libelle") String libelle,
            @FormParam("marque") String marque,
            @FormParam("prix") double prix,
            @FormParam("categorie") String categorie,
            @FormParam("photo") String photo,            
            @Context HttpServletResponse servletResponse) throws IOException {
        
        Article art = new Article(id, libelle, marque, prix, categorie, photo);

        //ArticlesDao.instance.getModel().put(id, art);

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