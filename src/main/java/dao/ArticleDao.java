package dao;

import entities.Article;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
public class ArticleDao {
    @PersistenceContext( unitName = "primary" )
    private EntityManager em;


    // Enregistrement d'un nouvel user
    @Transactional
    public void creer( Article article ) throws DAOException {
        try {
            em.merge( article );
            em.flush();
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
    }
    @Transactional
    public List<Article> getArticle() throws DAOException {
        try {
            List<Article> articles;

            String requete = "SELECT c from Article c";
            articles = (List<Article>) em.createQuery(requete).getResultList();
            return articles;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("KJAZNDKJNA");
            return null;
        }
    }
}
