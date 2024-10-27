package database.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class StudujeVEntityPK implements Serializable {
    private String login;
    private int čísloMístnosti;

    public StudujeVEntityPK() {}

    public StudujeVEntityPK(String login, int čísloMístnosti) {
        this.login = login;
        this.čísloMístnosti = čísloMístnosti;
    }
}
