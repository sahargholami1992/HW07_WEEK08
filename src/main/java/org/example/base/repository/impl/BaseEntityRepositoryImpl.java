package org.example.base.repository.impl;

import org.example.base.domain.BaseEntity;
import org.example.base.repository.BaseEntityRepository;

import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class BaseEntityRepositoryImpl implements BaseEntityRepository {
    protected final Connection connection;

    public static final String FIND_BY_ID_QUERY_TEMPLATE = "select * from %s where id = ?";
    public static final String FIND_ALL_QUERY_TEMPLATE = "select * from %s";
    public static final String INSERT_QUERY_TEMPLATE = "insert into %s(%s) values(%s)";
    public static final String UPDATE_QUERY_TEMPLATE = "update %s set %s where id = ?";
    public static final String DELETE_BY_ID_QUERY_TEMPLATE = "delete from %s where id = ?";

    protected BaseEntityRepositoryImpl(Connection connection) {
        this.connection = connection;
    }


    @Override
    public BaseEntity[] findAll() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                String.format(FIND_ALL_QUERY_TEMPLATE, getEntityTableName())
        );
        ResultSet resultSet = preparedStatement.executeQuery();
        BaseEntity[] entities = new BaseEntity[(int) count()];
        int index = 0;
        while (resultSet.next()){
            entities[index] = mapResultSetToEntity(resultSet);
            index++;
        }
        return entities;
    }




    @Override
    public BaseEntity findById(Long id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                String.format(FIND_BY_ID_QUERY_TEMPLATE, getEntityTableName())
        );
        preparedStatement.setLong(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            return mapResultSetToEntity(resultSet);
        }
        return null;
    }

    @Override
    public void deleteById(Long id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                String.format(
                        DELETE_BY_ID_QUERY_TEMPLATE,
                        getEntityTableName()
                )
        );
        preparedStatement.setLong(1, id);
        preparedStatement.executeUpdate();
    }

    @Override
    public long count() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "select count(*) from " + getEntityTableName()
        );
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getLong(1);
    }

    @Override
    public BaseEntity save(BaseEntity entity) throws SQLException {
        return saveSecondApproach(entity);
    }

    protected BaseEntity saveSecondApproach(BaseEntity entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                generateSaveSecondApproachQuery(),
                Statement.RETURN_GENERATED_KEYS
        );
        fillPreparedStatementParamsForSave(preparedStatement, entity);

        return setGenerateKeyAndReturnEntity(entity, preparedStatement);
    }
    protected BaseEntity setGenerateKeyAndReturnEntity(BaseEntity entity, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.executeUpdate();
        ResultSet generatedKeysResultSet = preparedStatement.getGeneratedKeys();
        generatedKeysResultSet.next();
        entity.setId(
                generatedKeysResultSet.getLong(1)
        );
        return entity;
    }

    protected String generateSaveSecondApproachQuery() {
        String[] insertColumns = getInsertColumnsForSecondApproach();

        return String.format(
                INSERT_QUERY_TEMPLATE,
                getEntityTableName(),
                String.join(",", insertColumns),
                generateQuestionMarkForInsertQuery(insertColumns.length)
        );

    }

    private String generateQuestionMarkForInsertQuery(int length) {
        String questionMarks = "";
        for (int i = 0; i < length; i++) {
            if (i == length - 1) {
                questionMarks = questionMarks.concat("?");
            } else {
                questionMarks = questionMarks.concat("?, ");
            }
        }
        return questionMarks;
    }

    @Override
    public BaseEntity update(BaseEntity entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                generateUpdateQuery()
        );
        fillPreparedStatementParamsForUpdate(preparedStatement, entity);
        preparedStatement.executeUpdate();
        return entity;
    }
    protected String generateUpdateQuery() {
        String[] updateColumns = getInsertColumnsForSecondApproach();

        String setClause = "";
        for (String updateColumn : updateColumns) {
            setClause = setClause.concat(updateColumn).concat(" = ?,");
        }
        setClause = setClause.substring(0, setClause.length() - 1);
        return String.format(
                UPDATE_QUERY_TEMPLATE,
                getEntityTableName(),
                setClause
        );
    }

    @Override
    public boolean existsById(Long id) throws SQLException {
        return existsByIdWithIdSelection(id);
    }
    protected boolean existsByIdWithIdSelection(Long id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "select id from " + getEntityTableName() + " where id = ?"
        );
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next();
    }

    protected abstract String getEntityTableName();
    protected abstract BaseEntity mapResultSetToEntity(ResultSet resultSet) throws SQLException;
    protected abstract void fillPreparedStatementParamsForSave(PreparedStatement preparedStatement,
                                                               BaseEntity entity) throws SQLException;

    protected abstract void fillPreparedStatementParamsForUpdate(PreparedStatement preparedStatement,
                                                                 BaseEntity entity) throws SQLException;

    protected abstract String[] getInsertColumnsForSecondApproach();

}
