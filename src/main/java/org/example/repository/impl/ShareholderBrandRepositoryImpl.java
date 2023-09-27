package org.example.repository.impl;

import org.example.repository.ShareholderBrandRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ShareholderBrandRepositoryImpl implements ShareholderBrandRepository {
    Connection connection;

    public ShareholderBrandRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(long shareholder_id, long brand_id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "insert into shareholder_brand(shareholder_id,brand_id ) values (?,?)"
        );
        preparedStatement.setLong(1,shareholder_id);
        preparedStatement.setLong(1,brand_id);
        preparedStatement.executeUpdate();
    }

    @Override
    public void delete(long shareholder_id, long brand_id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "Delete from shareholder_brand where shareholder_id=? AND brand_id=? "
        );
        preparedStatement.setLong(1,shareholder_id);
        preparedStatement.setLong(1,brand_id);
        preparedStatement.executeUpdate();
    }
}
