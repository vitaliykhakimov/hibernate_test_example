package vitalik.hibernate.dao.Dao;

import java.io.Serializable;
import java.util.List;

public interface DaoInterface<T, Id extends Serializable> {

    public void persist(T entity);

    public void update(T entity);

    public T findById(Id id);

    public void delete(T Entity);

    public List<T> findAll();

    public void deleteAll();
}
