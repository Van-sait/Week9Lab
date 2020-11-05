/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.UserDB;
import java.util.List;
import models.User;
/**
 *
 * @author 829942
 */
public class UserService {
    
    public User get(String email) throws Exception {
        UserDB userDB = new UserDB();
        User user = userDB.get(email);
        return user;
    }
    
    public List<User> getAll() throws Exception {
        UserDB userDB = new UserDB();
        List<User> users = userDB.getAll();
        return users;
    }
    
    
    public void insert(User thisUser) throws Exception {
        User user = thisUser;
        UserDB userDB = new UserDB();
        userDB.insert(user);
    }
    
    public void update(User thisUser) throws Exception {
        User user = thisUser;
        UserDB userDB = new UserDB();
        user.setActive(user.getActive());
        user.setEmail(user.getEmail());
        user.setFirstName(user.getFirstName());
        user.setLastName(user.getLastName());
        user.setPassword(user.getPassword());
        user.setRole(user.getRole());
        userDB.update(user);
    }
    
    public void delete(User thisUser) throws Exception {
        
        UserDB userDB = new UserDB();
        User user = userDB.get(thisUser);
        userDB.delete(user);
    }

    public void delete(String userEmail) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    
}
