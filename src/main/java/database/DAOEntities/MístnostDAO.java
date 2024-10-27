package database.DAOEntities;

import database.Entities.StudentEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import database.Entities.MístnostEntity;

import java.util.List;
import java.util.Set;


public class MístnostDAO {
    private EntityManager entityManager;

    public void showAllStudentsInRoom(int roomId) {
        MístnostEntity mistnost = entityManager.find(MístnostEntity.class, roomId);
        if (mistnost != null) {
            Set<StudentEntity> students = mistnost.getStudents();
            for (StudentEntity student : students) {
                System.out.println("Student ID: " + student.getLogin());
            }
        } else {
            System.out.println("Room with ID " + roomId + " not found.");
        }
    }

    public void addStudent(String login, int roomId) {
        MístnostEntity mistnost = entityManager.find(MístnostEntity.class, roomId);
        if (mistnost != null) {
            Query query = entityManager.createQuery("SELECT s FROM StudentEntity s WHERE s.login = :login");
            query.setParameter("login", login);
            List<StudentEntity> students = query.getResultList();
            if (!students.isEmpty()) {
                StudentEntity student = students.get(0);
                student.getMístnosti().add(mistnost);
                entityManager.merge(student);
            } else {
                System.out.println("Student with login " + login + " not found.");
            }
        } else {
            System.out.println("Room with ID " + roomId + " not found.");
        }
    }

    public void deleteStudent(String login, int roomId) {
        MístnostEntity mistnost = entityManager.find(MístnostEntity.class, roomId);
        if (mistnost != null) {
            Query query = entityManager.createQuery("SELECT s FROM StudentEntity s WHERE s.login = :login");
            query.setParameter("login", login);
            List<StudentEntity> students = query.getResultList();
            if (!students.isEmpty()) {
                StudentEntity student = students.get(0);
                if (student.getMístnosti().contains(mistnost)) {
                    student.getMístnosti().remove(mistnost);
                    entityManager.merge(student);
                    System.out.println("Student with login " + login + " removed from room with ID " + roomId);
                } else {
                    System.out.println("Student with login " + login + " is not in room with ID " + roomId);
                }
            } else {
                System.out.println("Student with login " + login + " not found.");
            }
        } else {
            System.out.println("Room with ID " + roomId + " not found.");
        }
    }


    public void deleteAllStudents(int roomId) {
        MístnostEntity mistnost = entityManager.find(MístnostEntity.class, roomId);
        if (mistnost != null) {
            Set<StudentEntity> students = mistnost.getStudents();
            for (StudentEntity student : students) {
                student.getMístnosti().remove(mistnost);
                entityManager.merge(student);
            }
            System.out.println("All students removed from room with ID " + roomId);
        } else {
            System.out.println("Room with ID " + roomId + " not found.");
        }
    }

    public void addMistnost(int number, int kapacita){
        MístnostEntity místnostEntity = new MístnostEntity();
        místnostEntity.setKapacita(kapacita);
        místnostEntity.setČísloMístnosti(number);
        save(místnostEntity);
    }

    public void deleteMistnost(int number) {
        MístnostEntity mistnost = entityManager.find(MístnostEntity.class, number);
        if (mistnost != null) {
            // Удалить все связи между студентами и этим кабинетом
            for (StudentEntity student : mistnost.getStudents()) {
                student.getMístnosti().remove(mistnost);
                entityManager.merge(student);
            }
            entityManager.remove(mistnost);
            System.out.println("Room with ID " + number + " deleted.");
        } else {
            System.out.println("Room with ID " + number + " not found.");
        }
    }
    public MístnostDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    public void save(MístnostEntity mistnost) {
        entityManager.persist(mistnost);
    }

}
