package rest.asii.dao;

import java.util.HashMap;
import java.util.Map;

import rest.asii.model.*;


public enum ArticlesDao {
    instance;

    private Map<String, Article> articles = new HashMap<>();

    private ArticlesDao() {
        Article art = new Article("PC DELL", "Dell", 3000.30, Categorie.PC_PORTABLE);
        articles.put("1", art);
        Article art2 = new Article("PC MAC", "Apple", 3000.30, Categorie.PC_PORTABLE);
        articles.put("1", art);
        articles.put("1", art2);

    }
    
    public Map<String, Article> getModel(){
        return articles;
    }

}