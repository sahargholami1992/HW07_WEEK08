package org.example.service;

import org.example.base.service.BaseEntityService;
import org.example.domain.User;

import java.sql.SQLException;

public interface UserService extends BaseEntityService {
    public User login(String username) throws SQLException;
}
