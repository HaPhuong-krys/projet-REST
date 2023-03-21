package rest.asii.dao;

import java.util.HashMap;
import java.util.Map;

import rest.asii.model.Article;


public enum ArticlesDao {
    instance;

    private Map<String, Article> articles = new HashMap<>();

    private TodoDao() {

        Todo todo = new Todo("1", "Prendre un bon petit d�j");
        todo.setDescription("il est important de commencer la journ�e par un repas �quilibr�");
        articles.put("1", todo);
        todo = new Todo("2", "Faire 10000 pas");
        todo.setDescription("afin de garder une bonne sant�");
        articles.put("2", todo);

    }
    public Map<String, Todo> getModel(){
        return articles;
    }

}