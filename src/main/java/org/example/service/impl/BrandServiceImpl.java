package org.example.service.impl;

import org.example.base.repository.BaseEntityRepository;
import org.example.base.service.impl.BaseEntityServiceImpl;
import org.example.domain.Brand;
import org.example.service.BrandService;

import java.sql.SQLException;


public class BrandServiceImpl extends BaseEntityServiceImpl
        implements BrandService {
    public BrandServiceImpl(BaseEntityRepository baseRepository) {
        super(baseRepository);
    }


//    @Override
//    public Brand[] getBrands() throws SQLException {
//        return (Brand[]) super.findAll();
//    }
}
