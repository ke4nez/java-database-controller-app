package database.Entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@PrimaryKeyJoinColumn(name = "login")
@Table(name = "student", schema = "public", catalog = "lysenan1")
public class StudentEntity extends Osoba{

    @Basic
    @Column(name = "úspěšnost")
    private Integer úspěšnost;

    @Basic
    @Column(name = "procento_absence")
    private Integer procentoAbsence;

    @Basic
    @Column(name = "státní_příslušnost")
    private String státníPříslušnost;

    @ManyToMany
    @JoinTable(
            name = "studuje_v",
            joinColumns = @JoinColumn(name = "login"),
            inverseJoinColumns = @JoinColumn(name = "číslo_místnosti")
    )



    private Set<MístnostEntity> místnosti = new HashSet<>();


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getÚspěšnost() {
        return úspěšnost;
    }

    public void setÚspěšnost(Integer úspěšnost) {
        this.úspěšnost = úspěšnost;
    }

    public Integer getProcentoAbsence() {
        return procentoAbsence;
    }

    public void setProcentoAbsence(Integer procentoAbsence) {
        this.procentoAbsence = procentoAbsence;
    }

    public String getStátníPříslušnost() {
        return státníPříslušnost;
    }

    public void setStátníPříslušnost(String státníPříslušnost) {
        this.státníPříslušnost = státníPříslušnost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentEntity that = (StudentEntity) o;
        return Objects.equals(login, that.login) && Objects.equals(úspěšnost, that.úspěšnost) && Objects.equals(procentoAbsence, that.procentoAbsence) && Objects.equals(státníPříslušnost, that.státníPříslušnost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, úspěšnost, procentoAbsence, státníPříslušnost);
    }

    public Set<MístnostEntity> getMístnosti() {
        return místnosti;
    }

    public void setMístnosti(Set<MístnostEntity> místnosti) {
        this.místnosti = místnosti;
    }
}
