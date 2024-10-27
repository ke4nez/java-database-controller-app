package database.Entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Inheritance (strategy = InheritanceType.JOINED)
@Table(name = "osoba", schema = "public", catalog = "lysenan1")
@DiscriminatorColumn(name = "type")
public class Osoba {
    @Id
    @Column(name = "login")
    protected String login;
    @Basic
    @Column(name = "heslo")
    private String heslo;

    @Basic
    @Column(name = "type")
    private String type;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHeslo() {
        return heslo;
    }

    public void setHeslo(String heslo) {
        this.heslo = heslo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Osoba that = (Osoba) o;
        return Objects.equals(getLogin(), that.getLogin()) && Objects.equals(getHeslo(), that.getHeslo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLogin(), getHeslo());
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
