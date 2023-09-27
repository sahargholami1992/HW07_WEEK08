package org.example.service;

import org.example.base.service.BaseEntityService;
import org.example.domain.Category;

import java.sql.SQLException;

public interface CategoryService extends BaseEntityService {
    Category[] getCategory() throws SQLException;
}
