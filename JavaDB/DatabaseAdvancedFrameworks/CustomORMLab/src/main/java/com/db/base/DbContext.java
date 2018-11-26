package com.db.base;

import java.sql.SQLException;

public interface DbContext<T> {
    //insert + update
    boolean persist(T entity);

    Iterable<T> find() throws SQLException;

    Iterable<T> find(String where);

    T findFirst();

    T findFirst(String where);

    T findById(long id);
}
