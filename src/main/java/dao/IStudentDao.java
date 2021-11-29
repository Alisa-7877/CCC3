package dao;

import entity.Student;

public interface IStudentDao extends IBaseDao<Student>{
    boolean Login(String name,String password);
}
