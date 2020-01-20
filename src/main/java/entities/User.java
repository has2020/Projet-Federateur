package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Useur")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull( message = "Veuillez saisir un nom d'utilisateur" )
    @Size( min = 3, message = "Le nom d'utilisateur doit contenir au moins 3 caractères" )
    private String name;
    @NotNull( message = "Veuillez saisir une adresse email" )
    @Pattern( regexp = "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)", message = "Merci de saisir une adresse mail valide" )
    private String login;
    @NotNull( message = "Veuillez saisir un mot de passe" )
    @Size( min = 3, message = "Le mot de passe doit contenir au moins 3 caractères" )
    private String password;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
