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
public class RatingBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private Rating rating;
    private static Integer currentRating=0;
    // Injection de notre EJB (Session Bean Stateless)
    @EJB
    private RatingDao ratingDao;
    // Initialisation de l'entité user
    public RatingBean() {
        rating = new Rating();
    }


    @PostConstruct
    public void init()
    {

    }

    public void ratingchange(RateEvent rateEvent)
    {
        init();
        currentRating=(Integer) rateEvent.getRating();
        rating.setIdArt1(RegisterBean.userid);
        rating.setIdArt2(ArticleBean.currentArticle.getId());
        rating.setRating(currentRating);
        ratingDao.creer(rating);
    }
    public Rating getRating() {
        return rating;
    }

    public RatingBean setRating(Rating rating) {
        this.rating = rating;
        return this;
    }

    public RatingDao getRatingDao() {
        return ratingDao;
    }

    public RatingBean setRatingDao(RatingDao ratingDao) {
        this.ratingDao = ratingDao;
        return this;
    }

        public Integer getCurrentRating() {
        return currentRating;
    }

    public RatingBean setCurrentRating(Integer currentRating) {
        this.currentRating = currentRating;
        return this;
    }
}
