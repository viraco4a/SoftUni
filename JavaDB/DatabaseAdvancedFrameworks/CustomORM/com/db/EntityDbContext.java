package com.db;

import com.db.annotations.Column;
import com.db.annotations.Entity;
import com.db.annotations.PrimaryKey;
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

/**
 * CREATE TABLE employees (
 * id INT(11) PRIMARY KEY AUTO_INCREMENT,
 * first_name VARCHAR(40),
 * last_name VARCHAR(40)
 * )
 */
public class EntityDbContext<T> implements DbContext<T> {
    private static final String SELECT_QUERY_TEMPLATE = "SELECT * FROM {0}";
    private static final String SELECT_WHERE_QUERY_TEMPLATE = "SELECT * FROM {0} WHERE {1}";
    private static final String SELECT_SINGLE_QUERY_TEMPLATE = "SELECT * FROM {0} LIMIT 1";
    private static final String SELECT_SINGLE_WHERE_QUERY_TEMPLATE = "SELECT * FROM {0} WHERE {1} LIMIT 1";
    private static final String WHERE_PRIMARY_KEY = " {0}={1} ";
    private static final String INSERT_QUERY_TEMPLATE = "INSERT INTO {0} ({1}) VALUES ({2})";
    private static final String UPDATE_QUERY_TEMPLATE = "UPDATE {0} SET {1} WHERE {2}={3}";
    private static final String SET_QUERY_TEMPLATE = " {0}={1} ";
    private static final String CHECK_TABLE_EXISTS_QUERY_TEMPLATE = "SELECT TABLE_NAME FROM information_schema.TABLES\n" +
            "WHERE TABLE_SCHEMA = DATABASE() AND TABLE_NAME = '%s'";

    private final Connection connection;
    private final Class<T> klass;

    public EntityDbContext(Connection connection, Class<T> klass) throws SQLException {
        this.connection = connection;
        this.klass = klass;
        if (this.checkIfTableExists()) {
            this.updateTable();
        } else {
            this.createTable();
        }
    }

    public boolean persist(T entity) throws IllegalAccessException, SQLException {
        Field primaryKeyField = getPrimaryKeyField();
        primaryKeyField.setAccessible(true);
        long primaryKey = (long) primaryKeyField.get(entity);
        if (primaryKey > 0) {
            return update(entity);
        }

        return insert(entity);
    }

    public List<T> find()
            throws SQLException, IllegalAccessException, InstantiationException {
        return find(null);
    }

    public List<T> find(String where)
            throws SQLException, IllegalAccessException, InstantiationException {
        String queryTemplate = where == null
                ? SELECT_QUERY_TEMPLATE
                : SELECT_WHERE_QUERY_TEMPLATE;
        return find(queryTemplate, where);
    }

    public T findFirst()
            throws IllegalAccessException, SQLException, InstantiationException {
        return findFirst(null);
    }

    public T findFirst(String where)
            throws SQLException, InstantiationException, IllegalAccessException {
        String queryTemplate =
                where == null
                        ? SELECT_SINGLE_QUERY_TEMPLATE
                        : SELECT_SINGLE_WHERE_QUERY_TEMPLATE;
        return find(queryTemplate, where).get(0);
    }

    public T findById(long id) throws IllegalAccessException, SQLException, InstantiationException {
        String primaryKeyName = getPrimaryKeyField().getAnnotation(PrimaryKey.class)
                .name();
        String whereString = MessageFormat.format(
                WHERE_PRIMARY_KEY,
                primaryKeyName,
                id
        );
        return findFirst(whereString);
    }

