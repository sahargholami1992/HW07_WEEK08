package org.example.service;

import org.example.base.service.BaseEntityService;
import org.example.domain.Brand;

import java.sql.SQLException;

public interface BrandService extends BaseEntityService {
    Brand[] getBrands() throws SQLException;
}
