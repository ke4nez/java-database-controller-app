package database.DAOEntities;

import jakarta.persistence.EntityManager;
import database.Entities.StudujeVEntity;

public class Studuje_vDAO {
    private EntityManager entityManager;
    public Studuje_vDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public void save(StudujeVEntity studujeVEntity) {
        entityManager.persist(studujeVEntity);
    }
}
