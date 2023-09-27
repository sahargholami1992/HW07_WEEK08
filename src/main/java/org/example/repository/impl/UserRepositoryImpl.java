package org.example.repository.impl;

import org.example.base.domain.BaseEntity;
import org.example.base.repository.impl.BaseEntityRepositoryImpl;
import org.example.domain.User;
import org.example.repository.UserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserRepositoryImpl extends BaseEntityRepositoryImpl implements UserRepository {
    public UserRepositoryImpl(Connection connection) {
        super(connection);
    }
    public User login(String username) throws SQLException {
        String loginQuery = "SELECT * FROM users WHERE user_name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(loginQuery);
        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            User user = new User(
                    resultSet.getInt("id"),
                    resultSet.getString("name_user"),
                    resultSet.getString("user_name"),
                    resultSet.getString("email"),
                    resultSet.getString("password")
            );
            return user;
        }
        else
            return null;
    }


    @Override
    protected String getEntityTableName() {
        return User.TABLE_NAME;
    }

    @Override
    protected BaseEntity mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(
                resultSet.getLong(1)
        );
        user.setName(
                resultSet.getString(2)
        );
        user.setUserName(
                resultSet.getString(3)
        );
        user.setEmail(
                resultSet.getString(4)
        );
        user.setPassword(
                resultSet.getString(5)
        );

        return user;
    }

    @Override
    protected void fillPreparedStatementParamsForSave(PreparedStatement preparedStatement, BaseEntity entity) throws SQLException {
        User user = (User) entity;
        preparedStatement.setString(
                1,
                user.getName()
        );
        preparedStatement.setString(
                2,
                user.getUserName()
        );
        preparedStatement.setString(
                3,
                user.getEmail()
        );
        preparedStatement.setString(
                4,
                user.getPassword()
        );

    }

    @Override
    protected void fillPreparedStatementParamsForUpdate(PreparedStatement preparedStatement, BaseEntity entity) throws SQLException {
        User user = (User) entity;
        preparedStatement.setString(
                1,
                user.getName()
        );
        preparedStatement.setString(
                2,
                user.getUserName()
        );
        preparedStatement.setString(
                3,
                user.getEmail()
        );
        preparedStatement.setString(
                4,
                user.getPassword()
        );
        preparedStatement.setLong(
                5,
                user.getId()
        );
    }

    @Override
    protected String[] getInsertColumnsForSecondApproach() {
        return new String[]{
                User.NAME,
                User.USER_NAME,
                User.EMAIL,
                User.PASSWORD
        };
    }
}
