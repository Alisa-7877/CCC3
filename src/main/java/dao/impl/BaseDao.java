package dao.impl;

import dao.IBaseDao;

import java.io.Serializable;
import java.util.List;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import util.JPA;
public class BaseDao<T> implements IBaseDao<T> {
    private Class<T> clz;
    public BaseDao() {
        ParameterizedType parametclass = (ParameterizedType) this.getClass().getGenericSuperclass();
        Type[] actualTypeArguments = parametclass.getActualTypeArguments();
        clz = (Class<T>) actualTypeArguments[0];
    }
    @Override
    public void save(Object s) {
        EntityManager manager = JPA.getEntityManager();
        manager.getTransaction().begin();
        manager.persist(s);
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public void update(Object s) {
        EntityManager manager = JPA.getEntityManager();
        manager.getTransaction().begin();
        manager.merge(s);
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public void delete(Serializable i) {
        EntityManager manager = JPA.getEntityManager();
        manager.getTransaction().begin();
        T t = manager.find(clz, i);
        manager.remove(t);
        manager.getTransaction().commit();
        manager.close();
    }


    @Override
    public T getOne(Serializable i) {
        EntityManager manager = JPA.getEntityManager();
        T t = manager.find(clz, i);
        manager.close();
        return t;
    }

    @Override
    public List getAll() {
        EntityManager manager = JPA.getEntityManager();
        String sql = "select p from "+ clz.getName() +" as p";
        Query query = manager.createQuery(sql);
        return query.getResultList();
    }

}
