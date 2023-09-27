package org.example.repository.impl;

import org.example.base.domain.BaseEntity;
import org.example.base.repository.impl.BaseEntityRepositoryImpl;
import org.example.domain.Brand;
import org.example.domain.Shareholder;
import org.example.domain.User;
import org.example.repository.BrandRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class BrandRepositoryImpl extends BaseEntityRepositoryImpl implements BrandRepository {
    public BrandRepositoryImpl(Connection connection) {
        super(connection);
    }



    @Override
    protected String getEntityTableName() {
        return Brand.TABLE_NAME;
    }

    @Override
    protected BaseEntity mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        Brand brand = new Brand();
        brand.setId(
                resultSet.getLong(1)
        );
        brand.setName(
                resultSet.getString(2)
        );
        brand.setWebsite(
                resultSet.getString(3)
        );
        brand.setDescription(
                resultSet.getString(4)
        );
        return brand;
    }

    @Override
    protected void fillPreparedStatementParamsForSave(PreparedStatement preparedStatement, BaseEntity entity) throws SQLException {
        Brand brand = (Brand) entity;
        preparedStatement.setString(
                1,
                brand.getName()
        );
        preparedStatement.setString(
                2,
                brand.getWebsite()
        );
        preparedStatement.setString(
                3,
                brand.getDescription()
        );
    }


    @Override
    protected void fillPreparedStatementParamsForUpdate(PreparedStatement preparedStatement, BaseEntity entity) throws SQLException {
        Brand brand = (Brand) entity;
        preparedStatement.setString(
                1,
                brand.getName()
        );
        preparedStatement.setString(
                2,
                brand.getWebsite()
        );
        preparedStatement.setString(
                3,
                brand.getDescription()
        );
        preparedStatement.setLong(
                4,
                brand.getId()
        );
    }

    @Override
    protected String[] getInsertColumnsForSecondApproach() {
        return new String[]{
                Brand.NAME,
                Brand.WEBSITE,
                Brand.DESCRIPTION
        };
    }
}
