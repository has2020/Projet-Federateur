package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "RATING")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull( message = "Veuillez saisir un nom d'utilisateur" )
    private long idArt1;
    @NotNull
    private long idArt2;
    @NotNull
    private double rating;

    public long getId() {
        return id;
    }

    public Rating setId(long id) {
        this.id = id;
        return this;
    }

    public long getIdArt1() {
        return idArt1;
    }

    public Rating setIdArt1(long idArt1) {
        this.idArt1 = idArt1;
        return this;
    }

    public long getIdArt2() {
        return idArt2;
    }

    public Rating setIdArt2(long idArt2) {
        this.idArt2 = idArt2;
        return this;
    }

    public double getRating() {
        return rating;
    }

    public Rating setRating(double rating) {
        this.rating = rating;
        return this;
    }
}
