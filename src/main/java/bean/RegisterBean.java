package bean;

import dao.UserDao;
import entities.User;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.sql.Timestamp;

@Named
@SessionScoped
public class RegisterBean implements Serializable {
    private static final long serialVersionUID = 1L;
    public static long userid;
    public static String username;
    private User user;
    private User useur = new User();

    // Injection de notre EJB (Session Bean Stateless)
    @EJB
    private UserDao userDao;

    // Initialisation de l'entité user
    public RegisterBean() {
        user = new User();
    }

    // Méthode d'action appelée lors du clic sur le bouton du formulaire
    // d'inscription

    public void register() {
        userDao.creer( user );
        FacesMessage message = new FacesMessage( "Succès de l'inscription !" );
        FacesContext.getCurrentInstance().addMessage( null, message );
    }
    @PostConstruct
    public void lel()
    {

    }
    public String check() {
        useur = userDao.check(user);
        lel();
        if (useur == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "User not found!", " Login Error!"));
            return null;
        }
        else
        {
            userid=useur.getId();
            username=useur.getName();
            return "Homepage?faces-redirect=true";
        }


    }



    public User getUser() {
        return user;
    }
    public User getUseur() {
        return useur;
    }

}