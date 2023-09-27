package org.example.service.impl;

import org.example.base.repository.BaseEntityRepository;
import org.example.base.service.impl.BaseEntityServiceImpl;
import org.example.service.ProductService;


public class ProductServiceImpl extends BaseEntityServiceImpl
        implements ProductService {
    public ProductServiceImpl(BaseEntityRepository baseRepository) {
        super(baseRepository);
    }
}
