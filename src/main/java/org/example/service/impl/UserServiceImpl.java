package org.example.service.impl;

import org.example.base.repository.BaseEntityRepository;
import org.example.base.service.impl.BaseEntityServiceImpl;
import org.example.domain.User;
import org.example.repository.UserRepository;
import org.example.service.UserService;

import java.sql.SQLException;

public class UserServiceImpl extends BaseEntityServiceImpl implements UserService {
    public UserServiceImpl(BaseEntityRepository baseRepository) {
        super(baseRepository);
    }

    @Override
    public User login(String username) throws SQLException {
        return ((UserRepository) baseRepository).login(username);
    }
}
