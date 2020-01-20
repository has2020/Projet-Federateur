package dao;

import bean.RegisterBean;
import entities.Rating;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
public class RecommandationDAO {
    @PersistenceContext( unitName = "primary" )
    private EntityManager em;


    @Transactional
    public List<Long> getrarticles() throws DAOException {
        try {
            List<Long> articles;

            String requete = "SELECT idArt2 from Recommandation c where idArt1="+ RegisterBean.userid+"AND valeur=1";
            articles = (List<Long>) em.createQuery(requete).getResultList();

            return articles;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("KJAZNDKJNA");
            return null;
        }
    }

}
