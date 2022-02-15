package peaksoft.dao;

import org.hibernate.*;
import peaksoft.model.User;
import peaksoft.util.Util;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        try {
            Util.getSession();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    public void dropUsersTable() {
        try {
            Session session = Util.getSession().openSession();
            session.beginTransaction();
            Query query = session.createQuery("Delete From User");
            query.executeUpdate();
            session.getTransaction().commit();
            session.close();
            System.out.println("Успешное удаление всех пользователей");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveUser(String name, String lastName, Byte age) {
        try {
            Session session = Util.getSession().openSession();
            session.beginTransaction();
            session.save(new User(name, lastName, age));
            session.getTransaction().commit();
            session.close();
            System.out.println("Успешное сохранение пользователей ");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void removeUserById(long id) {
            try {
                Session session = Util.getSession().openSession();
                Transaction transaction = session.beginTransaction();
                session.createSQLQuery("DELETE FROM  users WHERE id = ?").executeUpdate();
                transaction.commit();
                System.out.println(id + " " + "удален пользователь с id");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }


    @Override
    public List<User> getAllUsers() {

        List<User> userList;

        Session session = Util.getSession().openSession();
            session.beginTransaction();
            userList = session.createQuery("from User").list();
            session.getTransaction().commit();

        return userList;
    }

    @Override
    public void cleanUsersTable() {
        try {
            Session session = Util.getSession().openSession();
            session.beginTransaction();
            Query query = session.createQuery("Delete FROM User");
            query.executeUpdate();
            session.getTransaction().commit();
            session.close();
            System.out.println("Очищено");

           } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
