package com.db;

import com.db.annotations.Column;
import com.db.annotations.Entity;
import com.db.base.DbContext;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<T> find() throws SQLException {
        String queryString = MessageFormat.format(
                SELECT_QUERY_TEMPLATE,
                getTableName()
        );

        PreparedStatement query = this.connection.prepareStatement(queryString);
        ResultSet resultSet = query.executeQuery();

        return toList(resultSet);
    }


    public List<T> find(String where) {
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

    private String getTableName() {
        Annotation annotation = Arrays.stream(klass.getAnnotations())
                .filter(a -> a.annotationType() == Entity.class)
                .findFirst()
                .orElse(null);

        if (annotation == null) {
            return klass.getSimpleName().toLowerCase() + "s";
        }

        return klass.getAnnotation(Entity.class).name();
    }

    private List<T> toList(ResultSet resultSet) throws SQLException, InstantiationException, IllegalAccessException {
        List<T> result = new ArrayList<>();

        while(resultSet.next()){
            T entity = this.createEntity(resultSet);
            result.add(entity);
        }

        return result;
    }

    private T createEntity(ResultSet resultSet) throws IllegalAccessException, InstantiationException {
        T entity = klass.newInstance();
        List<Field> columnFIelds = Arrays.stream(klass.getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Column.class))
                .collect(Collectors.toList());
        //TODO

        return entity;
    }
}
