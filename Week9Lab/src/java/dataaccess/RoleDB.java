package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import models.Role;
import models.User;

public class RoleDB {

    public List<Role> getAll() throws Exception {
        EntityManager em = DBUtil.getEmfactory().createEntityManager();
        // confused here, is this correct?
        try {
           List<Role> role = em.createNamedQuery("Role.findAll", Role.class).getResultList();
       return  role;
        } finally {
            em.close();
            }
}
}
