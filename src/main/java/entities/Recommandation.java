package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Recommandation")
public class Recommandation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull( message = "Veuillez saisir un nom d'utilisateur" )
    private long idArt1;
    @NotNull
    private long idArt2;
    @NotNull
    private float valeur;

    public long getId() {
        return id;
    }

    public Recommandation setId(long id) {
        this.id = id;
        return this;
    }

    public long getIdArt1() {
        return idArt1;
    }

    public Recommandation setIdArt1(long idArt1) {
        this.idArt1 = idArt1;
        return this;
    }

    public long getIdArt2() {
        return idArt2;
    }

    public Recommandation setIdArt2(long idArt2) {
        this.idArt2 = idArt2;
        return this;
    }

    public float getValeur() {
        return valeur;
    }

    public Recommandation setValeur(float value) {
        this.valeur = value;
        return this;
    }
}
