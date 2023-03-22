package rest.asii.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import rest.asii.dao.ArticlesDao;
import rest.asii.model.Article;

public class ArticleResource {
    @Context
    UriInfo uriInfo;
    @Context
    Request request;
    String id;
    public ArticleResource(UriInfo uriInfo, Request request, String id) {
        this.uriInfo = uriInfo;
        this.request = request;
        this.id = id;
    }

    //Application integration
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Article getArticle() {
        Article art = ArticlesDao.instance.getModel().get(id);
        if(art==null)
            throw new RuntimeException("Get: Article with " + id +  " not found");
        return art;
    }

    // for the browser
    @GET
    @Produces(MediaType.TEXT_XML)
    public Article getArticleHTML() {
        Article art = ArticlesDao.instance.getModel().get(id);
        if(art==null)
            throw new RuntimeException("Get: Todo with " + id +  " not found");
        return art;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public Response putArticle(Article todo) {
        Article art = todo;
        return putAndGetResponse(art);
    }

    @DELETE
    public void deleteArticle() {
        Article art = ArticlesDao.instance.getModel().remove(id);
        if(art==null)
            throw new RuntimeException("Delete: Article with " + id +  " not found");
    }

    private Response putAndGetResponse(Article art) {
        Response res;
        if(ArticlesDao.instance.getModel().containsKey(art.getLibelle())) {
            res = Response.noContent().build();
        } else {
            res = Response.created(uriInfo.getAbsolutePath()).build();
        }
        ArticlesDao.instance.getModel().put(art.getLibelle(), art);
        return res;
    }



}