    private List<T> find(String template, String where)
            throws IllegalAccessException, SQLException, InstantiationException {
        String queryString = MessageFormat.format(
                template,
                getTableName(),
                where);

        PreparedStatement query = this.connection.prepareStatement(queryString);
        ResultSet resultSet = query.executeQuery();

        return toList(resultSet);
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

    private List<T> toList(ResultSet resultSet)
            throws SQLException, InstantiationException, IllegalAccessException {
        List<T> result = new ArrayList<>();

        while (resultSet.next()) {
            T entity = this.createEntity(resultSet);
            result.add(entity);
        }

        return result;
    }

    private T createEntity(ResultSet resultSet)
            throws IllegalAccessException, InstantiationException, SQLException {
        T entity = klass.newInstance();

        List<Field> columnFields = getColumnFields();
        Field primaryKeyField = getPrimaryKeyField();

        setPrimaryKeyField(primaryKeyField, resultSet, entity);
        setColumnsFields(columnFields, resultSet, entity);

        return entity;
    }

    private void setColumnsFields(List<Field> columnFields, ResultSet resultSet, T entity) {
        columnFields.forEach(field -> {
            String columnName = field.getAnnotation(Column.class)
                    .name();
            try {
                field.setAccessible(true);
                if (field.getType() == Long.class || field.getType() == long.class) {
                    long value = resultSet.getLong(columnName);
                    field.set(entity, value);
                } else if (field.getType() == String.class) {
                    String value = resultSet.getString(columnName);
                    field.set(entity, value);
                }
            } catch (SQLException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }

    private void setPrimaryKeyField(Field primaryKeyField, ResultSet resultSet, T entity)
            throws IllegalAccessException, SQLException {
        String primaryKeyName = primaryKeyField.getAnnotation(PrimaryKey.class)
                .name();
        long primaryKeyValue = resultSet.getLong(primaryKeyName);
        primaryKeyField.setAccessible(true);
        primaryKeyField.set(entity, primaryKeyValue);
    }

    private List<Field> getColumnFields() {
        return Arrays.stream(klass.getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Column.class))
                .collect(Collectors.toList());
    }

    private Field getPrimaryKeyField() {
        return Arrays.stream(klass.getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(PrimaryKey.class))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Class" + klass + "does not have a primary key annotation"));
    }

    private boolean insert(T entity) throws SQLException {
        List<String> columns = new ArrayList<>();
        List<Object> values = new ArrayList<>();

        getColumnFields()
                .forEach(field -> {
                    try {
                        field.setAccessible(true);
                        String columnName = field.getAnnotation(Column.class)
                                .name();
                        Object value = field.get(entity);
                        columns.add(columnName);
                        values.add(value);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });

        String columnNames = String.join(", ", columns);
        String columnValues = values
                .stream()
                .map(value -> {
                    if (value instanceof String) {
                        return "\'" + value + "\' ";
                    }

                    return value;
                })
                .map(Object::toString)
                .collect(Collectors.joining(", "));
        String queryString = MessageFormat.format(
                INSERT_QUERY_TEMPLATE,
                getTableName(),
                columnNames,
                columnValues
        );

        return connection.prepareStatement(queryString).execute();
    }

    private boolean update(T entity) throws SQLException, IllegalAccessException {
        List<String> updateQueries =
                getColumnFields().stream()
                        .map(field -> {
                            field.setAccessible(true);
                            try {
                                String columnName = field.getAnnotation(Column.class).name();
                                Object value = field.get(entity);
                                if (value instanceof String) {
                                    value = "\'" + value + "\'";
                                }

                                return MessageFormat.format(
                                        SET_QUERY_TEMPLATE,
                                        columnName,
                                        value
                                );
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }
                            return null;
                        })
                        .collect(Collectors.toList());

        String updateQueriesString = String.join(", ", updateQueries);

        Field primaryKey = getPrimaryKeyField();
        primaryKey.setAccessible(true);
        String primaryKeyName = primaryKey
                .getAnnotation(PrimaryKey.class)
                .name();
        long primaryKeyValue = (long) primaryKey
                .get(entity);

        String queryString = MessageFormat.format(
                UPDATE_QUERY_TEMPLATE,
                getTableName(),
                updateQueriesString,
                primaryKeyName,
                primaryKeyValue
        );

        return connection.prepareStatement(queryString).execute();
    }

    private boolean checkIfTableExists() throws SQLException {
        String queryTemplate = String.format(
                CHECK_TABLE_EXISTS_QUERY_TEMPLATE,
                getTableName()
        );

        PreparedStatement preparedStatement = this.connection
                .prepareStatement(queryTemplate);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            return true;
        }

        return false;
    }

    private void createTable() throws SQLException {
        Field primaryKeyField = getPrimaryKeyField();
        String primaryKeyColumnName = primaryKeyField.getAnnotation(PrimaryKey.class)
                .name();
        String primaryKeyColumnType = getColumnTypeString(primaryKeyField);
        String primaryKeyColumnDefinition = String
                .format(
                        "%s %s PRIMARY KEY AUTO_INCREMENT",
                        primaryKeyColumnName,
                        primaryKeyColumnType
                );
        List<Field> columnsFields = getColumnFields();
        List<String> columnsParams = new ArrayList<>();
        columnsFields
                .forEach(field -> {
                    String columnName = field.getDeclaredAnnotation(Column.class).name();
                    String columnType = getColumnTypeString(field);

                    String columnDefinition = String
                            .format(
                                    "%s %s",
                                    columnName,
                                    columnType
                            );

                    columnsParams.add(columnDefinition);
                });

        String createStatementBody = String
                .format(
                        "%s, %s",
                        primaryKeyColumnDefinition,
                        String.join(", ", columnsParams)
                );

        String query = String.format(
                "CREATE TABLE %s(%s)",
                this.getTableName(),
                createStatementBody
        );

        PreparedStatement preparedStatement = this.connection.prepareStatement(query);
        preparedStatement.execute();
    }

    private void updateTable() {
    }

    private String getColumnTypeString(Field filed) {
        if (filed.getType() == Long.class || filed.getType() == long.class) {
            return "INT";
        } else if (filed.getType() == String.class) {
            return "VARCHAR(255)";
        }

        return null;
    }
}
