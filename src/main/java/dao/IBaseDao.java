package dao;

import java.io.Serializable;
import  java.util.List;

public interface IBaseDao<T>{
    void save(T s);
    void update(T s);
    void delete(Serializable Id);
    T getOne(Serializable Id);
    List<T> getAll();
}
