package database.Entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@jakarta.persistence.Table(name = "studuje_v", schema = "public", catalog = "lysenan1")
@jakarta.persistence.IdClass(StudujeVEntityPK.class)
public class StudujeVEntity {
    @Id
    @jakarta.persistence.Column(name = "login")
    private String login;


    @ManyToOne
    @JoinColumn(name = "login", insertable = false, updatable = false)
    private StudentEntity student;

    @ManyToOne
    @JoinColumn(name = "číslo_místnosti", insertable = false, updatable = false)
    private MístnostEntity mistnost;


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Id
    @jakarta.persistence.Column(name = "číslo_místnosti")
    private int čísloMístnosti;

    public int getČísloMístnosti() {
        return čísloMístnosti;
    }

    public void setČísloMístnosti(int čísloMístnosti) {
        this.čísloMístnosti = čísloMístnosti;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudujeVEntity that = (StudujeVEntity) o;
        return čísloMístnosti == that.čísloMístnosti && Objects.equals(login, that.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, čísloMístnosti);
    }

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }

    public MístnostEntity getMistnost() {
        return mistnost;
    }

    public void setMistnost(MístnostEntity mistnost) {
        this.mistnost = mistnost;
    }
}
