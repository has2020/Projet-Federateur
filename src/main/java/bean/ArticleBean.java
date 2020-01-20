package bean;

import dao.ArticleDao;
import entities.Article;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@RequestScoped
public class ArticleBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private Article article;

    // Injection de notre EJB (Session Bean Stateless)
    @EJB
    private ArticleDao articleDao;
    private List<Article> listimg;
    public static Article currentArticle;
    // Initialisation de l'entité user
    public ArticleBean() {
        article = new Article();
    }

    public void addArticle() {
        articleDao.creer( article );
        FacesMessage message = new FacesMessage( "FitstArticle Added !" );
        FacesContext.getCurrentInstance().addMessage( null, message );
    }

    public String getcurrentarticle(Article art)
    {
        currentArticle=art;
        return "Bookpage?faces-redirect=true";
    }

    public void init()
    {
        listimg=articleDao.getArticle();
        System.out.print("jajk");
    }
    public Article getArticle() {
        return article;
    }

    public ArticleBean setArticle(Article article) {
        this.article = article;
        return this;
    }

    public ArticleDao getArticleDao() {
        return articleDao;
    }

    public ArticleBean setArticleDao(ArticleDao articleDao) {
        this.articleDao = articleDao;
        return this;
    }

    public List<Article> getListimg() {
        init();
        return listimg;
    }

    public ArticleBean setListimg(List<Article> listimg) {
        this.listimg = listimg;
        return this;
    }

    public Article getCurrentArticle() {
        return currentArticle;
    }

    public ArticleBean setCurrentArticle(Article currentArticle) {
        this.currentArticle = currentArticle;
        return this;
    }
}
