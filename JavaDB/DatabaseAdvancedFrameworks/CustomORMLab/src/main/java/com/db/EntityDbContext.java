package com.db;

import com.db.base.DbContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.Collections;

public class EntityDbContext<T> implements DbContext<T> {
    private static final String SELECT_QUERY_TEMPLATE = "SELECT * FROM {0}";
    private final Connection connection;
    private final Class<T> klass;

    public EntityDbContext(Connection connection, Class<T> klass) {
        this.connection = connection;
        this.klass = klass;
    }

    public boolean persist(T entity) {
        return false;
    }

    public Iterable<T> find() throws SQLException {
        String queryString = MessageFormat.format(
                SELECT_QUERY_TEMPLATE,
                getTableName()
        );

        PreparedStatement query = this.connection.prepareStatement(queryString);
        ResultSet resultSet = query.executeQuery();

        resultSet.next();
        System.out.println(resultSet.getString("first_name"));

        return Collections.emptyList();
    }

    private String getTableName() {
        return klass.getSimpleName() + "s";
    }

    public Iterable<T> find(String where) {
        return null;
    }

    public T findFirst() {
        return null;
    }

    public T findFirst(String where) {
        return null;
    }

    public T findById(long id) {
        return null;
    }
}
