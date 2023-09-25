package org.example.base.repository.impl;

import org.example.base.domain.BaseEntity;
import org.example.base.repository.BaseEntityRepository;

import java.sql.SQLException;

public class BaseEntityRepositoryImpl implements BaseEntityRepository {


    @Override
    public BaseEntity[] findAll() throws SQLException {
        return new BaseEntity[0];
    }

    @Override
    public BaseEntity findById(Long id) throws SQLException {
        return null;
    }

    @Override
    public void deleteById(Long id) throws SQLException {

    }

    @Override
    public long count() throws SQLException {
        return 0;
    }

    @Override
    public BaseEntity save(BaseEntity entity) throws SQLException {
        return null;
    }

    @Override
    public BaseEntity update(BaseEntity entity) throws SQLException {
        return null;
    }

    @Override
    public boolean existsById(Long id) throws SQLException {
        return false;
    }
}
