package org.example.repository.impl;

import org.example.base.domain.BaseEntity;
import org.example.base.repository.impl.BaseEntityRepositoryImpl;
import org.example.domain.Shareholder;
import org.example.domain.User;
import org.example.repository.ShareholderRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ShareholderRepositoryImpl extends BaseEntityRepositoryImpl implements ShareholderRepository {
    public ShareholderRepositoryImpl(Connection connection) {
        super(connection);
    }


    @Override
    protected String getEntityTableName() {
        return Shareholder.TABLE_NAME;
    }

    @Override
    protected BaseEntity mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        Shareholder shareholder = new Shareholder();
        shareholder.setId(
                resultSet.getLong(1)
        );
        shareholder.setName(
                resultSet.getString(2)
        );
        shareholder.setPhoneNumber(
                resultSet.getString(3)
        );
        shareholder.setNationalCode(
                resultSet.getString(4)
        );


        return shareholder;
    }

    @Override
    protected void fillPreparedStatementParamsForSave(PreparedStatement preparedStatement, BaseEntity entity) throws SQLException {
        Shareholder shareholder = (Shareholder) entity;
        preparedStatement.setString(
                1,
                shareholder.getName()
        );
        preparedStatement.setString(
                2,
                shareholder.getPhoneNumber()
        );
        preparedStatement.setString(
                3,
                shareholder.getNationalCode()
        );
    }

    @Override
    protected void fillPreparedStatementParamsForUpdate(PreparedStatement preparedStatement, BaseEntity entity) throws SQLException {
        Shareholder shareholder = (Shareholder) entity;
        preparedStatement.setString(
                1,
                shareholder.getName()
        );
        preparedStatement.setString(
                2,
                shareholder.getPhoneNumber()
        );
        preparedStatement.setString(
                3,
                shareholder.getNationalCode()
        );
        preparedStatement.setLong(
                4,
                shareholder.getId()
        );
    }

    @Override
    protected String[] getInsertColumnsForSecondApproach() {
        return new String[]{
                Shareholder.NAME,
                Shareholder.PHONE_NUMBER,
                Shareholder.NATIONAL_CODE
        };
    }
}
