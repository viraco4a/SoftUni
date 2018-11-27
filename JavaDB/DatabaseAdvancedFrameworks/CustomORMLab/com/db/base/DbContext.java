package com.db.base;

import java.sql.SQLException;
import java.util.List;

public interface DbContext<T> {
    //insert + update
    boolean persist(T entity);

    List<T> find() throws SQLException;

    List<T> find(String where);

    T findFirst();

    T findFirst(String where);

    T findById(long id);
}
