package org.example.base.service.impl;

import org.example.base.domain.BaseEntity;
import org.example.base.repository.BaseEntityRepository;
import org.example.base.service.BaseEntityService;

import java.sql.SQLException;

public class BaseEntityServiceImpl implements BaseEntityService {
    protected final BaseEntityRepository baseRepository;

    public BaseEntityServiceImpl(BaseEntityRepository baseRepository) {
        this.baseRepository = baseRepository;
    }

    @Override
    public BaseEntity[] findAll() throws SQLException {
        return baseRepository.findAll();
    }

    @Override
    public BaseEntity findById(Long id) throws SQLException {
        return baseRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) throws SQLException {
        baseRepository.deleteById(id);
    }

    @Override
    public long count() throws SQLException {
        return baseRepository.count();
    }

    @Override
    public BaseEntity register(BaseEntity entity) throws SQLException {
        return baseRepository.save(entity);

    }

    @Override
    public BaseEntity update(BaseEntity entity) throws SQLException {
        return baseRepository.update(entity);
    }

    @Override
    public boolean existsById(Long id) throws SQLException {
        return baseRepository.existsById(id);
    }
}
