package org.example.repository;

import org.example.base.repository.BaseEntityRepository;
import org.example.domain.User;

import java.sql.SQLException;

public interface UserRepository extends BaseEntityRepository {
    public User login(String username) throws SQLException;
}
