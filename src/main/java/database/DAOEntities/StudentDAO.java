package database.DAOEntities;

import database.Entities.StudentEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import database.Entities.Osoba;

import java.util.List;

public class StudentDAO {

    private EntityManager entityManager;
    public StudentDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public Osoba get(Long id) {
        return entityManager.find(Osoba.class, id);
    }

    public void createStudent(String login, String heslo, int usp, int abs, String stat){
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setLogin(login);
        studentEntity.setHeslo(heslo);
        studentEntity.setÚspěšnost(usp);
        studentEntity.setType("student");
        studentEntity.setProcentoAbsence(abs);
        studentEntity.setStátníPříslušnost(stat);
        save(studentEntity);
    }

    public List<Osoba> getAll() {
        return entityManager.createQuery("SELECT o FROM Osoba o", Osoba.class).getResultList();
    }

    public void save(Osoba osoba) {
        entityManager.persist(osoba);
    }

    public void updateStudent(String login, int usp, int abs, String stat) {
        Query query = entityManager.createQuery("SELECT s FROM StudentEntity s WHERE s.login = :login");
        query.setParameter("login", login);
        List<StudentEntity> students = query.getResultList();
        if (!students.isEmpty()) {
            StudentEntity student = students.get(0);
            student.setÚspěšnost(usp);
            student.setProcentoAbsence(abs);
            student.setStátníPříslušnost(stat);
            entityManager.merge(student);
            System.out.println("Student with login " + login + " updated.");
        } else {
            System.out.println("Student with login " + login + " not found.");
        }
    }

    public void deletebyLogin(String login) {
        Osoba osoba = entityManager.find(Osoba.class, login);
        if (osoba != null) {
            entityManager.remove(osoba);
        }
    }
}
