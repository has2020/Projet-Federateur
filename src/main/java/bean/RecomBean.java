package bean;

import dao.RatingDao;
import entities.Rating;
import org.jboss.logging.annotations.Pos;
import org.primefaces.event.RateEvent;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;


@Named
@RequestScoped
public class RecomBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private static List<Long> recomarticle;


    // Injection de notre EJB (Session Bean Stateless)
    @EJB
    private RatingDao ratingDao;
    // Initialisation de l'entité user



    @PostConstruct
    public void init()
    {

    }





}
