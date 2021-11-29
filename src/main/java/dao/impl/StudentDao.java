package dao.impl;
import dao.IStudentDao;
import entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import util.JPA;

public class StudentDao extends BaseDao<Student> implements IStudentDao {
    @Override
    public boolean Login(String name, String password) {
        EntityManager manager = JPA.getEntityManager();
        String sql = "select s from Student s where s.name=:username and s.password=:password ";
        Query query = manager.createQuery(sql);
        query.setParameter("username",name);
        query.setParameter("password",password);
        List list = query.getResultList();
        manager.close();
        return list.size()>=1;
    }
}