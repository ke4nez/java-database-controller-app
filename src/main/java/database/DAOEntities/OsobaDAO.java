package database.DAOEntities;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import database.Entities.Osoba;

import java.util.List;

public class OsobaDAO {
    private EntityManager entityManager;
    public OsobaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Osoba get(Long id) {
        return entityManager.find(Osoba.class, id);
    }

    public List<Osoba> getAll() {
        return entityManager.createQuery("SELECT o FROM Osoba o", Osoba.class).getResultList();
    }

    public void save(Osoba osoba) {
        entityManager.persist(osoba);

    }

    public void updatePasswordByLogin(String login, String newPassword) {
        Osoba osoba = entityManager.find(Osoba.class, login);

        if (osoba != null) {
            osoba.setHeslo(newPassword);
            entityManager.merge(osoba);
        } else {
            System.out.println("Особа с логином " + login + " не найдена.");
        }
    }

    public void delete(String login) {
        Osoba osoba = entityManager.find(Osoba.class, login);
        if (osoba != null) {
            entityManager.remove(osoba);
        }
    }

    public void showAllStudents() {
        String queryString = "SELECT o FROM Osoba o WHERE o.type = :type";
        Query query = entityManager.createQuery(queryString);
        query.setParameter("type", "StudentEntity");

        List<Osoba> students = query.getResultList();
        System.out.println("Students:");
        for (Osoba student : students) {
            System.out.println("Login: " + student.getLogin() + ", Heslo: " + student.getHeslo());
        }
    }
}