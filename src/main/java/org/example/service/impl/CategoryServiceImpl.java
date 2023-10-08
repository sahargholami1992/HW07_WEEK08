package org.example.service.impl;

import org.example.base.repository.BaseEntityRepository;
import org.example.base.service.impl.BaseEntityServiceImpl;
import org.example.domain.Category;
import org.example.service.CategoryService;

import java.sql.SQLException;


public class CategoryServiceImpl extends BaseEntityServiceImpl
        implements CategoryService {
    public CategoryServiceImpl(BaseEntityRepository baseRepository) {
        super(baseRepository);
    }

//    @Override
//    public Category[] getCategory() throws SQLException {
//        return (Category[]) findAll();
//    }
}
