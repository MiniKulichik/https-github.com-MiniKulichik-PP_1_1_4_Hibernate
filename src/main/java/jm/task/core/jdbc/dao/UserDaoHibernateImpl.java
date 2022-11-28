package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {

    }
    private Util util = new Util();

    @Override
    public void createUsersTable() {
        Transaction transaction = null;
        try (Session session = util.getSessionFactory().openSession()) {
            transaction= session.beginTransaction();
            session.createSQLQuery("""
                create table if not exists users (
                  `id` INT NOT NULL AUTO_INCREMENT,
                  `name` VARCHAR(45) NOT NULL,
                  `lastname` VARCHAR(45) NOT NULL,
                  `age` INT(3) NOT NULL,
                  PRIMARY KEY (`id`));""")
                    .executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void dropUsersTable() {
        Transaction transaction = null;
        try (Session session = util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.createSQLQuery("DROP TABLE IF EXISTS users;")
                    .addEntity(User.class)
                    .executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Transaction transaction = null;
        try (Session session = util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(new User(name, lastName, age));
            transaction.commit();
            System.out.println("User с именем – " + name + " добавлен в базу данных");
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

        @Override
        public void removeUserById (long id) {
            Transaction transaction = null;
            try (Session session = util.getSessionFactory().openSession()) {
                transaction = session.beginTransaction();
                    session.delete(session.get(User.class, id));
                    transaction.commit();
            } catch (HibernateException e) {
                if (transaction != null) {
                    transaction.rollback();
                }
            }
        }

        @Override
        public List<User> getAllUsers () {
            List<User> userList = new ArrayList<>();
            Transaction transaction = null;
            try (Session session = util.getSessionFactory().openSession()) {
                transaction= session.beginTransaction();
                userList = session.createQuery("from User", User.class).getResultList();
                transaction.commit();
            } catch (HibernateException e) {
                if (transaction != null) {
                    transaction.rollback();
                }
            }
            return userList;
        }

        @Override
        public void cleanUsersTable () {
            Transaction transaction = null;
            try (Session session = util.getSessionFactory().openSession()) {
                transaction = session.beginTransaction();
                session.createSQLQuery("truncate table users").executeUpdate();
                transaction.commit();
            } catch (HibernateException e) {
                if (transaction != null) {
                    transaction.rollback();
                }
            }
        }
    }
