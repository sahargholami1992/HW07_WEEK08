package org.example.repository.impl;

import org.example.base.domain.BaseEntity;
import org.example.base.repository.impl.BaseEntityRepositoryImpl;

import org.example.domain.Category;
import org.example.repository.CategoryRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CategoryRepositoryImpl extends BaseEntityRepositoryImpl implements CategoryRepository {
    public CategoryRepositoryImpl(Connection connection) {
        super(connection);
    }


    @Override
    protected String getEntityTableName() {
        return Category.TABLE_NAME;
    }

    @Override
    protected BaseEntity mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        Category category = new Category();
        category.setId(
                resultSet.getLong(1)
        );
        category.setName(
                resultSet.getString(2)
        );
        category.setDescription(
                resultSet.getString(3)
        );
        return category;
    }

    @Override
    protected void fillPreparedStatementParamsForSave(PreparedStatement preparedStatement, BaseEntity entity) throws SQLException {
        Category category = (Category) entity;
        preparedStatement.setString(
                1,
                category.getName()
        );
        preparedStatement.setString(
                2,
                category.getDescription()
        );
    }

    @Override
    protected void fillPreparedStatementParamsForUpdate(PreparedStatement preparedStatement, BaseEntity entity) throws SQLException {
        Category category = (Category) entity;
        preparedStatement.setString(
                1,
                category.getName()
        );
        preparedStatement.setString(
                2,
                category.getDescription()
        );
        preparedStatement.setLong(
                3,
                category.getId()
        );
    }

    @Override
    protected String[] getInsertColumnsForSecondApproach() {
        return new String[]{
                Category.NAME,
                Category.DESCRIPTION,
        };
    }
}
