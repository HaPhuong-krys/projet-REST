package rest.asii.dao;

import rest.asii.model.*;
import java.util.HashMap;
import java.util.Map;
import rest.asii.model.Article;
import rest.asii.model.Categorie;

public enum UserDao {
	instance;

    private Map<String, Article> articles = new HashMap<>();

    private UserDao() {
        User user1 = new User("nom1", "prenom1", "adress1" );
        User

    }
    
    public Map<String, Article> getModel(){
        return articles;
    }
}
