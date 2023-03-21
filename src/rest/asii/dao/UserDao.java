package rest.asii.dao;

import rest.asii.model.*;
import java.util.HashMap;
import java.util.Map;
import rest.asii.model.Article;
import rest.asii.model.Categorie;

public enum UserDao {
	instance;

    private UserDao() {
        User user1 = new User("nom1", "prenom1", "adress1" );
        User user2 = new User("nom2", "prenom2", "adress2" );
    }
    
}
