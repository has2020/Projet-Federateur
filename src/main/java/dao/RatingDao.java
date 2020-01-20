package dao;

import bean.RegisterBean;
import entities.Rating;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
public class RatingDao {
    @PersistenceContext( unitName = "primary" )
    private EntityManager em;


    @Transactional
    public void creer( Rating rating ) throws DAOException {
        try {
            em.merge( rating );
            em.flush();
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
    }

    public List<Rating> getRating() throws DAOException {
        try {
            List<Rating> ratings;

            String requete = "SELECT c from Rating c where idArt1="+ RegisterBean.userid;
            ratings = (List<Rating>) em.createQuery(requete).getResultList();
            return ratings;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("KJAZNDKJNA");
            return null;
        }
    }

}
