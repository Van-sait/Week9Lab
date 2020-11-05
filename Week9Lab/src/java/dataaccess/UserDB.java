package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import models.*;

public class UserDB {

    public static List<User> getAll(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<User> getAll() throws Exception {
       EntityManager em = DBUtil.getEmfactory().createEntityManager();
        // confused here, is this correct?
        try {
           List<User> user = em.createNamedQuery("User.findAll", User.class).getResultList();
       return  user;
        } finally {
            em.close();
            }
    }

    public User get(String email) throws Exception {
        EntityManager em = DBUtil.getEmfactory().createEntityManager();
        
        
        try {
          User user = em.find(User.class, email);
            return user;
        } finally {
           em.close();
        }
    }

    public void insert(User user) throws Exception {
         EntityManager em = DBUtil.getEmfactory().createEntityManager();
         EntityTransaction trans = em.getTransaction();
        try {
            
            user.getRole().getUserList().add(user);
            trans.begin();
            em.persist(user);
            em.merge(user);
            trans.commit();
            
        } catch(Exception ex){
            trans.rollback();
            
        }
          finally {
          em.close();
        }
    }

    public void update(User user) throws Exception {
       EntityManager em = DBUtil.getEmfactory().createEntityManager();
         EntityTransaction trans = em.getTransaction();
        try {
            
             
            trans.begin();
            em.merge(user);
            trans.commit();
            
        } catch(Exception ex){
            trans.rollback();
            
        }
          finally {
          em.close();
        }
         
    }

    public void delete(User user) throws Exception {
       EntityManager em = DBUtil.getEmfactory().createEntityManager();
         EntityTransaction trans = em.getTransaction();
        try {
            
            user.getRole().getUserList().remove(user);
            trans.begin();
            em.remove(em.merge(user));
            em.merge(user);
            trans.commit();
            
        } catch(Exception ex){
            trans.rollback();
            
        }
          finally {
          em.close();
        }
    }

    public User get(User thisUser) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
