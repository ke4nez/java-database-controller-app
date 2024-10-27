package database.Entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@jakarta.persistence.Table(name = "místnost", schema = "public", catalog = "lysenan1")
public class MístnostEntity {
    @Id
    @jakarta.persistence.Column(name = "číslo_místnosti")
    private int čísloMístnosti;


    public int getČísloMístnosti() {
        return čísloMístnosti;
    }

    public void setČísloMístnosti(int čísloMístnosti) {
        this.čísloMístnosti = čísloMístnosti;
    }

    @Basic
    @Column(name = "kapacita")
    private int kapacita;

    @ManyToMany(mappedBy = "místnosti")
    private Set<StudentEntity> students = new HashSet<>();




    public int getKapacita() {
        return kapacita;
    }

    public void setKapacita(int kapacita) {
        this.kapacita = kapacita;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MístnostEntity that = (MístnostEntity) o;
        return čísloMístnosti == that.čísloMístnosti && kapacita == that.kapacita;
    }

    @Override
    public int hashCode() {
        return Objects.hash(čísloMístnosti, kapacita);
    }

    public Set<StudentEntity> getStudents() {
        return students;
    }

    public void setStudents(Set<StudentEntity> students) {
        this.students = students;
    }
}
