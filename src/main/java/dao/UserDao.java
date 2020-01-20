package dao;

import entities.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


@Stateless
public class UserDao {

    // Injection du manager, qui s'occupe de la connexion avec la BDD
    @PersistenceContext( unitName = "primary" )
    private EntityManager       em;

    // Enregistrement d'un nouvel user
    @Transactional
    public void creer( User user ) throws DAOException {
        try {
            System.out.println(user.getLogin());
            em.merge( user );
            em.flush();
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
    }



    public User check(User user) throws DAOException {
        try {
            String checklogs = "SELECT u from User u where u.login = :name and u.password = :password";
            User useur= (User) em.createQuery(checklogs).setParameter("name", user.getLogin()).setParameter("password", user.getPassword()).getSingleResult();

            return useur;
        } catch (Exception e) {
            return null;
        }
    }


}